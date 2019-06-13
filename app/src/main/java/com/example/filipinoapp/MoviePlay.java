package com.example.filipinoapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MoviePlay extends AppCompatActivity {

    VideoView video;
    TextView name;
    String videoPath, videoSpeed, index;
    Button slow, fast, normal, quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_play);

        quiz = (Button) findViewById(R.id.btnQuiz);
        video = (VideoView) findViewById(R.id.video);
        name = (TextView) findViewById(R.id.videoName);
        slow = (Button) findViewById(R.id.btnSlow);
        fast = (Button) findViewById(R.id.btnFast);
        normal = (Button) findViewById(R.id.btnNormal);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        videoSpeed = getIntent().getStringExtra("videoSpeed");
        name.setText(getIntent().getStringExtra("videoName") + " (" + videoSpeed + ")");

        index = getIntent().getStringExtra("index");
        videoset();

        slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(getIntent().getStringExtra("videoName"));
                Intent intent = new Intent(MoviePlay.this, MoviePlay.class);
                intent.putExtra("videoName", name.getText().toString());
                intent.putExtra("videoSpeed", "slow");
                intent.putExtra("index", index);
                startActivity(intent);
                finish();
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(getIntent().getStringExtra("videoName"));
                Intent intent = new Intent(MoviePlay.this, MoviePlay.class);
                intent.putExtra("videoName", name.getText().toString());
                intent.putExtra("videoSpeed", "normal");
                intent.putExtra("index", index);
                startActivity(intent);
                finish();
            }
        });

        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(getIntent().getStringExtra("videoName"));
                Intent intent = new Intent(MoviePlay.this, MoviePlay.class);
                intent.putExtra("videoName", name.getText().toString());
                intent.putExtra("videoSpeed", "fast");
                intent.putExtra("index", index);
                startActivity(intent);
                finish();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoviePlay.this, Quiz.class);
                intent.putExtra("name", getIntent().getStringExtra("videoName"));
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });
    }

    public void videoset() {

        if (index.equals("1")) {

            if (videoSpeed.equalsIgnoreCase("normal")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.normal1;
                normal.setVisibility(View.GONE);
            } else if (videoSpeed.equalsIgnoreCase("slow")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.slow1;
                slow.setVisibility(View.GONE);
                normal.setVisibility(View.VISIBLE);
            } else if (videoSpeed.equalsIgnoreCase("fast")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.fast1;
                fast.setVisibility(View.GONE);
                normal.setVisibility(View.VISIBLE);
            }
        } else if (index.equals("2")) {

            if (videoSpeed.equalsIgnoreCase("normal")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.normal2;
                normal.setVisibility(View.GONE);
            } else if (videoSpeed.equalsIgnoreCase("slow")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.slow2;
                slow.setVisibility(View.GONE);
                normal.setVisibility(View.VISIBLE);
            } else if (videoSpeed.equalsIgnoreCase("fast")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.fast2;
                fast.setVisibility(View.GONE);
                normal.setVisibility(View.VISIBLE);
            }
        } else if (index.equals("3")) {

            if (videoSpeed.equalsIgnoreCase("normal")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.normal3;
                normal.setVisibility(View.GONE);
            } else if (videoSpeed.equalsIgnoreCase("slow")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.slow3;
                slow.setVisibility(View.GONE);
                normal.setVisibility(View.VISIBLE);
            } else if (videoSpeed.equalsIgnoreCase("fast")) {
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.fast3;
                fast.setVisibility(View.GONE);
                normal.setVisibility(View.VISIBLE);
            }
        }

        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);
        video.seekTo(1);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
    }

    @Override
    protected void onResume() {
        videoset();
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
