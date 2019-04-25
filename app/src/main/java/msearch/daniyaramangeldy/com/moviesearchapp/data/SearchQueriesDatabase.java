package msearch.daniyaramangeldy.com.moviesearchapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.SearchQueryDatabaseModel;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.SearchDao;

@Database(entities = {SearchQueryDatabaseModel.class}, version = SearchQueriesDatabase.VERSION)
public abstract class SearchQueriesDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract SearchDao getSearchDao();
}
