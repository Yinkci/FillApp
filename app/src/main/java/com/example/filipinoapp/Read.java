package com.example.filipinoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Read extends AppCompatActivity {

    String index, name;
    TextView title, body;
    Button btnQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        title = (TextView) findViewById(R.id.tvTitle);
        body = (TextView) findViewById(R.id.tvBody);
        btnQuiz = (Button) findViewById(R.id.btnQuiz);

        index = getIntent().getStringExtra("index");
        name = getIntent().getStringExtra("name");

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        if (index.equals("1")) {

            title.setText("Read Story #1");
            body.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit scelerisque in dictum non consectetur. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ut eu sem integer vitae justo eget magna. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Sed turpis tincidunt id aliquet risus feugiat in ante metus. Mi tempus imperdiet nulla malesuada pellentesque elit eget. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra. Nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur. Nulla facilisi morbi tempus iaculis urna. Dignissim convallis aenean et tortor. Morbi tristique senectus et netus et malesuada fames. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Gravida cum sociis natoque penatibus et magnis dis parturient montes.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit scelerisque in dictum non consectetur. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ut eu sem integer vitae justo eget magna. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Sed turpis tincidunt id aliquet risus feugiat in ante metus. Mi tempus imperdiet nulla malesuada pellentesque elit eget. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra. Nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur. Nulla facilisi morbi tempus iaculis urna. Dignissim convallis aenean et tortor. Morbi tristique senectus et netus et malesuada fames. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Gravida cum sociis natoque penatibus et magnis dis parturient montes.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit scelerisque in dictum non consectetur. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ut eu sem integer vitae justo eget magna. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Sed turpis tincidunt id aliquet risus feugiat in ante metus. Mi tempus imperdiet nulla malesuada pellentesque elit eget. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra. Nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur. Nulla facilisi morbi tempus iaculis urna. Dignissim convallis aenean et tortor. Morbi tristique senectus et netus et malesuada fames. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Gravida cum sociis natoque penatibus et magnis dis parturient montes.");

        } else if (index.equals("2")) {

            title.setText("Read Story #2");
            body.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit scelerisque in dictum non consectetur. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ut eu sem integer vitae justo eget magna. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Sed turpis tincidunt id aliquet risus feugiat in ante metus. Mi tempus imperdiet nulla malesuada pellentesque elit eget. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra. Nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur. Nulla facilisi morbi tempus iaculis urna. Dignissim convallis aenean et tortor. Morbi tristique senectus et netus et malesuada fames. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Gravida cum sociis natoque penatibus et magnis dis parturient montes.\n\nPretium lectus quam id leo in vitae. In arcu cursus euismod quis viverra nibh cras pulvinar mattis. Consequat semper viverra nam libero justo laoreet sit amet. Ultrices dui sapien eget mi proin sed libero. Feugiat pretium nibh ipsum consequat nisl vel. Vitae proin sagittis nisl rhoncus mattis rhoncus urna. Condimentum mattis pellentesque id nibh tortor id aliquet lectus. Aliquet nec ullamcorper sit amet risus nullam eget felis eget. Ipsum dolor sit amet consectetur. Bibendum est ultricies integer quis auctor elit sed vulputate mi. Morbi blandit cursus risus at ultrices mi tempus imperdiet nulla. In nulla posuere sollicitudin aliquam ultrices sagittis. Fermentum et sollicitudin ac orci phasellus. Massa vitae tortor condimentum lacinia quis vel eros donec. Morbi non arcu risus quis varius quam quisque. Quis blandit turpis cursus in hac habitasse platea dictumst quisque.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit scelerisque in dictum non consectetur. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ut eu sem integer vitae justo eget magna. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Sed turpis tincidunt id aliquet risus feugiat in ante metus. Mi tempus imperdiet nulla malesuada pellentesque elit eget. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra. Nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur. Nulla facilisi morbi tempus iaculis urna. Dignissim convallis aenean et tortor. Morbi tristique senectus et netus et malesuada fames. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Gravida cum sociis natoque penatibus et magnis dis parturient montes.");

        } else if (index.equals("3")) {

            title.setText("Read Story #3");
            body.setText("Pretium lectus quam id leo in vitae. In arcu cursus euismod quis viverra nibh cras pulvinar mattis. Consequat semper viverra nam libero justo laoreet sit amet. Ultrices dui sapien eget mi proin sed libero. Feugiat pretium nibh ipsum consequat nisl vel. Vitae proin sagittis nisl rhoncus mattis rhoncus urna. Condimentum mattis pellentesque id nibh tortor id aliquet lectus. Aliquet nec ullamcorper sit amet risus nullam eget felis eget. Ipsum dolor sit amet consectetur. Bibendum est ultricies integer quis auctor elit sed vulputate mi. Morbi blandit cursus risus at ultrices mi tempus imperdiet nulla. In nulla posuere sollicitudin aliquam ultrices sagittis. Fermentum et sollicitudin ac orci phasellus. Massa vitae tortor condimentum lacinia quis vel eros donec. Morbi non arcu risus quis varius quam quisque. Quis blandit turpis cursus in hac habitasse platea dictumst quisque.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit scelerisque in dictum non consectetur. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ut eu sem integer vitae justo eget magna. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Sed turpis tincidunt id aliquet risus feugiat in ante metus. Mi tempus imperdiet nulla malesuada pellentesque elit eget. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra. Nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur. Nulla facilisi morbi tempus iaculis urna. Dignissim convallis aenean et tortor. Morbi tristique senectus et netus et malesuada fames. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Gravida cum sociis natoque penatibus et magnis dis parturient montes.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Velit scelerisque in dictum non consectetur. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ut eu sem integer vitae justo eget magna. Dui faucibus in ornare quam viverra orci sagittis eu volutpat. Sed turpis tincidunt id aliquet risus feugiat in ante metus. Mi tempus imperdiet nulla malesuada pellentesque elit eget. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra. Nibh mauris cursus mattis molestie. Lorem ipsum dolor sit amet consectetur. Nulla facilisi morbi tempus iaculis urna. Dignissim convallis aenean et tortor. Morbi tristique senectus et netus et malesuada fames. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Gravida cum sociis natoque penatibus et magnis dis parturient montes.");
        }

        // Timer
        handler = new Handler();
        tStart = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index.equals("1")) {
                    Intent intent = new Intent(Read.this, Quiz.class);
                    intent.putExtra("name", getString(R.string.story1));
                    intent.putExtra("index", "1");
                    intent.putExtra("timerread", timer);
                    startActivity(intent);
                } else if (index.equals("2")) {
                    Intent intent = new Intent(Read.this, Quiz.class);
                    intent.putExtra("name", getString(R.string.story2));
                    intent.putExtra("index", "2");
                    intent.putExtra("timerread", timer);
                    startActivity(intent);
                } else if (index.equals("3")) {
                    Intent intent = new Intent(Read.this, Quiz.class);
                    intent.putExtra("name", getString(R.string.story3));
                    intent.putExtra("index", "3");
                    intent.putExtra("timerread", timer);
                    startActivity(intent);
                }

            }
        });

    }

    String timer;
    Handler handler;
    long tMilliSec, tStart, tBuff, tUpdate = 0L;
    int sec, min, milliSec;

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tMilliSec = SystemClock.uptimeMillis() - tStart;
            tUpdate = tBuff + tMilliSec;
            sec = (int) (tUpdate/1000);
            min = sec/60;
            sec = sec%60;
            milliSec = (int) (tUpdate%100);

            timer = String.format("%02d", min) + ":" + String.format("%02d", sec) + ":" + String.format("%02d", milliSec);
            handler.postDelayed(this, 60);
        }
    };

    @Override
    protected void onResume() {
        tStart = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
        super.onResume();
    }

    @Override
    protected void onPause() {
        tBuff += tMilliSec;
        handler.removeCallbacks(runnable);
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
