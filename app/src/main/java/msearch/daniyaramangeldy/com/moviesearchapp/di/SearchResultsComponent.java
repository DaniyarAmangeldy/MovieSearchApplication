package msearch.daniyaramangeldy.com.moviesearchapp.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.SearchResultsActivity;

@Subcomponent(modules = SearchResultsModule.class)
public interface SearchResultsComponent extends AndroidInjector<SearchResultsActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SearchResultsActivity>{}
}