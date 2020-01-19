package com.kagu.latihan2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());

        mainAdapter.addFragment(new MovieFragment(), getString(R.string.movies_tab));
        mainAdapter.addFragment(new TvShowFragment(), getString(R.string.tvshow_tab));

        viewPager.setAdapter(mainAdapter);
    }

    //    alert quit
    @Override
    public  void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.message_alert)).setCancelable(false).setPositiveButton(getString(R.string.y_alert), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                moveTaskToBack(true);
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
        }).setNegativeButton(getString(R.string.n_alert), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int arg1) {

            }
        }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings_language) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}