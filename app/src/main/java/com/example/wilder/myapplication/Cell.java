package com.example.wilder.myapplication;

/**
 * Created by wilder on 27/04/17.
 */

public class Cell {
    int mPosition;
    boolean mBoat;
    int mImageView;

    public Cell(int position){
        mPosition = position;
        mImageView = R.drawable.seatexture;
        mBoat=false;
    }

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public boolean ismBoat() {
        return mBoat;
    }

    public void setmBoat(boolean mBoat) {
        this.mBoat = mBoat;
        if(mBoat){
            mImageView=R.drawable.explodepng;
        }else{
            mImageView=R.drawable.seatexture;
        }
    }

    public int getmImageView() {
        return mImageView;
    }
}
