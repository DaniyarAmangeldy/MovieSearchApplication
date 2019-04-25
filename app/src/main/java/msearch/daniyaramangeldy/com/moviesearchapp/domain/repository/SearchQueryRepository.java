package msearch.daniyaramangeldy.com.moviesearchapp.domain.repository;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Single;

public interface SearchQueryRepository {

    Single<List<String>> getSearchQueries();

    Completable insertSearchQuery(@NonNull String query);
}