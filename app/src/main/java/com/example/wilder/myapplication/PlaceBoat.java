package com.example.wilder.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceBoat extends AppCompatActivity {

    ArrayList<Ship> myFloat = new ArrayList<>();
    ArrayList<Cell> mCells = new ArrayList<>();
    ImageAdapter mAdapter = new ImageAdapter(this, mCells);
    GridView gridview;

    Ship ship1 = new Ship(1,4,"LShape");
    Ship ship2 = new Ship(4,5,"UShape");
    Ship ship3 = new Ship(3,3,"Line3");
    Ship ship4 = new Ship(2,2,"Line2");
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

                


              

                Toast.makeText(PlaceBoat.this, "Choisis ton bateau",
                        Toast.LENGTH_SHORT).show();

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(PlaceBoat.this);
                builder.setTitle(R.string.pick_ship)
                        .setItems(R.array.ships_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0:/**NavireL**/
                                        if(ship1.getmPositionned()){
                                            Toast.makeText(PlaceBoat.this,getString(R.string.AlreadyAfloat),Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        ship1.setmStartx(position);
                                        int x = position;
                                        int x2 = x-10;
                                        int x3 = x-20;
                                        int x4 = x-1;


                                        Cell theCell = mCells.get(x);
                                        Cell theCell2 = mCells.get(x2);
                                        Cell theCell3 = mCells.get(x3);
                                        Cell theCell4 = mCells.get(x4);
                                        theCell.setmBoat(true);
                                        theCell2.setmBoat(true);
                                        theCell3.setmBoat(true);
                                        theCell4.setmBoat(true);
                                        mAdapter.notifyDataSetChanged();

                                        break;
                                    case 1:/**Navire U**/
                                        if(ship2.getmPositionned()){
                                            Toast.makeText(PlaceBoat.this,getString(R.string.AlreadyAfloat),Toast.LENGTH_SHORT);
                                            break;
                                        }
                                        ship2.setmStartx(position);
                                        directShip(ship2);
                                        break;

                                    case 2:/**Navire L3**/
                                        if(ship3.getmPositionned()){
                                            Toast.makeText(PlaceBoat.this,getString(R.string.AlreadyAfloat),Toast.LENGTH_SHORT);
                                         break;
                                        }
                                        ship3.setmStartx(position);
                                        directShip(ship3);
                                        break;
                                    case 3:/**Navire L2**/
                                        if(ship4.getmPositionned()){
                                            if(ship5.getmPositionned()) {
                                                Toast.makeText(PlaceBoat.this, getString(R.string.AlreadyAfloat), Toast.LENGTH_SHORT);
                                            }
                                            ship5.setmStartx(position);
                                            directShip(ship5);
                                            break;
                                        }
                                        ship4.setmStartx(position);
                                        directShip(ship4);
                                        break;
                                    default:
                                        Toast.makeText(PlaceBoat.this, R.string.choose,Toast.LENGTH_SHORT).show();
                                }

                                if (ship1.ismPositionned() && ship2.ismPositionned() &&
                                        ship3.ismPositionned() && ship4.ismPositionned() && ship5.ismPositionned()){

                                    int[] positionTab = new int[]{ship1.getmStartx(), ship2.getmStartx(),ship3.getmStartx(),
                                            ship4.getmStartx() , ship5.getmStartx()};

                                    Intent transferDatas = new Intent(PlaceBoat.this , GameActivity.class);
                                    transferDatas.putExtra("oui", positionTab);
                                    startActivity(transferDatas);
                                    finish();



                                }


                            }
                        });
                builder.show();
                Toast.makeText(PlaceBoat.this, "Choisis ton bateau",Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void directShip(final Ship ship){
        android.app.AlertDialog.Builder direction = new android.app.AlertDialog.Builder(PlaceBoat.this);
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

    public void drawShip(Ship ship){
        int type = ship.getmType();
        int x =ship.getmStartx();
        Direction dir = ship.getmDirection();
        switch (type){
            case 1:
                /**if(dir == Direction.NORTH) {
                    //ArrayList <Cell> boat =new ArrayList<>();**/
                    Cell cell = new Cell(x);
                    cell.setmBoat(true);
                    Cell cell2 = new Cell(x-10);
                    cell2.setmBoat(true);
                    Cell cell3 = new Cell(x-20);
                    cell3.setmBoat(true);
                    Cell cell4 = new Cell(x-1);
                    cell4.setmBoat(true);
                //}
                break;
            case 2:
                if(dir == Direction.NORTH) {


                }
                if(dir == Direction.EAST) {

                    //x,x-10,x-20,x-1;
                    return;
                }
                if(dir == Direction.WEST) {

                    //x,x-10,x-20,x-1;
                    return;
                }
                if(dir == Direction.SOUTH) {


                }
                break;
            case 3:
                if(dir == Direction.NORTH) {

                }
                if(dir == Direction.EAST) {

                }
                if(dir == Direction.WEST) {

                }
                if(dir == Direction.SOUTH) {

                }
                break;
            case 4:
                if(dir == Direction.NORTH) {

                }
                if(dir == Direction.EAST) {

                }
                if(dir == Direction.WEST) {

                }
                if(dir == Direction.SOUTH) {

                }
                break;
        }
        /** LSHAPE(1,3,"LShape"),
         LINE2(2,2,"Line2"),
         LINE3(3,3,"Line3"),
         USHAPE(4,3,"UShape"),;

         NORTH(1,"North"),
         SOUTH(2,"South"),
         EAST(3,"East"),
         WEST(4,"West");
         **/
    }


}
