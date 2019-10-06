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

import com.irsyadashari.moviecatalogue2.Adapter.RecyclerViewAdapterTvshow;
import com.irsyadashari.moviecatalogue2.R;
import com.irsyadashari.moviecatalogue2.models.TvShow;

import java.util.ArrayList;

public class FragmentTvShow extends Fragment {

    View v;
    private String[] tvshowTitle;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private RecyclerView recyclerView;
    private ArrayList<TvShow> listTVshow;



    public FragmentTvShow() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tvshow_fragment, container , false);
        recyclerView = v.findViewById(R.id.tvshow_recyclerview);
        RecyclerViewAdapterTvshow recyclerViewAdapterTvshow = new RecyclerViewAdapterTvshow(getContext(),listTVshow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterTvshow);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepare();
        addItem();
    }

    private void prepare(){
        tvshowTitle = getResources().getStringArray(R.array.data_tvshow_title);
        dataDescription = getResources().getStringArray(R.array.data_tvshow_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_tvshow_photo);
    }

    private void addItem(){
        listTVshow = new ArrayList<>();

        for(int i = 0; i< tvshowTitle.length; i++){
            TvShow tvShow = new TvShow();
            tvShow.setTvShowPoster(dataPhoto.getResourceId(i,-1));
            tvShow.setTvShowTitle(tvshowTitle[i]);
            tvShow.setTvShowDescription(dataDescription[i]);
            listTVshow.add(tvShow);
        }
    }

}
