package com.example.wilder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    ArrayList<Cell> mCells = new ArrayList<>();
    ImageAdapter mAdapter = new ImageAdapter(this, mCells);
    GridView gridview;

    Ship ship1 = new Ship(1,4,"LShape");
    Ship ship2 = new Ship(4,5,"UShape");
    Ship ship3 = new Ship(3,3,"Line3");
    Ship ship4 = new Ship(2,2,"Line2");
    Ship ship5 = new Ship(2,2,"Line2");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        Intent transferDatas = getIntent();
        transferDatas.getIntArrayExtra("oui");



        for (int i = 0; i < 100; i++) {
            mCells.add(new Cell(i));
        }


        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(mAdapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View v,
                                    final int position, long id) {


            }
        });



    }




}
