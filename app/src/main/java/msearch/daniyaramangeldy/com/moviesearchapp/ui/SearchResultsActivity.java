package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import msearch.daniyaramangeldy.com.moviesearchapp.R;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.Movie;

public class SearchResultsActivity extends AppCompatActivity {

    private static final String EXTRA_QUERY = "extra_query";

    @Inject
    SearchResultsViewModel.Factory viewModelFactory;
    @Inject
    Picasso mPicasso;

    @NonNull
    private SearchResultsViewModel mViewModel;
    @NonNull
    private ProgressBar mProgressBar;
    @NonNull
    private RecyclerView mRecyclerView;
    @NonNull
    MoviesAdapter mAdapter;

    public static Intent createIntent(@NonNull Context context, @NonNull String query) {
        return new Intent(context, SearchResultsActivity.class).putExtra(EXTRA_QUERY, query);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchResultsViewModel.class);
        setupViews();
        observeViewModel();
        String query = getIntent().getStringExtra(EXTRA_QUERY);
        mViewModel.setQuery(query);
    }

    private void setupViews() {
        mProgressBar = findViewById(R.id.progress);
        mRecyclerView = findViewById(R.id.movies_list);
        mAdapter = new MoviesAdapter(new MoviesDiffUtil(), mPicasso);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void observeViewModel() {
        mViewModel.getIsLoadingStateLiveData().observe(this, this::onResultsLoading);
        mViewModel.getMoviesLiveData().observe(this, this::onResultsLoaded);
    }

    private void onResultsLoading(boolean isLoading) {
        if (isLoading) {
            mProgressBar.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void onResultsLoaded(List<Movie> movies) {
        mAdapter.submitList(movies);
    }
}