package com.example.wilder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener {


    private Button onePlayer;
    private Button twoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        Button onePlayer = (Button) findViewById(R.id.OnePlayer);
        onePlayer.setOnClickListener(this);
        Button twoPlayer = (Button) findViewById(R.id.TwoPlayerBluetooth);
        twoPlayer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.OnePlayer){

            startActivity(new Intent(MenuActivity.this, GameActivity.class));

        }
        if (i == R.id.TwoPlayerBluetooth){
            startActivity(new Intent(getApplicationContext(), BlueToothActivity.class));
        }


        }

    }
