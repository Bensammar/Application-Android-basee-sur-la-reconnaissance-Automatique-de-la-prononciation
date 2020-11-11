package com.example.acer.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by acer on 17/03/2018.
 */

public class gridViewAdpter extends ArrayAdapter<categorie> {
    public gridViewAdpter(Context context, int resource, List<categorie> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(null == v) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.grid_item, null);
        }
        categorie categorie = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        TextView txtTitle = (TextView) v.findViewById(R.id.titre);
        TextView txtDescription = (TextView) v.findViewById(R.id.txdescription);

        img.setImageResource(categorie.getImageid());
        txtTitle.setText(categorie.getTitle());
        txtDescription.setText(categorie.getDescription());

        return v;
    }
}
