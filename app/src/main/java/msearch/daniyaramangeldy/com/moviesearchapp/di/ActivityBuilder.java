package msearch.daniyaramangeldy.com.moviesearchapp.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.MainActivity;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.SearchResultsActivity;

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(
            MainActivityComponent.Builder builder
    );

    @Binds
    @IntoMap
    @ActivityKey(SearchResultsActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindSearchResultActivity(
            SearchResultsComponent.Builder builder
    );
}