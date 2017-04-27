package com.example.wilder.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceBoatActivity extends AppCompatActivity {

    ArrayList<Ship> myFloat = new ArrayList<>();
    ArrayList<Cell> mCells = new ArrayList<>();
    ImageAdapter mAdapter = new ImageAdapter(this, mCells);
    GridView gridview;

    Ship ship1 = new Ship(1,4,"LShape");
    Ship ship2 = new Ship(4,5,"UShape");
    Ship ship3 = new Ship(3,3,"Line3");
    Ship ship4 = new Ship(3,3,"Line3");
    Ship ship5 = new Ship(2,2,"Line2");



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_boat);

        myFloat.add(ship1);
        myFloat.add(ship2);
        myFloat.add(ship3);
        myFloat.add(ship4);
        myFloat.add(ship5);

        for (int i = 0; i < 100; i++) {
            mCells.add(new Cell(i));
        }


        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(mAdapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View v,
                                    final int position, long id) {

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(PlaceBoatActivity.this);
                builder.setTitle(R.string.pick_ship)
                        .setItems(R.array.ships_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:/**NavireL**/
                                        if (ship1.getmPositionned()) {
                                            Toast.makeText(PlaceBoatActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT).show();
                                        } else {
                                            if( (position<20)||(position%10 == 9) ){
                                                Toast.makeText(PlaceBoatActivity.this, R.string.bad_position,Toast.LENGTH_SHORT).show();
                                            }else{
                                                ship1.setmStartx(position);
                                                ship1.setmPositionned(true);
                                                int x = position;
                                                Cell ship1Cell1 = mCells.get(position);
                                                Cell ship1Cell2 = mCells.get(position + 1);
                                                Cell ship1Cell3 = mCells.get(position - 10);
                                                Cell ship1Cell4 = mCells.get(position - 20);
                                                ship1Cell1.setmBoat(true);
                                                ship1Cell2.setmBoat(true);
                                                ship1Cell3.setmBoat(true);
                                                ship1Cell4.setmBoat(true);
                                                mAdapter.notifyDataSetChanged();
                                            }

                                        }

                                        break;
                                    case 1:/**Navire U**/
                                        if (ship2.getmPositionned()) {
                                            Toast.makeText(PlaceBoatActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT).show();
                                        } else{
                                            if(position<11 || position % 10 == 0 || position % 10 ==9){
                                                Toast.makeText(PlaceBoatActivity.this, R.string.bad_position,Toast.LENGTH_SHORT).show();
                                            }else{
                                                ship2.setmStartx(position);
                                                ship2.setmPositionned(true);
                                                Cell ship2Cell1 = mCells.get(position);
                                                Cell ship2Cell2 = mCells.get(position + 1);
                                                Cell ship2Cell3 = mCells.get(position - 1);
                                                Cell ship2Cell4 = mCells.get(position - 9);
                                                Cell ship2Cell5 = mCells.get(position - 11);
                                                ship2Cell1.setmBoat(true);
                                                ship2Cell2.setmBoat(true);
                                                ship2Cell3.setmBoat(true);
                                                ship2Cell4.setmBoat(true);
                                                ship2Cell5.setmBoat(true);
                                                mAdapter.notifyDataSetChanged();
                                            }

                                        }
                                        break;

                                    case 2:/**Navire L3**/
                                        if (ship3.getmPositionned()) {
                                            if (ship4.getmPositionned()) {
                                                Toast.makeText(PlaceBoatActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT).show();
                                            }else{
                                                  if(position % 10 == 0 || position % 10 ==9) {
                                                      Toast.makeText(PlaceBoatActivity.this, R.string.bad_position, Toast.LENGTH_SHORT).show();
                                                  }else{
                                                      ship4.setmStartx(position);
                                                      ship4.setmPositionned(true);
                                                      Cell ship4Cell1 = mCells.get(position);
                                                      Cell ship4Cell2 = mCells.get(position + 1);
                                                      Cell ship4Cell3 = mCells.get(position - 1);
                                                      ship4Cell1.setmBoat(true);
                                                      ship4Cell2.setmBoat(true);
                                                      ship4Cell3.setmBoat(true);
                                                      mAdapter.notifyDataSetChanged();
                                                  }
                                            }
                                        }else{
                                            if(position % 10 == 0 || position % 10 ==9) {
                                                Toast.makeText(PlaceBoatActivity.this, R.string.bad_position, Toast.LENGTH_SHORT).show();
                                            }else{
                                                ship3.setmStartx(position);
                                                ship3.setmPositionned(true);
                                                Cell ship3Cell1 = mCells.get(position);
                                                Cell ship3Cell2 = mCells.get(position + 1);
                                                Cell ship3Cell3 = mCells.get(position - 1);
                                                ship3Cell1.setmBoat(true);
                                                ship3Cell2.setmBoat(true);
                                                ship3Cell3.setmBoat(true);
                                                mAdapter.notifyDataSetChanged();
                                            }
                                        }
                                        break;
                                    case 3:/**Navire L2**/
                                        if (ship5.getmPositionned()) {
                                            Toast.makeText(PlaceBoatActivity.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT).show();
                                            return;
                                        }else{
                                            if(position % 10 ==9) {
                                                Toast.makeText(PlaceBoatActivity.this, R.string.bad_position, Toast.LENGTH_SHORT).show();
                                            }else{
                                                ship5.setmStartx(position);
                                                ship5.setmPositionned(true);
                                                Cell ship5Cell1 = mCells.get(position);
                                                Cell ship5Cell2 = mCells.get(position + 1);
                                                ship5Cell1.setmBoat(true);
                                                ship5Cell2.setmBoat(true);
                                                mAdapter.notifyDataSetChanged();
                                            }
                                        }
                                        break;
                                    default:
                                        Toast.makeText(PlaceBoatActivity.this, R.string.choose,Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                builder.show();
            }
        });


    }

    public void directShip(final Ship ship){
        android.app.AlertDialog.Builder direction = new android.app.AlertDialog.Builder(PlaceBoatActivity.this);
        direction.setTitle(R.string.orientation)
                .setItems(R.array.orientation_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:/**NORD**/
                             ship.setmDirection(Direction.NORTH);
                                //positionShip(ship);
                             break;
                            case 1:/**SUD**/
                                ship.setmDirection(Direction.SOUTH);

                                break;
                            case 2:/**EST**/
                                ship.setmDirection(Direction.EAST);
                                break;
                            case 3:/**OUEST**/
                                ship.setmDirection(Direction.WEST);
                                break;
                            default:
                               break;
                        }
                    }
                });
        direction.show();

    }


}


