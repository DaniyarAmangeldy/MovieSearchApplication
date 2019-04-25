package msearch.daniyaramangeldy.com.moviesearchapp.domain.repository;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public interface SearchQueryRepository {

    Flowable<List<String>> getSearchQueries();

    Completable insertSearchQuery(@NonNull String query);
}