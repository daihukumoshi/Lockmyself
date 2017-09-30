package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class ReasonActivity extends AppCompatActivity {
    String reason;
    ListView Listview;
    ArrayAdapter adapter;
    ArrayList LinkedList1;
    int index2;
    String reasons[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        Listview = (ListView) findViewById(R.id.ListView1);
        adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1);
        Listview.setAdapter(adapter);
        Map<String, Integer> m = new HashMap<String, Integer>();


        Intent intent = getIntent();
        index2 = intent.getIntExtra("size",0);
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ReasonData> reasonData = realm.where(ReasonData.class).findAll().sort("reason");
        int size =reasonData.size();

        for(int a = 0;a<size;a++){
            reasons = new String[size];
            reasons[a] = (reasonData.get(a).reason);
            adapter.add(reasons[a]);
        }
        realm.close();
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Disable Back key
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void time(View v){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("LinkedList1", LinkedList1);
        intent.putExtra("size",index2);
        startActivity(intent);
    }
    public void reason(View v){
    }
    public void settei(View v){
        Intent intent = new Intent(this,Sentence2Activity.class);
        intent.putExtra("LinkedList1", LinkedList1);
        intent.putExtra("size",index2);
        startActivity(intent);
    }
    public void list(View v){
        Intent intent = new Intent(this,TodoActivity.class);
        startActivity(intent);
    }
}
