package com.example.wilder.myapplication;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Ship> myFloat = new ArrayList<>();

    Ship ship1 = new Ship(1, 3, "LShape");
    Ship ship2 = new Ship(4, 3, "UShape");
    Ship ship3 = new Ship(3, 3, "Line3");
    Ship ship4 = new Ship(2, 2, "Line2");
    Ship ship5 = new Ship(3, 3, "Line2");


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
                                    final int position, long id) {

                ImageView imageView = (ImageView) v;
                imageView.setImageResource(R.drawable.explodepng);



                // onCreateDialog();
                Toast.makeText(GameActivity.this, "Choisis ton bateau",
                        Toast.LENGTH_SHORT).show();

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(GameActivity.this);
                builder.setTitle(R.string.pick_ship)
                        .setItems(R.array.ships_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:/**NavireL**/
                                        if (ship1.getmPositionned()) {
                                            Toast.makeText(GameActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT);
                                            return;
                                        }

                                        ship1.setmStartx(position);
                                        positionShip(ship1);

                                        break;
                                    case 1:/**Navire U**/
                                        if (ship2.getmPositionned()) {
                                            Toast.makeText(GameActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT);
                                            return;
                                        }
                                        ship2.setmStartx(position);
                                        positionShip(ship2);
                                        break;

                                    case 2:/**Navire L3**/
                                        if (ship3.getmPositionned()) {
                                            Toast.makeText(GameActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT);
                                            return;
                                        }
                                        ship3.setmStartx(position);
                                        positionShip(ship3);
                                        break;
                                    default:/**Navire L2**/
                                        if (ship4.getmPositionned()) {
                                            if (ship5.getmPositionned()) {
                                                Toast.makeText(GameActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT);
                                                return;
                                            }
                                            ship5.setmStartx(position);
                                            positionShip(ship5);
                                            break;
                                        }
                                        ship4.setmStartx(position);
                                        positionShip(ship4);
                                        break;
                                }
                            }
                        });
                builder.show();
                Toast.makeText(GameActivity.this, "Choisis ton bateau", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void positionShip(final Ship ship) {
        android.app.AlertDialog.Builder direction = new android.app.AlertDialog.Builder(GameActivity.this);
        direction.setTitle(R.string.orientation)
                .setItems(R.array.orientation_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
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
        direction.show();

    }

    @Override
    public void onClick(View v) {

    }

    public void hit(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.explosion);
        mp.start();

    }

    public void destroyShip(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.angry);
        mp.start();

    }

    public void missedHit(View v) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.oups);
        mp.start();
    }
}
