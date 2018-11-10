
package com.nearur.payrec;


import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class Week extends Fragment {

    ListView listView;
    MyAdapter adapter;
    ArrayList<Customer> arrayList;
    ContentResolver resolver;
    public Week() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_week, container, false);
        arrayList=new ArrayList<>();
        resolver=getContext().getContentResolver();
        listView=(ListView)v.findViewById(R.id.listview);
        adapter=new MyAdapter(getContext(),R.layout.item,arrayList);
        listView.setAdapter(adapter);
        get();
        return v;
    }

    void get(){
        String[] p={"Name","Mobile","Amount"};
        Cursor ch=resolver.query(Util.u,p,null,null,null);
        if(ch!=null){
            while(ch.moveToNext()){
                arrayList.add(new Customer(ch.getString(0),ch.getString(1),null,ch.getString(2),null,null));
            }
        }

    }

}
