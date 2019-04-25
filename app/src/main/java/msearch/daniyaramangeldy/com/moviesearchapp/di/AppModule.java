package msearch.daniyaramangeldy.com.moviesearchapp.di;

import android.content.Context;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import msearch.daniyaramangeldy.com.moviesearchapp.App;
import msearch.daniyaramangeldy.com.moviesearchapp.BuildConfig;
import msearch.daniyaramangeldy.com.moviesearchapp.data.SearchQueriesDatabase;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.MoviesRemoteRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.SearchDao;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.SearchQueriesDatabaseRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor.MoviesInteractor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.repository.SearchQueryRepository;

@Module(subcomponents = { MainActivityComponent.class, SearchResultsComponent.class} )
public class AppModule {

    private static final String DATABASE_NAME = "SEARCH_DATABASE";

    @Provides
    @Singleton
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    public MoviesInteractor provideInteractor(
            MoviesRemoteRepository remoteRepository,
            SearchQueryRepository searchQueriesRepository
    ) {
        return new MoviesInteractor(remoteRepository, searchQueriesRepository);
    }

    @Provides
    @Singleton
    public MoviesRemoteRepository provideRemoteRepository(Retrofit retrofit) {
        return retrofit.create(MoviesRemoteRepository.class);
    }

    @Provides
    @Singleton
    public SearchDao provideDao(Context context) {
        return Room
                .databaseBuilder(context, SearchQueriesDatabase.class, DATABASE_NAME)
                .build()
                .getSearchDao();
    }

    @Provides
    @Singleton
    public SearchQueryRepository provideSearchQueryRepository(SearchDao searchDao) {
        return (SearchQueryRepository) new SearchQueriesDatabaseRepository(searchDao);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.API_ENDPOINT)
                .build();
    }
}