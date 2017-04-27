package com.example.wilder.myapplication;

/**
 * Created by wilder on 27/04/17.
 */

public class Ship implements {

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
}