package com.example.wilder.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ArrayList<CellHidden> mCells = new ArrayList<>();
    ArrayList<Cell> myCells = new ArrayList<>();
    ImageAdapter2 foeAdapter = new ImageAdapter2(this, mCells);
    GridView gridview,gridviewMinor;

    Ship ship1 = new Ship(1,4,"LShape");
    Ship ship2 = new Ship(4,5,"UShape");
    Ship ship3 = new Ship(3,3,"Line3");
    Ship ship4 = new Ship(3,3,"Line3");
    Ship ship5 = new Ship(2,2,"Line2");

    ArrayList<CellHidden> ship1Cells=new ArrayList<>();
    ArrayList<CellHidden> ship2Cells=new ArrayList<>();
    ArrayList<CellHidden> ship3Cells=new ArrayList<>();
    ArrayList<CellHidden> ship4Cells=new ArrayList<>();
    ArrayList<CellHidden> ship5Cells=new ArrayList<>();

    ArrayList<Cell> casualities = new ArrayList<>();
    ArrayList<CellHidden> successes = new ArrayList<>();

    String results = "";
    boolean appTurn=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final Intent startGame = getIntent();
        myCells = startGame.getParcelableArrayListExtra("oui");
        ImageAdapter myAdapter2 = new ImageAdapter(GameActivity.this,myCells);

        gridviewMinor = (GridView) findViewById(R.id.gridviewMinor);
        gridviewMinor.setAdapter(myAdapter2);

        for (int i = 0; i < 100; i++) {
            mCells.add(new CellHidden(i));
        }

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(foeAdapter);

        createShip1();
        createShip2();
        createShip3();
        createShip4();
        createShip5();



        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View v,
                                    final int position, long id) {
                CellHidden target = mCells.get(position);
                target.setmHit(true);
                foeAdapter.notifyDataSetChanged();

                //If we miss
                if(target.mBoat){
                    successes.add(target);
                    if(successes.size()==17) {
                        results = getString(R.string.congrats);
                        Intent endGame = new Intent(GameActivity.this,WinnerActivity.class);
                        endGame.putExtra("results",results);
                        startActivity(endGame);
                    }
                }else{
                    appTurn=true;
                    while(appTurn==true){
                        randomShoot();
                        if (casualities.size() == 17) {
                            results = getString(R.string.looser);
                            Intent endGame = new Intent(GameActivity.this, WinnerActivity.class);
                            endGame.putExtra("results", results);
                            startActivity(endGame);
                        }
                    }
                }
            }
        });



    }

    public void createShip1(){
        while (ship1.getmStartx()==0){
            int position = new Random().nextInt(99);
            if(position>19 && position % 10 !=9){
                ship1.setmStartx(position);
                ship1.setmPositionned(true);
                ship1Cells.add(mCells.get(position));
                ship1Cells.add(mCells.get(position + 1));
                ship1Cells.add(mCells.get(position - 10));
                ship1Cells.add(mCells.get(position - 20));
            }
        }
        for(CellHidden cell:ship1Cells){
            cell.setmBoat(true);
        }
        foeAdapter.notifyDataSetChanged();
    }

    public void createShip2(){
        while (!ship2.getmPositionned()){
            while (ship2.getmStartx()==0){
                int position = new Random().nextInt(99);
                if(position>10 && position % 10 != 0 && position % 10 !=9){
                    ship2.setmStartx(position);
                    ship2.setmPositionned(true);
                    ship2Cells.add(mCells.get(position));
                    ship2Cells.add(mCells.get(position + 1));
                    ship2Cells.add(mCells.get(position - 1));
                    ship2Cells.add(mCells.get(position - 9));
                    ship2Cells.add(mCells.get(position - 11));
                }
            }
            for(int j = 0; j<ship2Cells.size();j++){
                if(ship2Cells.get(j).mBoat){
                    //ship2Cells.clear();
                    for(int i = 0; i< ship2Cells.size();i++){
                        ship2Cells.remove(i);
                    }
                    ship2.setmStartx(0);
                    ship2.setmPositionned(false);
                }
            }
        }
        for(CellHidden cell:ship2Cells){
            cell.setmBoat(true);
        }
        foeAdapter.notifyDataSetChanged();
    }

    public void createShip3(){
        while (!ship3.getmPositionned()){
            while (ship3.getmStartx()==0){
                int position = new Random().nextInt(99);
                if(position % 10 != 0 && position % 10 !=9){
                    ship3.setmStartx(position);
                    ship3.setmPositionned(true);
                    ship3Cells.add(mCells.get(position));
                    ship3Cells.add(mCells.get(position+1));
                    ship3Cells.add(mCells.get(position-1));
                }
            }
            for(int j =0; j<ship3Cells.size();j++){
                if(ship3Cells.get(j).mBoat){
                    //ship3Cells.clear();
                    for(int i = 0; i< ship3Cells.size();i++){
                        ship3Cells.remove(i);
                    }
                    ship3.setmStartx(0);
                    ship3.setmPositionned(false);
                }
            }
        }

        for(CellHidden cell:ship3Cells){
            cell.setmBoat(true);
        }
        foeAdapter.notifyDataSetChanged();
    }

    public void createShip4(){
        while (!ship4.getmPositionned()){
            while (ship4.getmStartx()==0){
                int position = new Random().nextInt(99);
                if(position % 10 != 0 && position % 10 !=9){
                    ship4.setmStartx(position);
                    ship4.setmPositionned(true);
                    ship4Cells.add(mCells.get(position));
                    ship4Cells.add(mCells.get(position+1));
                    ship4Cells.add(mCells.get(position-1));
                }
            }
            for(int j=0;j<ship4Cells.size();j++){
                if(ship4Cells.get(j).mBoat){
                    //ship4Cells.clear();
                    for(int i = 0; i< ship4Cells.size();i++){
                        ship4Cells.remove(i);
                    }
                    ship4.setmStartx(0);
                    ship4.setmPositionned(false);
                }
            }
        }

        for(CellHidden cell:ship4Cells){
            cell.setmBoat(true);
        }
        foeAdapter.notifyDataSetChanged();
    }

    public void createShip5(){
        while (!ship5.getmPositionned()){
            while (ship5.getmStartx()==0){
                int position = new Random().nextInt(99);
                if(position % 10 !=9){
                    ship5.setmStartx(position);
                    ship5.setmPositionned(true);
                    ship5Cells.add(mCells.get(position));
                    ship5Cells.add(mCells.get(position+1));
                }
            }
            for(int j = 0; j<ship5Cells.size();j++){
                if(ship5Cells.get(j).mBoat){
                    //ship5Cells.clear();
                    for(int i = 0; i< ship5Cells.size();i++){
                        ship5Cells.remove(i);
                    }
                    ship5.setmStartx(0);
                    ship5.setmPositionned(false);
                }
            }
        }

        for(CellHidden cell:ship5Cells){
            cell.setmBoat(true);
        }
        foeAdapter.notifyDataSetChanged();
    }

    public void randomShoot(){
        int position = new Random().nextInt(99);
        Cell shoot = myCells.get(position);
        shoot.setmHit(true);
        if(shoot.mBoat){
            casualities.add(shoot);
            appTurn=true;
        }else{
            appTurn=false;
        }
        //return shoot;
    }
}




