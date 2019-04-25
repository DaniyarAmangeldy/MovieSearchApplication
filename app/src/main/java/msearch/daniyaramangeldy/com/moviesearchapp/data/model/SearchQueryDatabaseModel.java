package msearch.daniyaramangeldy.com.moviesearchapp.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SearchQueryDatabaseModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "username")
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getId() {
        return id;
    }

    public SearchQueryDatabaseModel(int id, String query) {
        this.id = id;
        this.query = query;
    }
}
