package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;

public class MainViewModel extends ViewModel {

    private MoviesInteractor mInteractor;

    public MainViewModel(MoviesInteractor interactor) {
        mInteractor = interactor;
    }

    public static class Factory implements ViewModelProvider.Factory {

        private Provider<MainViewModel> mProvider;

        public Factory(Provider<MainViewModel> provider) {
            mProvider = provider;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) mProvider.get();
        }
    }

}
