package com.travelsoft.lanka.travel_guide.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.travelsoft.lanka.travel_guide.R;
import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;
import com.travelsoft.lanka.travel_guide.utils.UriHandler;

import java.util.ArrayList;

/**
 * Created by Isuru on 2016-03-16.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<GridViewCell> gridViewCellList = new ArrayList<GridViewCell>();

    public GridViewAdapter(Context c) {
        mContext = c;
    }

    public void add(GridViewCell gridViewCell) {
        gridViewCellList.add(gridViewCell);
    }

    public void clear() {
        gridViewCellList.clear();
    }

    public void remove(int index) {
        gridViewCellList.remove(index);
    }

    @Override
    public int getCount() {
        return gridViewCellList.size();
    }

    @Override
    public Object getItem(int position) {
        return gridViewCellList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder gridCellHolder = new Holder();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            convertView = inflater.inflate(R.layout.grid_cell, parent, false);
            gridCellHolder.cellTxt = (TextView) convertView.findViewById(R.id.place_tv);
            gridCellHolder.cellImg = (ImageView) convertView.findViewById(R.id.place_iv);
            gridCellHolder.cellImg.setPadding(8, 8, 8, 8);
            convertView.setTag(gridCellHolder);
        } else {
            gridCellHolder = (Holder) convertView.getTag();
        }

        gridCellHolder.cellTxt.setText(gridViewCellList.get(position).getShortName());

        Uri bm = UriHandler.createUriForAnImage(gridViewCellList.get(position).getIconImageUrl(), 92);

        System.out.println("Image URL : " + bm);

        Picasso.with(mContext)
                .load(bm)
                .placeholder(R.drawable.placeholder_large)
                .centerCrop()
                .resize(92, 92)
                .into(gridCellHolder.cellImg);

        return convertView;
    }

    public class Holder {
        TextView cellTxt;
        ImageView cellImg;
    }
}
