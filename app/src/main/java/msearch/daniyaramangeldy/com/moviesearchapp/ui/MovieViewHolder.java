package msearch.daniyaramangeldy.com.moviesearchapp.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import msearch.daniyaramangeldy.com.moviesearchapp.R;
import msearch.daniyaramangeldy.com.moviesearchapp.domain.model.Movie;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView mPoster;
    private TextView mTitle;
    private TextView mYear;
    private TextView mType;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        mPoster = itemView.findViewById(R.id.poster);
        mTitle = itemView.findViewById(R.id.title);
        mYear = itemView.findViewById(R.id.year);
        mType = itemView.findViewById(R.id.type);
    }

    void bind(Movie movie, Picasso picasso) {
        picasso.load(movie.getPosterUrl()).into(mPoster);
        mTitle.setText(movie.getTitle());
        mYear.setText(movie.getYear());
        mType.setText(movie.getType());
    }
}