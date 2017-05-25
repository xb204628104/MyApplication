package com.zykj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] string = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"   };
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listview);
        MyBaseadapter adapter=new MyBaseadapter(this);
        int size = string.length;
        for (int i = 0; i < size; i++) {
            adapter.addSeparatorItem(string[i]);
            for (int k = 0; k < 5; k++) {
                adapter.addItem("item " + k);
            }
        }
        listView.setAdapter(adapter);
    }
}
