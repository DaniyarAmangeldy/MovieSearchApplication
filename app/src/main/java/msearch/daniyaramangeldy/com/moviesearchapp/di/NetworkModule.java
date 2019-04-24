package msearch.daniyaramangeldy.com.moviesearchapp.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import msearch.daniyaramangeldy.com.moviesearchapp.BuildConfig;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.MoviesRemoteRepository;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public MoviesRemoteRepository provideRemoteRepository() {
        return new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.API_ENDPOINT)
                .build()
                .create(MoviesRemoteRepository.class);
    }
}
