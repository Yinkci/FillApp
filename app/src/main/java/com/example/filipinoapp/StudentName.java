package com.example.filipinoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentName extends AppCompatActivity {

    EditText name;
    Button save, cancel;

    SharedPreferences mPreference;
    SharedPreferences.Editor mEditor;

    String change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_name);

        name = (EditText) findViewById(R.id.etName);
        save = (Button) findViewById(R.id.btnSave);
        cancel = (Button) findViewById(R.id.btnCancel);

        cancel.setVisibility(View.GONE);
        mPreference = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreference.edit();

        int length = name.getText().toString().length();
        if (length < 1) {
            save.setBackgroundColor(Color.parseColor("#D3D6D9"));
            save.setEnabled(false);
        } else if (length > 1) {
            save.setBackgroundColor(Color.parseColor("#47525E"));
            save.setEnabled(true);
        }

        change = getIntent().getStringExtra("change");
        if (change.equals("on")) {
            cancel.setVisibility(View.VISIBLE);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mEditor.putString("student", name.getText().toString());
                    mEditor.commit();

                    finish();
                }
            });
        } else if (change.equals("off")) {
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mEditor.putString("student", name.getText().toString());
                    mEditor.commit();

                    Intent intent = new Intent(StudentName.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int length = name.getText().toString().length();
                if (length < 1) {
                    save.setBackgroundColor(Color.parseColor("#D3D6D9"));
                    save.setEnabled(false);
                } else if (length > 1) {
                    save.setBackgroundColor(Color.parseColor("#47525E"));
                    save.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    int back = 1;
    @Override
    public void onBackPressed() {
        if (back == 1) {
            Toast.makeText(getApplication(), "Press BACK again to exit", Toast.LENGTH_SHORT).show();
            back++;
        } else if (back == 2) {
            finish();
        }
    }
}
