package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.view.View;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;
import msearch.daniyaramangeldy.com.moviesearchapp.R;

public class SearchQueryViewHolder extends RecyclerView.ViewHolder {

    @Nullable
    private Consumer<String> mOnClickCallback;
    @Nullable
    private String mCurrentItem;
    private TextView textView;

    public SearchQueryViewHolder(@NonNull View itemView, @Nullable Consumer<String> onClickCallback) {
        super(itemView);
        textView = itemView.findViewById(R.id.item);
        mOnClickCallback = onClickCallback;
        itemView.setOnClickListener(v -> {
            if (mOnClickCallback == null || mCurrentItem == null) {
                return;
            }
            mOnClickCallback.accept(mCurrentItem);
        });
    }

    public void bind(@NonNull String query) {
        mCurrentItem = query;
        textView.setText(query);
    }

    public void recycle() {
        mCurrentItem = null;
        mOnClickCallback = null;
    }
}