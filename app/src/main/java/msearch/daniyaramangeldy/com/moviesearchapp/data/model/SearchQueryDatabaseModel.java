package msearch.daniyaramangeldy.com.moviesearchapp.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SearchQueryDatabaseModel {

    @PrimaryKey
    @NonNull
    private String query;

    @NonNull
    public String getQuery() {
        return query;
    }

    public void setQuery(@NonNull String query) {
        this.query = query;
    }

    public SearchQueryDatabaseModel(@NonNull String query) {
        this.query = query;
    }
}