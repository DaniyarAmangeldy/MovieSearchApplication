package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import msearch.daniyaramangeldy.com.moviesearchapp.R;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel.Factory viewModelFactory;

    @NonNull
    private MainViewModel mViewModel;
    @NonNull
    private RecyclerView mSearchQueriesRecyclerView;
    @NonNull
    private TextInputEditText mSearchEditText;
    @NonNull
    SearchHistoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        observeViewModel();
    }


    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    private void observeViewModel() {
        mViewModel.getSearchQueriesLiveData().observe(this, this::onSearchQueriesLoaded);
        mViewModel.getOnSearchClickedEvent().observe(this, this::navigateToSearchResults);
    }

    private void setupViews() {
        mSearchQueriesRecyclerView = findViewById(R.id.search_history_list);
        mSearchEditText = findViewById(R.id.search_input_edit_text);
        findViewById(R.id.button_search).setOnClickListener(this::onSearchButtonClicked);
        mAdapter = new SearchHistoryAdapter(new SearchHistoryDiffUtil(), query -> mViewModel.searchItem(query));
        mSearchQueriesRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mSearchQueriesRecyclerView.setAdapter(mAdapter);
    }

    private void onSearchQueriesLoaded(@NonNull List<String> queries) {
        mAdapter.submitList(queries);
    }

    private void navigateToSearchResults(@NonNull String query) {
        startActivity(SearchResultsActivity.createIntent(getApplicationContext(), query));
    }

    private void onSearchButtonClicked(View view) {
        Editable editable = mSearchEditText.getText();
        if (editable == null) {
            return;
        }
        mViewModel.searchItem(editable.toString());
    }
}