package com.kagu.latihan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMoviesActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIES = "extra_movies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.details);


        TextView tvtitle = findViewById(R.id.text_title);
        TextView tvDesc = findViewById(R.id.text_desc);
        ImageView imgKatalog = findViewById(R.id.img_katalog);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIES);

        tvtitle.setText(movie.getName());
        tvDesc.setText(movie.getSinopsis());

        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(150,200))
                .into(imgKatalog);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
