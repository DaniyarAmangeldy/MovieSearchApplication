package msearch.daniyaramangeldy.com.moviesearchapp.di;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = { AppModule.class, NetworkModule.class })
interface ApplicationComponent {
}
