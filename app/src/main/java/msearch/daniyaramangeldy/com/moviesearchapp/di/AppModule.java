package msearch.daniyaramangeldy.com.moviesearchapp.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.MoviesRemoteRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.SearchDao;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context provideContext() {
        return application.getApplicationContext();
    }



    @Provides
    public MoviesInteractor provideInteractor(
            MoviesRemoteRepository remoteRepository,
            SearchDao searchDao
    ) {
        return new MoviesInteractor(remoteRepository, searchDao);
    }
}
