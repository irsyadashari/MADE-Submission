package com.irsyadashari.moviecatalogue2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String movieTitle;
    private String movieDescription;
    private int moviePoster;


    //CONSTRUCTORS
    public Movie(){

    }

    public Movie(String movieTitle, String movieDescription, int moviePoster) {
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
        this.moviePoster = moviePoster;
    }


    //SETTER GETTER
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(int moviePoster) {
        this.moviePoster = moviePoster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movieTitle);
        dest.writeString(this.movieDescription);
        dest.writeInt(this.moviePoster);
    }

    protected Movie(Parcel in) {
        this.movieTitle = in.readString();
        this.movieDescription = in.readString();
        this.moviePoster = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
