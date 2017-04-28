package com.example.wilder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    String results;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        result = (TextView) findViewById(R.id.results);

        Intent endGame = getIntent();
        results = endGame.getStringExtra("results");
        result.setText(results);

    }
}
