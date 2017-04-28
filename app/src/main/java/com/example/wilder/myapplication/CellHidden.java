package com.example.wilder.myapplication;

/**
 * Created by wilder on 28/04/17.
 */

public class CellHidden {
    int mPosition;
    boolean mBoat;
    int mImageView;
    boolean mHit;

    public CellHidden(int position){
        mPosition = position;
        mImageView = R.drawable.seatexture;
        mBoat=false;
        mHit=false;
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
    }

    public int getmImageView() {
        return mImageView;
    }

    public void setmImageView(int mImageView) {
        this.mImageView = mImageView;
    }

    public boolean ismHit() {
        return mHit;
    }

    public void setmHit(boolean mHit) {
        this.mHit = mHit;
        if(this.mHit){
            if(this.mBoat) {
                mImageView = R.drawable.explodepng;
            }else{
                mImageView = R.drawable.seatexturegrey;
            }
        }
    }
}
