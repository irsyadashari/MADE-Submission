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
import com.irsyadashari.moviecatalogue2.MainActivity;
import com.irsyadashari.moviecatalogue2.R;
import com.irsyadashari.moviecatalogue2.models.Movie;

import java.util.List;

public class RecyclerViewAdapterMovie extends RecyclerView.Adapter<RecyclerViewAdapterMovie.MyViewHolder> {

    Context mContext;
    List<Movie> mData;

    public RecyclerViewAdapterMovie(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        viewHolder.item_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mData.get(viewHolder.getAdapterPosition()).getMovieTitle(),Toast.LENGTH_SHORT).show();

                //GO TO DETAIL ACTIVITY
                goToDetail(mData.get(viewHolder.getAdapterPosition()));

            }
        });

        return viewHolder;
    }

    private void goToDetail(Movie data){
        Movie movie = new Movie();
        movie.setMovieTitle(data.getMovieTitle());
        movie.setMovieDescription(data.getMovieDescription());
        movie.setMoviePoster(data.getMoviePoster());

        Intent intentWithObjData = new Intent(mContext, DetailActivity.class);
        intentWithObjData.putExtra(DetailActivity.EXTRA_DATA, movie);
        mContext.startActivity(intentWithObjData);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.tv_title.setText(mData.get(i).getMovieTitle());
        holder.tv_description.setText(mData.get(i).getMovieDescription());
        holder.movie_poster.setImageResource(mData.get(i).getMoviePoster());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout item_movie;
        private TextView tv_title;
        private TextView tv_description;
        private ImageView movie_poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_movie = itemView.findViewById(R.id.movie_item_id);
            tv_title = itemView.findViewById(R.id.tv_movie_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            movie_poster = itemView.findViewById(R.id.img_movie_poster);
        }
    }
}
