package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.Movie;

public class MoviesDiffUtil extends DiffUtil.ItemCallback<Movie> {

    @Override
    public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.id.equals(newItem.id);
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.title.equals(newItem.title) &&
                oldItem.year.equals(newItem.year) &&
                oldItem.posterUrl.equals(newItem.posterUrl) &&
                oldItem.type.equals(newItem.title);
    }
}
