package com.lifeistech.android.lockmyself;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import io.realm.Realm;

public class ReallyActivity extends AppCompatActivity {

    String sentence;
    String reason;
    TextView textView3;
    EditText edit;
    ArrayList LinkedList1;
    int index2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_really);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);


        textView3 = (TextView)findViewById(R.id.textView3) ;
        edit = (EditText)findViewById(R.id.editText9);

        Intent intent2 = getIntent();
        index2 = intent2.getIntExtra("size",0);
        LinkedList1 = intent2.getIntegerArrayListExtra("LinkedList1");
        sentence =intent2.getStringExtra("sentence");

        Log.d("sentence",""+sentence);

        textView3.setText(sentence);
    }

    public void clear(View v){
        if(edit.length()==0){
            Toast toast = Toast.makeText(ReallyActivity.this, "言い訳を入力してください", Toast.LENGTH_SHORT);
            toast.show();
        }

        else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            reason = edit.getText().toString();
            Realm.init(this);
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            ReasonData reasonData = realm.createObject(ReasonData.class);
            reasonData.reason=reason;
            realm.commitTransaction();
            realm.close();

            Intent intent = new Intent(this,ReasonActivity.class);
            intent.putExtra("LinkedList1",LinkedList1);
            intent.putExtra("size",index2);
            startActivity(intent);

        }
    }
    public void back(View v){
       finish();
    }


}
