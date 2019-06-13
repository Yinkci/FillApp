package com.example.filipinoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    TextView time, time2, score1, score2;
    Button back;
    String timeread;
    LinearLayout reading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        reading = (LinearLayout) findViewById(R.id.LinearReading);
        time = (TextView) findViewById(R.id.tvTimer);
        time2 = (TextView) findViewById(R.id.tvTimer2);
        score1 = (TextView) findViewById(R.id.tvScore1);
        score2 = (TextView) findViewById(R.id.tvScore2);
        back = (Button) findViewById(R.id.btnBack);

        timeread = getIntent().getStringExtra("timerread");
        time2.setText(timeread);
        int a = time2.length();
        if (a == 0) {
            reading.setVisibility(View.GONE);
        } else {
            time2.setText(timeread);
            reading.setVisibility(View.VISIBLE);
        }

        time.setText(getIntent().getStringExtra("timer"));
        score1.setText(getIntent().getStringExtra("score") + " sa 10 mga tanong ay nasagutan mo ng tama.");
        score2.setText("(" + getIntent().getStringExtra("score") + " of 10 questions you answered correctly)");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
