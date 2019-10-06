package com.example.moviecatalogueendpart1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//CREATED BY MUHAMMAD IRSYAD ASHARI at 24 September 2019
// HIDUP MAHASISWA!!!
// #SAVEKPK
// pagi demonstrasi, malam coding di dicoding

public class MainActivity extends AppCompatActivity {

    private String[] movieTitle;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, movies.get(position).getMovieTitle(), Toast.LENGTH_SHORT).show();

                //TODO:GO TO DETAIL ACTIVITY
                GoToDetailActivity(movies.get(position));

            }
        });
    }

    private void GoToDetailActivity(Movie data){
        Movie movie = new Movie();
        movie.setMovieTitle(data.getMovieTitle());
        movie.setMovieDescription(data.getMovieDescription());
        movie.setMoviePoster(data.getMoviePoster());

        Intent intentWithObjData = new Intent(MainActivity.this, DetailActivity.class);
        intentWithObjData.putExtra(DetailActivity.EXTRA_DATA, movie);
        startActivity(intentWithObjData);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for(int i = 0; i < movieTitle.length; i++){
            Movie movie = new Movie();
            movie.setMoviePoster(dataPhoto.getResourceId(i,-1));
            movie.setMovieTitle(movieTitle[i]);
            movie.setMovieDescription(dataDescription[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        movieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataDescription = getResources().getStringArray(R.array.data_movie_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

}
