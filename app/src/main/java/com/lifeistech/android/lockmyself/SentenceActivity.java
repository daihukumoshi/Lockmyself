package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.cert.CertPathValidatorException;
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
    String Sentence;
    LinkedList LinkedList1;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;

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

        LinkedList1 = new LinkedList<String>();

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
        Intent intent = new Intent(this,Sentence2Activity.class);
        text1 = editText1.getText().toString();
        if (text1.length()>=1) {
            LinkedList1.add(text1);
        }
        text2 = editText2.getText().toString();
        if (text2.length() >=1) {
            LinkedList1.add(text2);
        }
        text3 = editText3.getText().toString();
        if (text3.length() >=1) {
            LinkedList1.add(text3);
        }
        text4 = editText4.getText().toString();
        if (text4.length() >=1) {
            LinkedList1.add(text4);
        }
        text5 = editText5.getText().toString();
        if (text5.length() >=1) {
            LinkedList1.add(text5);
        }
        text6 = editText6.getText().toString();
        if (text6.length() >=1) {
            LinkedList1.add(text6);
        }
        text7 = editText7.getText().toString();
        if (text7.length() >=1) {
            LinkedList1.add(text7);
        }
        text8 = editText8.getText().toString();
        if (text8.length() >=1) {
            LinkedList1.add(text8);
        }

        int index2 = LinkedList1.size();
        Random random = new Random();
        int index = random.nextInt(index2);
        Sentence =LinkedList1.get(index).toString();

        intent.putExtra("sentence",Sentence);
        intent.putExtra("text1",text1);
        intent.putExtra("text2",text2);
        intent.putExtra("text3",text3);
        intent.putExtra("text4",text4);
        intent.putExtra("text5",text5);
        intent.putExtra("text6",text6);
        intent.putExtra("text7",text7);
        intent.putExtra("text8",text8);

        startActivity(intent);

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
