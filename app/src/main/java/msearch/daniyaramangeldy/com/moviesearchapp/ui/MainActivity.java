package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel.Factory viewModelFactory;

    @NonNull
    private MainViewModel mViewModel;
    @NonNull
    private RecyclerView mSearchQueriesRecyclerView;
    @NonNull
    SearchHistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchQueriesRecyclerView = findViewById(R.id.search_history_list);
        setupAdapter();
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        observeViewModel();
        mViewModel.setQuery("Matrix");
    }

    private void observeViewModel() {
        mViewModel.moviesLiveData.observe(this, this::onMoviesLoaded);
    }

    private void setupAdapter() {
        mAdapter = new SearchHistoryAdapter(new SearchHistoryDiffUtil(), Picasso.get());
        mSearchQueriesRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSearchQueriesRecyclerView.setAdapter(mAdapter);
    }

    private void onMoviesLoaded(@NonNull List<Movie> movies) {
        mAdapter.submitList(movies);
    }
}