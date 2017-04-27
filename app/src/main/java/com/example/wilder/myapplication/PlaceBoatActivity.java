package com.example.wilder.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceBoatActivity extends AppCompatActivity {

    ArrayList<Ship> myFloat = new ArrayList<>();
    ArrayList<Cell> mCells = new ArrayList<>();
    ArrayList<Cell> ship1Cells=new ArrayList<>();
    ArrayList<Cell> ship2Cells=new ArrayList<>();
    ArrayList<Cell> ship3Cells=new ArrayList<>();
    ArrayList<Cell> ship4Cells=new ArrayList<>();
    ArrayList<Cell> ship5Cells=new ArrayList<>();
    Button playButton;



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
        playButton =(Button) findViewById(R.id.startButton);

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
                                                ship1Cells.add(mCells.get(position));
                                                ship1Cells.add(mCells.get(position + 1));
                                                ship1Cells.add(mCells.get(position - 10));
                                                ship1Cells.add(mCells.get(position - 20));
                                                for(Cell cell:ship1Cells) {
                                                    if (cell.mBoat) {
                                                        Toast.makeText(PlaceBoatActivity.this, R.string.stackOverFlow, Toast.LENGTH_SHORT).show();
                                                        ship1Cells.clear();
                                                        ship1.setmPositionned(false);
                                                        ship1.setmStartx(0);
                                                        return;
                                                    }
                                                }
                                                for(Cell cell:ship1Cells){
                                                        cell.setmBoat(true);
                                                }
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
                                                ship2Cells.add(mCells.get(position));
                                                ship2Cells.add(mCells.get(position + 1));
                                                ship2Cells.add(mCells.get(position - 1));
                                                ship2Cells.add(mCells.get(position - 9));
                                                ship2Cells.add(mCells.get(position - 11));

                                                for(Cell cell:ship2Cells){
                                                    if(cell.mBoat){
                                                        Toast.makeText(PlaceBoatActivity.this, R.string.stackOverFlow,Toast.LENGTH_SHORT).show();
                                                        ship2Cells.clear();
                                                        ship2.setmStartx(0);
                                                        ship2.setmPositionned(false);
                                                        return;
                                                    }
                                                }
                                                for (Cell cell:ship2Cells){
                                                    cell.setmBoat(true);
                                                }
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
                                                    ship4Cells.add(mCells.get(position));
                                                    ship4Cells.add(mCells.get(position+1));
                                                    ship4Cells.add(mCells.get(position-1));
                                                    for(Cell cell:ship4Cells){
                                                        if(cell.mBoat){
                                                            Toast.makeText(PlaceBoatActivity.this, R.string.stackOverFlow,Toast.LENGTH_SHORT).show();
                                                            ship4Cells.clear();
                                                            ship4.setmStartx(0);
                                                            ship4.setmPositionned(false);
                                                            return;
                                                        }
                                                    }
                                                    for(Cell cell:ship4Cells){
                                                        cell.setmBoat(true);
                                                    }

                                                    mAdapter.notifyDataSetChanged();
                                                }
                                            }
                                        }else{
                                            if(position % 10 == 0 || position % 10 ==9) {
                                                Toast.makeText(PlaceBoatActivity.this, R.string.bad_position, Toast.LENGTH_SHORT).show();
                                            }else{
                                                ship3.setmStartx(position);
                                                ship3.setmPositionned(true);
                                                ship3Cells.add(mCells.get(position));
                                                ship3Cells.add(mCells.get(position+1));
                                                ship3Cells.add(mCells.get(position-1));


                                                for(Cell cell:ship3Cells){
                                                    if(cell.mBoat){
                                                        Toast.makeText(PlaceBoatActivity.this, R.string.stackOverFlow,Toast.LENGTH_SHORT).show();
                                                        ship3Cells.clear();
                                                        ship3.setmStartx(0);
                                                        ship3.setmPositionned(false);
                                                        return;
                                                    }
                                                }
                                                for(Cell cell:ship3Cells){
                                                    cell.setmBoat(true);
                                                }
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
                                                ship5Cells.add(mCells.get(position));
                                                ship5Cells.add(mCells.get(position+1));
                                                for(Cell cell:ship5Cells){
                                                    if(cell.mBoat){
                                                        Toast.makeText(PlaceBoatActivity.this, R.string.stackOverFlow,Toast.LENGTH_SHORT).show();
                                                        ship5Cells.clear();
                                                        ship5.setmStartx(0);
                                                        ship5.setmPositionned(false);
                                                        return;
                                                    }
                                                }
                                                for(Cell cell:ship5Cells){
                                                    cell.setmBoat(true);
                                                }
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

    playButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(ship1.getmPositionned() && ship2.getmPositionned() && ship3.getmPositionned() && ship4.getmPositionned() && ship5.getmPositionned()){
                Intent startGame = new Intent(PlaceBoatActivity.this, GameActivity.class);
                startGame.putExtra("oui",mCells);
                startActivity(startGame);
            }else{
                Toast.makeText(PlaceBoatActivity.this, R.string.missing_ship,Toast.LENGTH_SHORT).show();
            }
        }
    });

    }

}


