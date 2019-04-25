package msearch.daniyaramangeldy.com.moviesearchapp.di;

import dagger.Module;
import dagger.Provides;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.MainViewModel;

@Module
public class MainModule {

    @Provides
    MainViewModel.Factory provideMainViewModelFactory(MoviesInteractor interactor) {
        return new MainViewModel.Factory(interactor);
    }
}