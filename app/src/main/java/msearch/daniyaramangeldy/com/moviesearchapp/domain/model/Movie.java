package msearch.daniyaramangeldy.com.moviesearchapp.domain.model;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Movie {
    @SerializedName("imdbID")
    @NonNull
    public String id;
    @SerializedName("Title")
    @NonNull
    public String title;
    @SerializedName("Year")
    @NonNull
    public String year;
    @SerializedName("Poster")
    @NonNull
    public String posterUrl;
    @SerializedName("Type")
    @NonNull
    public String type;

    public Movie(@NonNull String id, @NonNull String title, @NonNull String year, @NonNull String posterUrl, @NonNull String type) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.posterUrl = posterUrl;
        this.type = type;
    }

    public Movie() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getYear() {
        return year;
    }

    public void setYear(@NonNull String year) {
        this.year = year;
    }

    @NonNull
    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(@NonNull String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Movie) {
            Movie other = (Movie) obj;
            return id.equals(other.id) &&
                    title.equals(other.title) &&
                    year.equals(other.year) &&
                    posterUrl.equals(other.posterUrl) &&
                    type.equals(other.type);
        }
        return false;
    }
}
