package com.example.wilder.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wilder on 27/04/17.
 */

public class Cell implements Parcelable{
    int mPosition;
    boolean mBoat;
    int mImageView;
    boolean mHit;

    public Cell(int position){
        mPosition = position;
        mImageView = R.drawable.seatexture;
        mBoat=false;
        mHit=false;
    }

    protected Cell(Parcel in) {
        mPosition = in.readInt();
        mBoat = in.readByte() != 0;
        mImageView = in.readInt();
        mHit = in.readByte() != 0;
    }

    public static final Creator<Cell> CREATOR = new Creator<Cell>() {
        @Override
        public Cell createFromParcel(Parcel in) {
            return new Cell(in);
        }

        @Override
        public Cell[] newArray(int size) {
            return new Cell[size];
        }
    };

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
            mImageView=R.drawable.acier;
        }else{
            mImageView=R.drawable.seatexture;
        }
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
        if(mHit && this.mBoat){
            mImageView=R.drawable.explodepng;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPosition);
        dest.writeByte((byte) (mBoat ? 1 : 0));
        dest.writeInt(mImageView);
        dest.writeByte((byte) (mHit ? 1 : 0));
    }
}
/**    this.mBoat = mBoat;
        if(mBoat){
            mImageView=R.drawable.explodepng;
        }else{
            mImageView=R.drawable.seatexture;
        }
    }**/