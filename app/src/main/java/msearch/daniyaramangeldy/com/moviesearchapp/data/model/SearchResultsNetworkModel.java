package msearch.daniyaramangeldy.com.moviesearchapp.data.model;


import java.util.List;

import androidx.annotation.NonNull;

public class SearchResultsNetworkModel {
    @NonNull
    public List<Movie> Search;
    @NonNull
    public String Response;

    public SearchResultsNetworkModel(@NonNull List<Movie> search, @NonNull String response) {
        Search = search;
        Response = response;
    }

    public SearchResultsNetworkModel() {}
}