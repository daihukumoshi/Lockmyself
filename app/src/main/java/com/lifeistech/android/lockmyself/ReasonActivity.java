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

public class ReasonActivity extends AppCompatActivity {
    String reason;
    ListView Listview;
    ArrayAdapter adapter;
    ArrayList LinkedList1;
    int index2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        Listview = (ListView) findViewById(R.id.ListView1);
        adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1);

        Listview.setAdapter(adapter);

        Intent intent = getIntent();
        reason = intent.getStringExtra("reason");
        index2 = intent.getIntExtra("size",0);


        //Log.d("reason=", String.valueOf(reason ==null));
        if(reason!=null){
            adapter.add(reason);
        }
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
    public void home (View v){
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setAction(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }
}


//課題１：　adapterのデータを、他の画面に遷移しても維持したい！
//ReallyActivity以外から遷移すると、onCreateから、adapterが新しく作られてしまう
