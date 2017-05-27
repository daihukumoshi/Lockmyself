package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.cert.CertPathValidatorException;
import java.util.Random;

public class SentenceActivity extends AppCompatActivity {

    String text1;
    String text2;
    String text3;
    String text4;
    String text5;
    String text6;
    String text7;
    String text8;
    String text9;
    String Sentence;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence);
    }


    public void ok(View v) {


        EditText editText1 = (EditText) findViewById(R.id.editText1);
        text1 = editText1.getText().toString();
        if (text1.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        text2 = editText2.getText().toString();
        if (text2.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        text3 = editText3.getText().toString();
        if (text3.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        text4 = editText4.getText().toString();
        if (text4.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        text5 = editText5.getText().toString();
        if (text5.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        EditText editText6 = (EditText) findViewById(R.id.editText6);
        text6 = editText6.getText().toString();
        if (text6.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        EditText editText7 = (EditText) findViewById(R.id.editText7);
        text7 = editText7.getText().toString();
        if (text7.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        EditText editText8 = (EditText) findViewById(R.id.editText8);
        text8 = editText8.getText().toString();
        if (text8.length() == 0) {
            Toast.makeText(getApplicationContext(),"すべてのパターンに入力してください",Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(this,Sentence2Activity.class);
        startActivity(intent);


        String[] sentence = {text1, text2, text3, text4, text5, text6, text7, text8, text9};
        Random random = new Random();
        int index = random.nextInt(9);
        Sentence = sentence[index];
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Disable Back key
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }






    public void time (View v){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("Sentence",Sentence);
        startActivity(intent);
    }
    public void reason(View v){
        Intent intent = new Intent(this,ReasonActivity.class);
        startActivity(intent);
    }
    public void settei(View v){

    }
    public void home (View v){
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setAction(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    int s;
    String[] ssentence = new String[s];

}
