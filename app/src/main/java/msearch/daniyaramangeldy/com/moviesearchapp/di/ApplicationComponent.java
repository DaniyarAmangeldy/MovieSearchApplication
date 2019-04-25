package msearch.daniyaramangeldy.com.moviesearchapp.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import msearch.daniyaramangeldy.com.moviesearchapp.App;

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
@Singleton
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App app);

        ApplicationComponent build();
    }

    void inject(App app);
}