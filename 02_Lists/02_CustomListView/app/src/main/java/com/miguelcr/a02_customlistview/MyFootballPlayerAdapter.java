package com.miguelcr.a02_customlistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 11/5/17.
 */

class MyFootballPlayerAdapter extends ArrayAdapter<FootballPlayer> {
    Context ctx;
    int template;
    List<FootballPlayer> values;


    public MyFootballPlayerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<FootballPlayer> objects) {
        super(context, resource, objects);

        ctx = context;
        template = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template, parent, false);

        // 1. Get the current item (footballplayer)
        FootballPlayer current = values.get(position);

        // 2. View components
        TextView textViewName = (TextView)v.findViewById(R.id.textViewName);
        TextView textViewAge = (TextView)v.findViewById(R.id.textViewAge);
        RatingBar ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);

        // 3. Set into the view components the current FP info
        textViewName.setText(current.getName());
        textViewAge.setText(current.getAge()+" years old");
        ratingBar.setRating(current.getRate());

        return v;
    }
}
