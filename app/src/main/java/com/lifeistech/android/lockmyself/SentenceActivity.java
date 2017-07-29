package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.cert.CertPathValidatorException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
    ArrayList LinkedList1;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    SharedPreferences pref;

//以下、for文やwhile文で簡単に！

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        pref = getSharedPreferences("pref_text",MODE_PRIVATE);

        LinkedList1 = new ArrayList<String>();

        Intent intent = getIntent();
        text1 =intent.getStringExtra("Text1");
        editText1.setText(text1);
        text2 =intent.getStringExtra("Text2");
        editText2.setText(text2);
        text3 =intent.getStringExtra("Text3");
        editText3.setText(text3);
        text4 =intent.getStringExtra("Text4");
        editText4.setText(text4);
        text5 =intent.getStringExtra("Text5");
        editText5.setText(text5);
        text6 =intent.getStringExtra("Text6");
        editText6.setText(text6);
        text7 =intent.getStringExtra("Text7");
        editText7.setText(text7);
        text8 =intent.getStringExtra("Text8");
        editText8.setText(text8);



    }

    public void ok(View v) {
        EditText[] edit = {editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8};
        String[] text = {text1,text2,text3,text4,text5,text6,text7,text8};

        for(int i =0;i<=7;i++){
            if(edit[i].length()>=1){
                LinkedList1.add(edit[i].getText().toString());
            }
        }
        int index2 = LinkedList1.size();
        SharedPreferences.Editor editor = pref.edit();
        if(LinkedList1.size()<=2){
            Toast toast = Toast.makeText(SentenceActivity.this, "脅し文を３つ以上入力してください", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Intent intent = new Intent(this,Sentence2Activity.class);
            for(int a = 0;a<=7;a++){
                text[a] = edit[a].getText().toString();
                editor.putString("text"+(a+1),text[a]);
                Log.d("text","text[a]="+text[a]);
            }
            editor.commit();
            intent.putStringArrayListExtra("LinkedList1", LinkedList1);
            intent.putExtra("size",index2);
            startActivity(intent);
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

}
