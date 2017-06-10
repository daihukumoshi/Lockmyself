package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Sentence2Activity extends AppCompatActivity {
    String sentence;
    String Text1;
    String Text2;
    String Text3;
    String Text4;
    String Text5;
    String Text6;
    String Text7;
    String Text8;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    HashMap hashMap;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence2);
        hashMap = new HashMap<String,String>();

        textView1 = (TextView)findViewById(R.id.textView9);
        textView2 = (TextView)findViewById(R.id.textView10);
        textView3 = (TextView)findViewById(R.id.textView11);
        textView4 = (TextView)findViewById(R.id.textView12);
        textView5 = (TextView)findViewById(R.id.textView13);
        textView6 = (TextView)findViewById(R.id.textView14);
        textView7 = (TextView)findViewById(R.id.textView15);
        textView8 = (TextView)findViewById(R.id.textView16);

            Intent intent = getIntent();
            sentence =intent.getStringExtra("sentence");
            Text1 = intent.getStringExtra("text1");
            Text2 = intent.getStringExtra("text2");
            Text3 = intent.getStringExtra("text3");
            Text4 = intent.getStringExtra("text4");
            Text5 = intent.getStringExtra("text5");
            Text6 = intent.getStringExtra("text6");
            Text7 = intent.getStringExtra("text7");
            Text8 = intent.getStringExtra("text8");

        String[] text = {Text1,Text2,Text3,Text4,Text5,Text6,Text7,Text8};


        for(int i = 0;i<=7;i++){
            if(text[i]==null){
                text[i]=" ";
                hashMap.put(text[i],text[i]);
            }else{
                hashMap.put(text[i],text[i]);

            }
        }

        textView1.setText(hashMap.get(text[0]).toString());
        textView2.setText(hashMap.get(text[1]).toString());
        textView3.setText(hashMap.get(text[2]).toString());
        textView4.setText(hashMap.get(text[3]).toString());
        textView5.setText(hashMap.get(text[4]).toString());
        textView6.setText(hashMap.get(text[5]).toString());
        textView7.setText(hashMap.get(text[6]).toString());
        textView8.setText(hashMap.get(text[7]).toString());


    }

    public void change(View v){
        Intent intent = new Intent(this,SentenceActivity.class);
        intent.putExtra("Text1",Text1);
        intent.putExtra("Text2",Text2);
        intent.putExtra("Text3",Text3);
        intent.putExtra("Text4",Text4);
        intent.putExtra("Text5",Text5);
        intent.putExtra("Text6",Text6);
        intent.putExtra("Text7",Text7);
        intent.putExtra("Text8",Text8);
        startActivity(intent);
    }
    public void time (View v){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("sentence",sentence);
        startActivity(intent);
    }
    public void reason(View v){
        Intent intent = new Intent(this,ReasonActivity.class);
        intent.putExtra("sentence",sentence);
        startActivity(intent);
    }
    public void settei(View v){
    }
    public void home (View v){
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setAction(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }
}
