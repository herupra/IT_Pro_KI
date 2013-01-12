package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listitem extends ArrayAdapter<listheader>{

    Context context;
    int layoutResourceId;   
    listheader data[] = null;
   
    public listitem(Context context, int layoutResourceId, listheader[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
     
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        listheaderHolder holder = null;
       
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new listheaderHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
           
            row.setTag(holder);
        }
        else
        {
            holder = (listheaderHolder)row.getTag();
        }
       
        listheader listheader = data[position];
        holder.txtTitle.setText(listheader.title);
        holder.imgIcon.setImageResource(listheader.icon);
       
        return row;
    }
   
    static class listheaderHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}