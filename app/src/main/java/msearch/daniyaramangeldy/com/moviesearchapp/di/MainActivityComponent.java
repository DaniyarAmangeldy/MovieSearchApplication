package msearch.daniyaramangeldy.com.moviesearchapp.di;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.MainActivity;

@Subcomponent(modules = MainModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> { }
}