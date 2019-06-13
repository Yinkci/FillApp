package com.example.filipinoapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    TextView name, question, index;
    RadioButton ans1, ans2, ans3, ans4;
    ImageButton submit;
    int q = 1, score = 0, selectedRB;
    String movieIndex, timerread;
    RadioGroup radioGroup;

    Handler handler;
    long tMilliSec, tStart, tBuff, tUpdate = 0L;
    int sec, min, milliSec;

    String rightAnswer;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String quizData1[][] = {
            // {"Question", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}
            {"AQuestion1", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion2", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion3", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion4", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion5", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion6", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion7", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion8", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion9", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"AQuestion10", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}

    };

    String quizData2[][] = {
            // {"Question", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}
            {"BQuestion1", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion2", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion3", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion4", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion5", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion6", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion7", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion8", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion9", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"BQuestion10", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}

    };

    String quizData3[][] = {
            // {"Question", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}
            {"CQuestion1", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion2", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion3", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion4", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion5", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion6", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion7", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion8", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion9", "Right Answer", "Choice 1", "Choice 2", "Choice 3"},
            {"CQuestion10", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        radioGroup = (RadioGroup) findViewById(R.id.rbGroup);
        name = (TextView) findViewById(R.id.tvName);
        question = (TextView) findViewById(R.id.tvQuestion);
        index = (TextView) findViewById(R.id.tvIndex);
        ans1 = (RadioButton) findViewById(R.id.rbAns1);
        ans2 = (RadioButton) findViewById(R.id.rbAns2);
        ans3 = (RadioButton) findViewById(R.id.rbAns3);
        ans4 = (RadioButton) findViewById(R.id.rbAns4);
        submit = (ImageButton) findViewById(R.id.btnSubmit);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        name.setText(getIntent().getStringExtra("name"));
        movieIndex = getIntent().getStringExtra("index");
        timerread = getIntent().getStringExtra("timerread");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedRB = radioGroup.getCheckedRadioButtonId();
                if (selectedRB == -1) {
                    Toast.makeText(getApplication(), "Select an answer first.", Toast.LENGTH_SHORT).show();
                } else {

                    if (q == 10) {

                        RadioButton selected = (RadioButton) findViewById(selectedRB);
                        String selects = selected.getText().toString();

                        if (selects.equals(rightAnswer)) {
                            score++;

                            Intent intent = new Intent(Quiz.this, Results.class);
                            intent.putExtra("score", "" + score);
                            intent.putExtra("timer", timer);
                            intent.putExtra("timerread", timerread);
                            startActivity(intent);
                            finish();

                        } else {

                            Intent intent = new Intent(Quiz.this, Results.class);
                            intent.putExtra("score", "" + score);
                            intent.putExtra("timer", timer);
                            intent.putExtra("timerread", timerread);
                            startActivity(intent);
                            finish();
                        }

                    } else {

                        RadioButton selected = (RadioButton) findViewById(selectedRB);
                        String selects = selected.getText().toString();

                        if (selects.equals(rightAnswer)) {
                            score++;
                            q++;
                            radioGroup.clearCheck();
                            showNextQuiz();
                        } else {
                            q++;
                            radioGroup.clearCheck();
                            showNextQuiz();
                        }
                    }
                }
            }
        });

        // Timer
        handler = new Handler();
        tStart = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);


        // Create quizArray from quizData
        if (movieIndex.equals("1")) {
            for (int i = 0; i < quizData1.length; i++) {

                // Prepare Array
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizData1[i][0]); // Question
                tmpArray.add(quizData1[i][1]); // Right Answer
                tmpArray.add(quizData1[i][2]); // Choice 1
                tmpArray.add(quizData1[i][3]); // Choice 2
                tmpArray.add(quizData1[i][4]); // Choice 3

                // Add tmpArray to quizArray
                quizArray.add(tmpArray);
            }

            showNextQuiz();
        } else if (movieIndex.equals("2")) {
            for (int i = 0; i < quizData2.length; i++) {

                // Prepare Array
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizData2[i][0]); // Question
                tmpArray.add(quizData2[i][1]); // Right Answer
                tmpArray.add(quizData2[i][2]); // Choice 1
                tmpArray.add(quizData2[i][3]); // Choice 2
                tmpArray.add(quizData2[i][4]); // Choice 3

                // Add tmpArray to quizArray
                quizArray.add(tmpArray);
            }

            showNextQuiz();
        } else if (movieIndex.equals("3")) {
            for (int i = 0; i < quizData3.length; i++) {

                // Prepare Array
                ArrayList<String> tmpArray = new ArrayList<>();
                tmpArray.add(quizData3[i][0]); // Question
                tmpArray.add(quizData3[i][1]); // Right Answer
                tmpArray.add(quizData3[i][2]); // Choice 1
                tmpArray.add(quizData3[i][3]); // Choice 2
                tmpArray.add(quizData3[i][4]); // Choice 3

                // Add tmpArray to quizArray
                quizArray.add(tmpArray);
            }

            showNextQuiz();
        }
    }

    public void showNextQuiz() {

        // Update question number
        index.setText("" + q);

        // Generate random number between 0 and 14 (quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer
        // Array format: {"Question", "Right Answer", "Choice 1", "Choice 2", "Choice 3"}
        question.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Question" from quiz and shuffle choices
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set Choices
        ans1.setText(quiz.get(0));
        ans2.setText(quiz.get(1));
        ans3.setText(quiz.get(2));
        ans4.setText(quiz.get(3));

        // Remove this quiz from quizArray
        quizArray.remove(randomNum);

    }

    String timer;
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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
