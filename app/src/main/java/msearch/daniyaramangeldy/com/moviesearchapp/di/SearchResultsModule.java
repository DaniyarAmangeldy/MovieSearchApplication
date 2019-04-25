package msearch.daniyaramangeldy.com.moviesearchapp.di;

import javax.inject.Provider;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.SearchResultsViewModel;

@Module
public class SearchResultsModule {

    @Provides
    ViewModelProvider.Factory provideSearchResultsViewModelFactory(Provider<SearchResultsViewModel> provider) {
        return new SearchResultsViewModel.Factory(provider);
    }

    @Provides
    SearchResultsViewModel provideMainViewModel(ViewModelProvider.Factory factory) {
        return factory.create(SearchResultsViewModel.class);
    }
}
