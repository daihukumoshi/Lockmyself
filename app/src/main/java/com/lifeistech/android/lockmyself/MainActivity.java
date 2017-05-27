package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {


    String Sentence;
    int Text1;
    int Text2;
    int fText1;
    int fText2;
    int fText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Intent intent = getIntent();
    Sentence =intent.getStringExtra("Sentence");

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
         //Disable Back key
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }

       return super.onKeyDown(keyCode, event);
    }





    public void start (View v) {
        EditText editText1 = (EditText) findViewById(R.id.editText);
        String text1 = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String text2 = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String text3 = editText3.getText().toString();

        Text1 = Integer.parseInt(text1);
        Text2 = Integer.parseInt(text2);
        fText1 = Text1*3600;
        fText2 = Text2*60;
        fText = fText1+fText2;

        Intent intent2 = new Intent(this,subActivity.class);
        intent2.putExtra("mokuhyou",text3);//Edittext3にある目標をsubActivityに受け渡す
        intent2.putExtra("sentence",Sentence);
        intent2.putExtra("f",fText);
        intent2.putExtra("t1",Text1);
        intent2.putExtra("t2",Text2);
        startActivity(intent2);
    }
    public void time (View v){
    }
    public void reason(View v){
        Intent intent = new Intent(this,ReasonActivity.class);
        startActivity(intent);
    }
    public void settei(View v){
        Intent intent = new Intent(this,SentenceActivity.class);
        startActivity(intent);
    }
    public void home (View v){
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setAction(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

}
