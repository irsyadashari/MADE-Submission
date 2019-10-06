package com.irsyadashari.moviecatalogue2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.irsyadashari.moviecatalogue2.DetailActivity;
import com.irsyadashari.moviecatalogue2.R;
import com.irsyadashari.moviecatalogue2.models.Movie;
import com.irsyadashari.moviecatalogue2.models.TvShow;

import java.util.List;

public class RecyclerViewAdapterTvshow extends RecyclerView.Adapter<RecyclerViewAdapterTvshow.MyViewHolder> {


    Context mContext;
    List<TvShow> mData;

    public RecyclerViewAdapterTvshow(Context mContext, List<TvShow> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterTvshow.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        viewHolder.item_tvshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mData.get(viewHolder.getAdapterPosition()).getTvShowTitle(),Toast.LENGTH_SHORT).show();
                goToDetail(mData.get(viewHolder.getAdapterPosition()));
            }
        });

        return viewHolder;
    }

    private void goToDetail(TvShow data){
        TvShow tvShow = new TvShow();
        tvShow.setTvShowTitle(data.getTvShowTitle());
        tvShow.setTvShowDescription(data.getTvShowDescription());
        tvShow.setTvShowPoster(data.getTvShowPoster());

        Intent intentWithObjData = new Intent(mContext, DetailActivity.class);
        intentWithObjData.putExtra(DetailActivity.EXTRA_DATA, tvShow);
        mContext.startActivity(intentWithObjData);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterTvshow.MyViewHolder holder, int i) {

        holder.tv_title.setText(mData.get(i).getTvShowTitle());
        holder.tv_description.setText(mData.get(i).getTvShowDescription());
        holder.tv_poster.setImageResource(mData.get(i).getTvShowPoster());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout item_tvshow;
        private TextView tv_title;
        private TextView tv_description;
        private ImageView tv_poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_tvshow = itemView.findViewById(R.id.movie_item_id);
            tv_title = itemView.findViewById(R.id.tv_movie_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_poster = itemView.findViewById(R.id.img_movie_poster);

        }
    }
}
