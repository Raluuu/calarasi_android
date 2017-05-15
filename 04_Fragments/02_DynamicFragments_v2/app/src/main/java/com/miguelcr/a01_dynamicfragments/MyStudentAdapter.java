package com.miguelcr.a01_dynamicfragments;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 15/5/17.
 */

class MyStudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    int template;
    List<Student> values;


    public MyStudentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);

        ctx = context;
        template = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template, parent, false);

        // 1. Get the current item
        Student current = values.get(position);

        // 2. View components
        ImageView imageViewPhoto = (ImageView) v.findViewById(R.id.imageViewPhoto);
        TextView textViewName = (TextView)v.findViewById(R.id.textViewName);

        // 3. Set into the view components the current FP info
        textViewName.setText(current.getName());
        Picasso.with(ctx).load(current.getPhotoPath()).into(imageViewPhoto);

        return v;
    }
}
