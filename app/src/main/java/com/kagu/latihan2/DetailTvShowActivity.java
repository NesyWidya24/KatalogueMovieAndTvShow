package com.kagu.latihan2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TvShow = "extra_tvshow";

    TextView tvtitle, tvDesc;
    ImageView imgKatalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_detail);

        getSupportActionBar().setTitle(R.string.details);

        tvtitle = findViewById(R.id.text_title);
        tvDesc = findViewById(R.id.text_desc);
        imgKatalog = findViewById(R.id.img_katalog);

        TvShow tvShow= getIntent().getParcelableExtra(EXTRA_TvShow);

        tvtitle.setText(tvShow.getName());
        tvDesc.setText(tvShow.getDesc());

        Glide.with(this)
                .load(tvShow.getPhoto())
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
