package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.util.Log;

import java.util.List;

import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.Movie;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;

public class SearchResultsViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoadingStateLiveData = new MutableLiveData<>();

    private MoviesInteractor mMoviesInteractor;

    private CompositeDisposable mDisposableList = new CompositeDisposable();

    SearchResultsViewModel(MoviesInteractor interactor) {
        mMoviesInteractor = interactor;
    }

    void setQuery(@NonNull String query) {
        mDisposableList.add(
                mMoviesInteractor
                        .saveQuery(query)
                        .andThen(mMoviesInteractor.searchMovieByQuery(query))
                        .doOnSubscribe((disposable) -> isLoadingStateLiveData.postValue(true))
                        .doFinally(() -> isLoadingStateLiveData.postValue(false))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                movies -> moviesLiveData.setValue(movies),
                                error -> Log.e("Error", "Cannot load movies", error)
                        )
        );
    }

    @Override
    protected void onCleared() {
        mDisposableList.dispose();
        super.onCleared();
    }

    public MutableLiveData<List<Movie>> getMoviesLiveData() {
        return moviesLiveData;
    }

    public MutableLiveData<Boolean> getIsLoadingStateLiveData() {
        return isLoadingStateLiveData;
    }

    public static class Factory implements ViewModelProvider.Factory {

        private Provider<SearchResultsViewModel> mProvider;

        public Factory(Provider<SearchResultsViewModel> provider) {
            mProvider = provider;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) mProvider.get();
        }
    }
}
