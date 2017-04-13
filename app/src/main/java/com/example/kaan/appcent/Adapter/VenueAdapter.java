package com.example.kaan.appcent.Adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.kaan.appcent.Model.Venue;
import com.example.kaan.appcent.R;

import java.util.List;

/**
 * Created by kaan on 12.04.2017.
 */


public class VenueAdapter extends BaseAdapter
{

    private LayoutInflater layoutInflater;
    private List<Venue> venues;



    public VenueAdapter(Context context, List<Venue> venues) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.venues = venues;
    }

    @Override
    public int getCount() {
        return venues.size();
    }

    @Override
    public Object getItem(int position) {
        return venues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        String URL;
        if(row == null)
            row = layoutInflater.inflate(R.layout.row_place, null);
        ImageView ivVenueIcon= (ImageView) row.findViewById(R.id.ivVenueIcon);
        TextView tvVenueName = (TextView) row.findViewById(R.id.tvVenueName);
        tvVenueName.setText(venues.get(position).getName());
        return row;
    }
}
