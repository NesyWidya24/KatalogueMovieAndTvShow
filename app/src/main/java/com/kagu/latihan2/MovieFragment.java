package com.kagu.latihan2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MovieFragment extends Fragment {
    View view;
    private RecyclerView rvMovies;
    private ArrayList<Movie> list;
    private ListMovieAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        rvMovies = view.findViewById(R.id.rv_movies);

        layoutManager = new LinearLayoutManager(getContext());
        rvMovies.setLayoutManager(layoutManager);
        rvMovies.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(MoviesData.getListDatamovie());

        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListMovieAdapter(getContext(), list);

        rvMovies.setAdapter(adapter);

        return view;
    }
}
