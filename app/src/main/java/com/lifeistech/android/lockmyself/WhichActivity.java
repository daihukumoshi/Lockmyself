package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class WhichActivity extends AppCompatActivity {
    ArrayAdapter adapter;
    ListView listView;
    SharedPreferences pref;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        pref = getSharedPreferences("pref_text",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Intent intent = getIntent();
        a=intent.getIntExtra("size",0);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(adapter);

        for(int i = 1;i<=a;i++){
            adapter.add(pref.getString(String.valueOf(i),""));
        }
        adapter.notifyDataSetChanged();
    }
    public void add(View v) {
        Intent intent = new Intent(this,TodoActivity.class);
        intent.putExtra("size",a);
        startActivity(intent);
    }

}
