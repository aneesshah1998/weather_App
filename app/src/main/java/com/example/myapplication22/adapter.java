package com.example.myapplication22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class adapter extends ArrayAdapter {
    private Context context;
    private int layout;
    private ArrayList<wthrdata> data;
    public adapter(@NonNull Context context, int resource, @NonNull ArrayList<wthrdata> objects) {
        super(context, resource, objects);
        this.context=context;
        layout=resource;
        data=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view;
        LayoutInflater inflater= LayoutInflater.from(context);
        view=inflater.inflate(layout,parent,false);
        TextView max=view.findViewById(R.id.max);
        TextView min=view.findViewById(R.id.min);
        wthrdata w=data.get(position);
        max.setText(w.max);
        min.setText(w.min);
        return view;
    }
}
