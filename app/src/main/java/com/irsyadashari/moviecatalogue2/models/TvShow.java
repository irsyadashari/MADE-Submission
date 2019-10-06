package com.irsyadashari.moviecatalogue2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private String tvShowTitle;
    private String tvShowDescription;
    private int tvShowPoster;

    public TvShow() {
    }

    public TvShow(String tvShowTitle, String tvShowDescription, int tvShowPoster) {
        this.tvShowTitle = tvShowTitle;
        this.tvShowDescription = tvShowDescription;
        this.tvShowPoster = tvShowPoster;
    }

    public String getTvShowTitle() {
        return tvShowTitle;
    }

    public void setTvShowTitle(String tvShowTitle) {
        this.tvShowTitle = tvShowTitle;
    }

    public String getTvShowDescription() {
        return tvShowDescription;
    }

    public void setTvShowDescription(String tvShowDescription) {
        this.tvShowDescription = tvShowDescription;
    }

    public int getTvShowPoster() {
        return tvShowPoster;
    }

    public void setTvShowPoster(int tvShowPoster) {
        this.tvShowPoster = tvShowPoster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tvShowTitle);
        dest.writeString(this.tvShowDescription);
        dest.writeInt(this.tvShowPoster);
    }

    protected TvShow(Parcel in) {
        this.tvShowTitle = in.readString();
        this.tvShowDescription = in.readString();
        this.tvShowPoster = in.readInt();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
