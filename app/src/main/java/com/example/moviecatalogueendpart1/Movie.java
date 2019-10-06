package com.example.moviecatalogueendpart1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int moviePoster;
    private String movieTitle;
    private String movieDescription;

    
    public int getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(int moviePoster) {
        this.moviePoster = moviePoster;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.moviePoster);
        dest.writeString(this.movieTitle);
        dest.writeString(this.movieDescription);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.moviePoster = in.readInt();
        this.movieTitle = in.readString();
        this.movieDescription = in.readString();
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
