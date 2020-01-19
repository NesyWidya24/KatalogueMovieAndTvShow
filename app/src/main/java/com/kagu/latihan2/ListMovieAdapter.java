package com.kagu.latihan2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie;
    Context context;

    public ArrayList<Movie> getListMovies(){
        return listMovie;
    }

    public ListMovieAdapter(Context context, ArrayList<Movie> list) {
        this.listMovie = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_movies, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Movie movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(75, 75))
                .into(holder.imgPhoto);

        holder.tvName.setText(movie.getName());
        holder.tvSinopsis.setText(movie.getSinopsis());
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvSinopsis;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvSinopsis = itemView.findViewById(R.id.tv_item_sinopsis);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Movie movie = getListMovies().get(position);

            movie.setName(movie.getName());
            movie.setSinopsis(movie.getSinopsis());
            movie.setPhoto(movie.getPhoto());

            Intent intent = new Intent(itemView.getContext(),DetailMoviesActivity.class);
            intent.putExtra(DetailMoviesActivity.EXTRA_MOVIES, movie);
            context.startActivity(intent);

        }
    }
}
