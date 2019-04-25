package msearch.daniyaramangeldy.com.moviesearchapp.data.repository;

import io.reactivex.Single;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.model.SearchResultsModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface MoviesRemoteRepository {

    @GET
    Single<SearchResultsModel> searchMovie(
            @Url String path,
            @Query("apikey") String key,
            @Query("s") String query
    );
}
