package com.example.moviecatalogueendpart1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";

    private TextView movieTitle;
    private TextView movieDescription;
    private ImageView moviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        movieTitle = findViewById(R.id.tv_movie_title);
        movieDescription = findViewById(R.id.tv_movie_description);
        moviePoster = findViewById(R.id.movie_poster);

        //object movie yang dikirim dari MainActivity
        Movie movie = getIntent().getParcelableExtra(EXTRA_DATA);

        movieTitle.setText(movie.getMovieTitle());
        movieDescription.setText(movie.getMovieDescription());
        moviePoster.setImageResource(movie.getMoviePoster());

    }
}
