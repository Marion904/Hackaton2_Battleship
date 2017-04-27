package com.example.wilder.myapplication;

/**
 * Created by mathieu on 27/04/17.
 */

public enum ShipType {

    LSHAPE(1,3,"LShape"),
    LINE2(2,2,"Line2"),
    LINE3(3,3,"Line3"),
    USHAPE(4,3,"UShape"),;

    private final int mType;
    private final int mSize;
    private final String mName;

    ShipType(int type, int size, String name){
        mType=type;
        mSize = size;
        mName = name;
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
}