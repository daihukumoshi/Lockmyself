package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sentence2Activity extends AppCompatActivity {

    String Text1;
    String Text2;
    String Text3;
    String Text4;
    String Text5;
    String Text6;
    String Text7;
    String Text8;
    ArrayList LinkedList1;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    HashMap hashMap;
    int index2;
    SharedPreferences pref;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence2);
        hashMap = new HashMap<String,String>();
        pref = getSharedPreferences("pref_text",MODE_PRIVATE);


        textView1 = (TextView)findViewById(R.id.textView9);
        textView2 = (TextView)findViewById(R.id.textView10);
        textView3 = (TextView)findViewById(R.id.textView11);
        textView4 = (TextView)findViewById(R.id.textView12);
        textView5 = (TextView)findViewById(R.id.textView13);
        textView6 = (TextView)findViewById(R.id.textView14);
        textView7 = (TextView)findViewById(R.id.textView15);
        textView8 = (TextView)findViewById(R.id.textView16);

            SharedPreferences.Editor editor = pref.edit();
            textView1.setText(pref.getString("text1",""));
            textView2.setText(pref.getString("text2",""));
            textView3.setText(pref.getString("text3",""));
            textView4.setText(pref.getString("text4",""));
            textView5.setText(pref.getString("text5",""));
            textView6.setText(pref.getString("text6",""));
            textView7.setText(pref.getString("text7",""));
            textView8.setText(pref.getString("text8",""));

            Intent intent = getIntent();
            LinkedList1 = intent.getIntegerArrayListExtra("LinkedList1");
            index2 = intent.getIntExtra("size",0);
            Text1 = pref.getString("text1","");
            Text2 = pref.getString("text2","");
            Text3 = pref.getString("text3","");
            Text4 = pref.getString("text4","");
            Text5 = pref.getString("text5","");
            Text6 = pref.getString("text6","");
            Text7 = pref.getString("text7","");
            Text8 = pref.getString("text8","");

        String[] text = {Text1,Text2,Text3,Text4,Text5,Text6,Text7,Text8};


        for(int i = 0;i<=7;i++){
            if(text[i]==null){
                text[i]=" ";
                hashMap.put(text[i],text[i]);
            }else{
                hashMap.put(text[i],text[i]);

            }
        }

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
        intent.putExtra("LinkedList1",LinkedList1);
        intent.putExtra("size",index2);
        startActivity(intent);
    }
    public void reason(View v){
        Intent intent = new Intent(this,ReasonActivity.class);
        intent.putExtra("LinkedList1",LinkedList1);
        intent.putExtra("size",index2);
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
