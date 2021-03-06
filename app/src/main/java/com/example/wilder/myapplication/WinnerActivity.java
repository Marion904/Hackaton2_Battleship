package com.example.wilder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifTextView;


public class WinnerActivity extends AppCompatActivity implements View.OnClickListener{
    String results;
    TextView result;
    Button buttonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);


        buttonMenu = (Button)findViewById(R.id.buttonMenu);
        this.buttonMenu.setOnClickListener(this);


        result = (TextView) findViewById(R.id.results);

        Intent endGame = getIntent();
        results = endGame.getStringExtra("results");
        result.setText(results);

        GifTextView gifTextViewResult = (GifTextView) findViewById(R.id.gifTextViewResult);
        gifTextViewResult.setBackgroundResource(R.drawable.giphy);


    }
    public void onClick(View v){
        if(v == buttonMenu){
            startActivity(new Intent(this, MenuActivity.class));

        }






    }
}
