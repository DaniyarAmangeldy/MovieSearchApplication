package msearch.daniyaramangeldy.com.moviesearchapp.data.repository;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Flowable;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.SearchQueryDatabaseModel;

@Dao
public interface SearchDao {

    @Query("SELECT * FROM SearchQueryDatabaseModel")
    Flowable<List<SearchQueryDatabaseModel>> getSearchQueries();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuery(SearchQueryDatabaseModel query);
}