package com.example.wilder.myapplication;

/**
 * Created by wilder on 27/04/17.
 */

public class Ship {

    private final int mType;
    private final int mSize;
    private final String mName;
    private Boolean mSunk;
    private int mHit;

    private Boolean mPositionned;
    private ShipType mShipType;
    private Direction mDirection;
    private int mx;
    private int my;

    public Ship(ShipType shipType) {
        mType=mShipType.getmType();
        mSize=mShipType.getmSize();
        mName=mShipType.getmName();
        mShipType= shipType;
        mPositionned =false;
        mSunk=false;
        mx=0;
        my=0;
        mHit=0;

    }
    public Ship(int type, int size, String name) {
        mType=type;
        mSize=size;
        mName=name;
        mPositionned =false;
        mSunk=false;
        mx=0;
        my=0;
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

    public Boolean getmPositionned() {
        return mPositionned;
    }

    public void setmPositionned(Boolean mPositionned) {
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

    public int getMx() {
        return mx;
    }

    public void setMx(int mx) {
        this.mx = mx;
    }

    public int getMy() {
        return my;
    }

    public void setMy(int my) {
        this.my = my;
    }
}
