package com.zykj.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by zykj on 2017/5/25.
 */

public class MyBaseadapter extends BaseAdapter {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
    private List<String> strings=new ArrayList<String>();
    private LayoutInflater  inflater;
    private TreeSet<Integer> set = new TreeSet<Integer>();

    public MyBaseadapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void addItem(String item) {
        strings.add(item);
    }

    public void addSeparatorItem(String item) {
        strings.add(item);
        set.add(strings.size() - 1);
    }

    public int getItemViewType(int position) {
        return set.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }
    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        int itemViewType = getItemViewType(position);
        if (convertView==null){
            viewHolder=new ViewHolder();
            switch (itemViewType){
                case TYPE_ITEM:
                    convertView=inflater.inflate(R.layout.item1,null);
                    viewHolder.textView= (TextView) convertView.findViewById(R.id.item1);
                    break;
                case TYPE_SEPARATOR:
                    convertView=inflater.inflate(R.layout.item2,null);
                    viewHolder.textView= (TextView) convertView.findViewById(R.id.item2);
                    break;
            }
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(strings.get(position));
        return convertView;
    }
    public static class ViewHolder {
        public TextView textView;
    }
}
