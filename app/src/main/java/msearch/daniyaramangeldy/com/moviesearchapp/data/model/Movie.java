package msearch.daniyaramangeldy.com.moviesearchapp.data.model;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

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
}
