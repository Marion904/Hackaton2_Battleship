package com.example.wilder.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    Ship ship1 = new Ship(1,3,"LShape");
    Ship ship2 = new Ship(4,3,"UShape");
    Ship ship3 = new Ship(3,3,"Line3");
    Ship ship4 = new Ship(2,2,"Line2");
    Ship ship5 = new Ship(3,3,"Line3");

    Button LShape;
    Button UShape;
    Button Line3;
    Button Line2;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        LShape = (Button) findViewById(R.id.LShape);
        UShape = (Button) findViewById(R.id.UShape);
        Line3 = (Button) findViewById(R.id.Line3);
        Line2 =(Button) findViewById(R.id.Line2);
        LShape.setOnClickListener(this);
        UShape.setOnClickListener(this);
        Line3.setOnClickListener(this);
        Line2.setOnClickListener(this);
/**
        myFloat.add(ship1);
        myFloat.add(ship2);
        myFloat.add(ship3);
        myFloat.add(ship4);
        myFloat.add(ship5);**/


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ImageView imageView = (ImageView) v ;
                imageView.setImageResource(R.drawable.explodepng);

              
                onCreateDialog();
                Toast.makeText(GameActivity.this, "Choisis ton bateau",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle(R.string.pick_ship)
                .setItems(R.array.ships_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });
        return builder.create();
    }

    @Override
    public void onClick(View v) {
        if(v==LShape){
            if(ship1.getmPositionned()){
                Toast.makeText(GameActivity.this,"Ton navire est déjà positionné!",Toast.LENGTH_SHORT).show();
                return;
            }
            GridView gridview = (GridView) findViewById(R.id.gridview);
            gridview.setAdapter(new ImageAdapter(this));
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {

                    Toast.makeText(GameActivity.this, "" + position,
                            Toast.LENGTH_SHORT).show();
                }
            });

        }
        if(v==UShape){

        }
        if(v==Line3){

        }
        if(v==Line2){

        }
    }
}
