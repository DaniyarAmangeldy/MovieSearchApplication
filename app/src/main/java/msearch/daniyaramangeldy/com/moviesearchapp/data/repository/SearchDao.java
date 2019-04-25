package msearch.daniyaramangeldy.com.moviesearchapp.data.repository;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.SearchQueryDatabaseModel;

@Dao
public interface SearchDao {

    @Query("SELECT * FROM SearchQueryDatabaseModel")
    List<SearchQueryDatabaseModel> getSearchQueries();

    @Insert
    void insertQuery(SearchQueryDatabaseModel query);
}
