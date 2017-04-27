package com.example.wilder.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<Ship> myFloat = new ArrayList<>();

    Ship ship1 = new Ship(1,3,"LShape");
    Ship ship2 = new Ship(4,3,"UShape");
    Ship ship3 = new Ship(3,3,"Line3");
    Ship ship4 = new Ship(2,2,"Line2");
    Ship ship5 = new Ship(3,3,"Line3");




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myFloat.add(ship1);
        myFloat.add(ship2);
        myFloat.add(ship3);
        myFloat.add(ship4);
        myFloat.add(ship5);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ImageView imageView = (ImageView) v ;
                imageView.setImageResource(R.drawable.explodepng);

              
                onCreateDialog();
                Toast.makeText(GameActivity.this, "Choisis ton bateau",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void onCreateDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(GameActivity.this);
        builder.setTitle(R.string.pick_ship)
                .setItems(R.array.ships_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:/**
                                NavireL
                                mChaussette.setmCategory(Constants.DATABASE_PATH_CATEGORY_1);
                                mDatabase.child(Constants.DATABASE_PATH_CATEGORY).child(Constants.DATABASE_PATH_CATEGORY_1).child(mChaussette.getmIdChaussette()).setValue(mChaussette);
                                break;**/
                            case 1:/**
                                mChaussette.setmCategory(Constants.DATABASE_PATH_CATEGORY_2);
                                mDatabase.child(Constants.DATABASE_PATH_CATEGORY).child(Constants.DATABASE_PATH_CATEGORY_2).child(mChaussette.getmIdChaussette()).setValue(mChaussette);
                                break;**/
                            case 2:/**
                                mChaussette.setmCategory(Constants.DATABASE_PATH_CATEGORY_3);
                                mDatabase.child(Constants.DATABASE_PATH_CATEGORY).child(Constants.DATABASE_PATH_CATEGORY_3).child(mChaussette.getmIdChaussette()).setValue(mChaussette);
                                break;**/
                            default:
                                break;
                        }
                    }
                });
        builder.show();
    }

    public void positionShip(final Ship ship){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(GameActivity.this);
        builder.setTitle(R.string.orientation)
                .setItems(R.array.orientation_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:/**NORD**/
                             ship.setmDirection(Direction.NORTH);
                             break;
                            case 1:/**SUD**/
                                ship.setmDirection(Direction.SOUTH);
                                break;
                            case 2:/**EST**/
                                ship.setmDirection(Direction.EAST);
                                break;
                            default:
                                ship.setmDirection(Direction.WEST);
                                break;
                        }
                    }
                });
        builder.show();

        if(ship.getmShipType()==ShipType.LINE2){

        }
    }
    @Override
    public void onClick(View v) {

    }
}
