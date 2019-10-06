package com.irsyadashari.moviecatalogue2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.irsyadashari.moviecatalogue2.models.Movie;
import com.irsyadashari.moviecatalogue2.models.TvShow;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";

    private TextView mTitle;
    private TextView mDescription;
    private ImageView mPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = findViewById(R.id.tv_movie_title);
        mDescription = findViewById(R.id.tv_movie_description);
        mPoster = findViewById(R.id.movie_poster);

        Object data = getIntent().getParcelableExtra(EXTRA_DATA);

        if(data.getClass() == Movie.class)
        {
            Movie movie = Movie.class.cast(data);
            mTitle.setText(movie.getMovieTitle());
            mDescription.setText(movie.getMovieDescription());
            mPoster.setImageResource(movie.getMoviePoster());
        }
        else
        {
            TvShow tvShow = TvShow.class.cast(data);
            mTitle.setText(tvShow.getTvShowTitle());
            mDescription.setText(tvShow.getTvShowDescription());
            mPoster.setImageResource(tvShow.getTvShowPoster());
        }
    }
}
