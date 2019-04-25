package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.Movie;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;
import msearch.daniyaramangeldy.com.moviesearchapp.infrastructure.SingleLiveEvent;

public class MainViewModel extends ViewModel {

    private final static String TAG = MainViewModel.class.getName();

    private MutableLiveData<List<String>> mSearchQueriesLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsSearchQueriesLoadingLiveData = new MutableLiveData<>();
    private MutableLiveData<String> mOnSearchClickedEvent = new SingleLiveEvent<>();

    private MoviesInteractor mMoviesInteractor;

    private CompositeDisposable mDisposableList = new CompositeDisposable();

    public MainViewModel(MoviesInteractor interactor) {
        mMoviesInteractor = interactor;
    }


    public MutableLiveData<List<String>> getSearchQueriesLiveData() {
        return mSearchQueriesLiveData;
    }

    public void onStart() {
        mDisposableList.add(
        mMoviesInteractor
                .getQueries()
                .doOnSubscribe(disposable -> mIsSearchQueriesLoadingLiveData.postValue(true))
                .doFinally(() -> mIsSearchQueriesLoadingLiveData.postValue(false))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        queries -> mSearchQueriesLiveData.setValue(queries),
                        error -> Log.e(TAG, "Error while getting search queries from database", error)
                )
        );
    }

    public void onSearchClicked(@NonNull String query) {
        mOnSearchClickedEvent.setValue(query);
    }

    public MutableLiveData<Boolean> getIsSearchQueriesLoadingLiveData() {
        return mIsSearchQueriesLoadingLiveData;
    }



    @Override
    protected void onCleared() {
        mDisposableList.dispose();
        super.onCleared();
    }

    public static class Factory implements ViewModelProvider.Factory {

        private MoviesInteractor mInteractor;

        public Factory(MoviesInteractor interactor) {
            mInteractor = interactor;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(mInteractor);
        }
    }

}