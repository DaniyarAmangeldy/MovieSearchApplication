package msearch.daniyaramangeldy.com.moviesearchapp.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import msearch.daniyaramangeldy.com.moviesearchapp.ui.MainActivity;

@Module
public abstract class MainModule {

    @ContributesAndroidInjector(modules = { ViewModelFactoryModule.class })
    public abstract MainActivity bind();
}
