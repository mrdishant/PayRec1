package com.nearur.payrec;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter{

    Context context;int resource; ArrayList<Customer> objects;

    public MyAdapter(Context context,int resource, ArrayList<Customer> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v= LayoutInflater.from(context).inflate(resource,parent,false);

        CheckedTextView name=(CheckedTextView)v.findViewById(R.id.checkedTextViewname);
        TextView phone=(TextView)v.findViewById(R.id.textViewphone);
        TextView amount=(TextView)v.findViewById(R.id.textViewamount);

        Customer c=objects.get(position);

        name.setText(c.name);
        phone.setText(c.mobile);
        amount.setText(c.amount);

        return v;
    }
}
