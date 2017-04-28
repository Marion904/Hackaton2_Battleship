package com.example.wilder.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by mathieu on 27/04/17.
 */

public class ImageAdapter2 extends BaseAdapter {
    private Context mContext;
    private ArrayList<CellHidden> mCells;
    private ArrayList<CellHidden> mCellsBoat;

    public ImageAdapter2(Context c, ArrayList<CellHidden> cells) {
        mContext = c;
        mCells = cells;
    }

    public int getCount() {
        return 100/**mThumbIds.length**/;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        CellHidden c = mCells.get(position);

        ImageView imageView;
        if (convertView == null) {

            // if it's not recycled, initialize some attributes
            BoardCell boardCell = new BoardCell(1, 1);
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(110, 110));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(c.getmImageView());
        return imageView;
    }

}