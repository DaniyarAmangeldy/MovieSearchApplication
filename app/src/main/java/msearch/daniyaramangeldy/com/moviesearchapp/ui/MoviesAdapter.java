package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import msearch.daniyaramangeldy.com.moviesearchapp.R;
import msearch.daniyaramangeldy.com.moviesearchapp.data.model.Movie;

public class MoviesAdapter extends ListAdapter<Movie, MovieViewHolder> {

    private Picasso mPicasso;

    protected MoviesAdapter(@NonNull MoviesDiffUtil diffCallback, @NonNull Picasso picasso) {
        super(diffCallback);
        mPicasso = picasso;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details_item, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(getItem(position), mPicasso);
    }
}
