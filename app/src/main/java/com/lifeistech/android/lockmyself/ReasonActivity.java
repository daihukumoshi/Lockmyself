package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReasonActivity extends AppCompatActivity {
    String reason;
    ListView Listview;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        Listview = (ListView) findViewById(R.id.ListView1);
        adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1);

        Listview.setAdapter(adapter);

        Intent intent = getIntent();
        reason = intent.getStringExtra("reason");
        //Log.d("reason=", String.valueOf(reason ==null));
        if(reason!=null){
            adapter.add(reason);
        }

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
        startActivity(intent);
    }
    public void reason(View v){
    }
    public void settei(View v){
        Intent intent = new Intent(this,Sentence2Activity.class);
        startActivity(intent);
    }
    public void home (View v){
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setAction(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }
}
