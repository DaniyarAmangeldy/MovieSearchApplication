package msearch.daniyaramangeldy.com.moviesearchapp.domain.interactor;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Single;
import msearch.daniyaramangeldy.com.moviesearchapp.BuildConfig;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.Movie;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.MoviesRemoteRepository;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.repository.SearchQueryRepository;

public class MoviesInteractor {

    private MoviesRemoteRepository mRepository;
    private SearchQueryRepository mSearchQueriesRepository;

    public MoviesInteractor(MoviesRemoteRepository repository, SearchQueryRepository searchQueriesRepository) {
        mRepository = repository;
        mSearchQueriesRepository = searchQueriesRepository;
    }

    public Completable saveQuery(String query) {
        return mSearchQueriesRepository.insertSearchQuery(query);
    }

    public Single<List<String>> getQueries() {
        return mSearchQueriesRepository.getSearchQueries();
    }

    @NonNull
    public Single<List<Movie>> searchMovieByQuery(@NonNull String query) {
        return mRepository
                .searchMovie(BuildConfig.API_ENDPOINT, BuildConfig.API_KEY, query)
                .map((response) -> {
                    if (response.Response.equals("True")) {
                        return response.Search;
                    } else {
                        return new ArrayList<>();
                    }
                });
    }
}
