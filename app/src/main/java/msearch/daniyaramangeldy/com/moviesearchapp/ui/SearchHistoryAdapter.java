package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.ListAdapter;
import msearch.daniyaramangeldy.com.moviesearchapp.R;

public class SearchHistoryAdapter extends ListAdapter<String, SearchQueryViewHolder> {

    @Nullable
    private Consumer<String> mOnClickCallback;

    protected SearchHistoryAdapter(
            @NonNull SearchHistoryDiffUtil diffCallback,
            @Nullable Consumer<String> onClickCallback
    ) {
        super(diffCallback);
        mOnClickCallback = onClickCallback;
    }

    @NonNull
    @Override
    public SearchQueryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_query_item, parent, false);

        return new SearchQueryViewHolder(view, mOnClickCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchQueryViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public void onViewRecycled(@NonNull SearchQueryViewHolder holder) {
        holder.recycle();
        super.onViewRecycled(holder);
    }
}