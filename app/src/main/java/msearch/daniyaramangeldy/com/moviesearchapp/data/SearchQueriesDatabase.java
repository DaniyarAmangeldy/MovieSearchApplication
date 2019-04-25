package msearch.daniyaramangeldy.com.moviesearchapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.SearchQueryDatabaseModel;
import msearch.daniyaramangeldy.com.moviesearchapp.data.repository.SearchDao;

@Database(entities = {SearchQueryDatabaseModel.class}, version = 1)
public abstract class SearchQueriesDatabase extends RoomDatabase {

    public abstract SearchDao getSearchDao();
}
