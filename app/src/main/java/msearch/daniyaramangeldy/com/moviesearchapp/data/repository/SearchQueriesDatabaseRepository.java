package msearch.daniyaramangeldy.com.moviesearchapp.data.repository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.SearchQueryDatabaseModel;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.repository.SearchQueryRepository;

public class SearchQueriesDatabaseRepository implements SearchQueryRepository {

    private SearchDao mSearchDao;

    public SearchQueriesDatabaseRepository(SearchDao searchDao) {
        mSearchDao = searchDao;
    }

    @Override
    public Flowable<List<String>> getSearchQueries() {
        return mSearchDao.getSearchQueries()
                .map(list -> {
                    List<String> queries = new ArrayList();
                    for (SearchQueryDatabaseModel item : list) {
                        queries.add(item.getQuery());
                    }
                    return queries;
                });
    }

    @Override
    public Completable insertSearchQuery(@NonNull String query) {
        return Completable
                .fromAction(() ->
                        mSearchDao.insertQuery(new SearchQueryDatabaseModel(query))
                );
    }
}