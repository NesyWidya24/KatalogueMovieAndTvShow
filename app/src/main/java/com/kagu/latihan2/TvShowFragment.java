package com.kagu.latihan2;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    View view;
    private RecyclerView rvTvShows;
    private ArrayList<TvShow> list;
    private ListTvShowAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        rvTvShows = view.findViewById(R.id.rv_tvshow);

        layoutManager = new LinearLayoutManager(getContext());
        rvTvShows.setLayoutManager(layoutManager);
        rvTvShows.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(TvShowData.getListDatatvShow());

        rvTvShows.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListTvShowAdapter(getContext(), list);

        rvTvShows.setAdapter(adapter);

        return view;
    }

}
