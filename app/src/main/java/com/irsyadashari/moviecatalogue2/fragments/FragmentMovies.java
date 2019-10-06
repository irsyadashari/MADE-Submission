package com.irsyadashari.moviecatalogue2.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.irsyadashari.moviecatalogue2.models.Movie;
import com.irsyadashari.moviecatalogue2.R;
import com.irsyadashari.moviecatalogue2.Adapter.RecyclerViewAdapterMovie;

import java.util.ArrayList;

public class FragmentMovies extends Fragment {

    View v;
    private String[] movieTitle;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private RecyclerView recyclerView;
    private ArrayList<Movie> listMovie;


    public FragmentMovies() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.movie_fragment, container , false);
        recyclerView = v.findViewById(R.id.movies_recyclerview);
        RecyclerViewAdapterMovie recyclerViewAdapterMovie = new RecyclerViewAdapterMovie(getContext(),listMovie);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterMovie);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepare();
        addItem();
    }

    private void prepare(){
        movieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataDescription = getResources().getStringArray(R.array.data_movie_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem(){
        listMovie = new ArrayList<>();

        for(int i = 0; i< movieTitle.length; i++){
            Movie movie = new Movie();
            movie.setMoviePoster(dataPhoto.getResourceId(i,-1));
            movie.setMovieTitle(movieTitle[i]);
            movie.setMovieDescription(dataDescription[i]);
            listMovie.add(movie);
        }
    }


}
