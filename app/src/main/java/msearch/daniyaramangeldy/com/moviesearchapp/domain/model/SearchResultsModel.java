package msearch.daniyaramangeldy.com.moviesearchapp.domain.model;


import java.util.List;

import androidx.annotation.NonNull;

public class SearchResultsModel {
    @NonNull
    public List<Movie> Search;
    @NonNull
    public String Response;

    public SearchResultsModel(@NonNull List<Movie> search, @NonNull String response) {
        Search = search;
        Response = response;
    }

    public SearchResultsModel() {}
}