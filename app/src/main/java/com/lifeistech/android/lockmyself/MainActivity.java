package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {


    String Sentence;
    int Text1;
    int Text2;
    int fText1;
    int fText2;
    int fText;
    int t1;
    int t2;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    String text3;
    String text2;
    String text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Intent intent = getIntent();
    Sentence =intent.getStringExtra("Sentence");

        editText1= (EditText) findViewById(R.id.editText);
        editText1.setInputType( InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);

        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setInputType( InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);

        editText3 = (EditText) findViewById(R.id.editText3);
        text1 = editText1.getText().toString();
        text2 = editText2.getText().toString();
        text3 = editText3.getText().toString();
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
        //スタートボタンを押した時、必ずおめでとう画面に遷移してしまう

        if(editText1.length()+editText2.length()==0){
            Toast toast = Toast.makeText(MainActivity.this, "時間を入力してください", Toast.LENGTH_SHORT);
            toast.show();

        }else{
            if(text1.length()==0){
                text1="0";
            }
            if(text2.length()==0){
                text2="0";
            }
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



    }
    public void time (View v){
    }
    public void reason(View v){
        Intent intent = new Intent(this,ReasonActivity.class);
        startActivity(intent);
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
