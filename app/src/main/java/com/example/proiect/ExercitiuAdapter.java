package com.example.proiect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExercitiuAdapter extends ArrayAdapter<Exercitiu> {

    private Context context;
    private int layout;
    private List<Exercitiu> ex;

    public ExercitiuAdapter(@NonNull Context context, int resource,@NonNull List<Exercitiu> objects) {
        super(context, resource);
        this.context=context;
        this.layout=resource;
        this.ex=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Exercitiu exercitiu=ex.get(position);
        View view= LayoutInflater.from(context).inflate(layout,null);
        TextView textViewName=view.findViewById(R.id.textViewName);
        textViewName.setText(exercitiu.getNume());

        return view;
    }

}
