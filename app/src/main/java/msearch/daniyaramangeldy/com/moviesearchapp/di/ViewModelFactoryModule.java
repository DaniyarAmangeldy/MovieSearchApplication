package msearch.daniyaramangeldy.com.moviesearchapp.di;

import javax.inject.Provider;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.MainViewModel;

@Module
public class ViewModelFactoryModule {

    @Provides
    ViewModelProvider.Factory provideMainViewModelFactory(Provider<MainViewModel> provider) {
        return new MainViewModel.Factory(provider);
    }

    @Provides
    MainViewModel provideMainViewModel(ViewModelProvider.Factory factory) {
        return factory.create(MainViewModel.class);
    }
}
