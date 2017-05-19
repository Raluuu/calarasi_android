package com.miguelcr.a01_simplelist;

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

import java.util.List;

/**
 * Created by miguelcampos on 18/5/17.
 */

public class MyStudentAdapter extends ArrayAdapter<Student> {
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
        ImageView icon = (ImageView) v.findViewById(R.id.imageViewAvatar);
        TextView textViewName = (TextView)v.findViewById(R.id.textViewName);
        TextView textViewAge = (TextView)v.findViewById(R.id.textViewAge);

        // 3. Set into the view components the current FP info
        textViewName.setText(current.getName());
        textViewAge.setText(current.getAge()+" years old");

        if(current.getSex().equals("f")) {
            icon.setImageResource(R.drawable.ic_girl);
        } else {
            icon.setImageResource(R.drawable.ic_boy);
        }

        return v;
    }
}
