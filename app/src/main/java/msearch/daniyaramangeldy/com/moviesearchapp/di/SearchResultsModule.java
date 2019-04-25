package msearch.daniyaramangeldy.com.moviesearchapp.di;

import dagger.Module;
import dagger.Provides;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.SearchResultsViewModel;

@Module
public class SearchResultsModule {

    @Provides
    SearchResultsViewModel.Factory provideSearchResultsViewModelFactory(MoviesInteractor interactor) {
        return new SearchResultsViewModel.Factory(interactor);
    }
}