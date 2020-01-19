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

public class ListTvShowAdapter extends RecyclerView.Adapter<ListTvShowAdapter.ListViewHolder> {
    private ArrayList<TvShow> listTvShow;
    Context context;

    public ArrayList<TvShow> getListTvShows(){
        return listTvShow;
    }

    public ListTvShowAdapter(Context context, ArrayList<TvShow> list) {
        this.listTvShow = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_tvshows, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        TvShow tvShow = listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPhoto())
                .apply(new RequestOptions().override(75, 75))
                .into(holder.imgPhoto);

        holder.tvName.setText(tvShow.getName());
        holder.tvDesc.setText(tvShow.getDesc());
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvDesc;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo_tvshow);
            tvName = itemView.findViewById(R.id.tv_item_name_tvshow);
            tvDesc = itemView.findViewById(R.id.tv_item_desc_tvshow);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            TvShow tvShow = getListTvShows().get(position);

            tvShow.setName(tvShow.getName());
            tvShow.setDesc(tvShow.getDesc());
            tvShow.setPhoto(tvShow.getPhoto());

            Intent intent = new Intent(itemView.getContext(),DetailTvShowActivity.class);
            intent.putExtra(DetailTvShowActivity.EXTRA_TvShow, tvShow);
            context.startActivity(intent);
        }
    }
}
