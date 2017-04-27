package com.example.wilder.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wilder on 27/04/17.
 */

public class Ship implements Parcelable{

    private final int mType;
    private final int mSize;
    private final String mName;
    private boolean mSunk;
    private int mHit;

    private boolean mPositionned;
    private ShipType mShipType;
    private Direction mDirection;
    private int mStartx;


    public Ship(ShipType shipType) {
        mType=mShipType.getmType();
        mSize=mShipType.getmSize();
        mName=mShipType.getmName();
        mShipType= shipType;
        mPositionned =false;
        mSunk=false;
        mStartx=0;
        mHit=0;

    }
    public Ship(int type, int size, String name) {
        mType=type;
        mSize=size;
        mName=name;
        mPositionned =false;
        mSunk=false;
        mStartx=0;

        mHit=0;
    }

    protected Ship(Parcel in) {
        mType = in.readInt();
        mSize = in.readInt();
        mName = in.readString();
        mSunk = in.readByte() != 0;
        mHit = in.readInt();
        mPositionned = in.readByte() != 0;
        mStartx = in.readInt();
    }

    public static final Creator<Ship> CREATOR = new Creator<Ship>() {
        @Override
        public Ship createFromParcel(Parcel in) {
            return new Ship(in);
        }

        @Override
        public Ship[] newArray(int size) {
            return new Ship[size];
        }
    };

    public int getmType() {
        return mType;
    }

    public int getmSize() {
        return mSize;
    }

    public String getmName() {
        return mName;
    }

    public boolean getmPositionned() {
        return mPositionned;
    }

    public void setmPositionned(boolean mPositionned) {
        this.mPositionned = mPositionned;
    }

    public ShipType getmShipType() {
        return mShipType;
    }

    public void setmShipType(ShipType mShipType) {
        this.mShipType = mShipType;
    }

    public Direction getmDirection() {
        return mDirection;
    }

    public void setmDirection(Direction mDirection) {
        this.mDirection = mDirection;
    }

    public int getmStartx() {
        return mStartx;
    }

    public void setmStartx(int startx) {
        this.mStartx = startx;
    }

    public boolean ismSunk() {
        return mSunk;
    }

    public void setmSunk(boolean mSunk) {
        this.mSunk = mSunk;
    }

    public int getmHit() {
        return mHit;
    }

    public void setmHit(int mHit) {
        this.mHit = mHit;
    }

    public boolean ismPositionned() {
        return mPositionned;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mType);
        dest.writeInt(mSize);
        dest.writeString(mName);
        dest.writeByte((byte) (mSunk ? 1 : 0));
        dest.writeInt(mHit);
        dest.writeByte((byte) (mPositionned ? 1 : 0));
        dest.writeInt(mStartx);
    }
}
