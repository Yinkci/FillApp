package com.example.filipinoapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.VideoView;

public class MovieList extends AppCompatActivity {

    VideoView video1, video2, video3;
    Button watch1, watch2, watch3, read1, read2, read3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        video1 = (VideoView) findViewById(R.id.video1);
        video2 = (VideoView) findViewById(R.id.video2);
        video3 = (VideoView) findViewById(R.id.video3);
        watch1 = (Button) findViewById(R.id.btnWatch1);
        watch2 = (Button) findViewById(R.id.btnWatch2);
        watch3 = (Button) findViewById(R.id.btnWatch3);
        read1 = (Button) findViewById(R.id.btnRead1);
        read2 = (Button) findViewById(R.id.btnRead2);
        read3 = (Button) findViewById(R.id.btnRead3);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        videoList();
        WatchButtonClick();
        ReadButtonClick();

        final ScrollView scrollView = (ScrollView) findViewById(R.id.scroll);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(scrollView.FOCUS_UP);
            }
        });

    }

    public void ReadButtonClick() {

        read1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MovieList.this, Read.class);
                intent.putExtra("index", "1");
                intent.putExtra("name", getString(R.string.story1));
                startActivity(intent);

            }
        });

        read2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieList.this, Read.class);
                intent.putExtra("index", "2");
                intent.putExtra("name", getString(R.string.story2));
                startActivity(intent);
            }
        });

        read3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieList.this, Read.class);
                intent.putExtra("index", "3");
                intent.putExtra("name", getString(R.string.story3));
                startActivity(intent);
            }
        });
    }

    public void WatchButtonClick() {

        watch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieList.this, MoviePlay.class);
                intent.putExtra("videoName", getString(R.string.story1));
                intent.putExtra("videoSpeed", "normal");
                intent.putExtra("index", "1");
                startActivity(intent);
            }
        });

        watch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieList.this, MoviePlay.class);
                intent.putExtra("videoName", getString(R.string.story2));
                intent.putExtra("videoSpeed", "normal");
                intent.putExtra("index", "2");
                startActivity(intent);
            }
        });

        watch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieList.this, MoviePlay.class);
                intent.putExtra("videoName", getString(R.string.story3));
                intent.putExtra("videoSpeed", "normal");
                intent.putExtra("index", "3");
                startActivity(intent);
            }
        });
    }

    String videoPath1, videoPath2, videoPath3;
    public void videoList() {

        //video 1
        videoPath1 = "android.resource://" + getPackageName() + "/" + R.raw.normal1;
        Uri uri1 = Uri.parse(videoPath1);
        video1.setVideoURI(uri1);
        video1.seekTo(1);
        video1.setEnabled(false);

        //video 2
        videoPath2 = "android.resource://" + getPackageName() + "/" + R.raw.normal2;
        Uri uri2 = Uri.parse(videoPath2);
        video2.setVideoURI(uri2);
        video2.seekTo(1);
        video2.setEnabled(false);

        //video 3
        videoPath3 = "android.resource://" + getPackageName() + "/" + R.raw.normal3;
        Uri uri3 = Uri.parse(videoPath3);
        video3.setVideoURI(uri3);
        video3.seekTo(1);
        video3.setEnabled(false);
    }

    @Override
    protected void onResume() {
        videoList();
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
