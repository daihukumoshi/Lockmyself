package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ReallyActivity extends AppCompatActivity {

    String sentence;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_really);

        textView3 = (TextView)findViewById(R.id.textView3) ;
        Intent intent2 = getIntent();
        sentence =intent2.getStringExtra("sentence");

        textView3.setText(sentence);
    }

    public void clear(View v){
        Intent intent = new Intent(this,ReasonActivity.class);
        startActivity(intent);
    }
    public void back(View v){
        Intent intent = new Intent(this,subActivity.class);
        startActivity(intent);
    }


}
