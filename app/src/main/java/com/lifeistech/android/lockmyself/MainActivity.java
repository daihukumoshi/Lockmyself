package com.lifeistech.android.lockmyself;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {
    private static final int ADMIN_INTENT = 1;
    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mComponentName;

    int Text1;
    int Text2;
    int fText1;
    int fText2;
    int fText;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    String text3;
    String text2;
    String text1;
    ArrayList LinkedList1;
    int index;
    String sentence;
    int index2;
    TextView textView19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        LinkedList1 = intent.getIntegerArrayListExtra("LinkedList1");

        index2 = intent.getIntExtra("size",0);

        editText1= (EditText) findViewById(R.id.editText);
        editText1.setInputType( InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);

        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setInputType( InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);

        editText3 = (EditText) findViewById(R.id.editText3);
        if(index2!=0){
            Random random = new Random();
            index = random.nextInt(index2);
        }else{
            index2=0;
        }


        //textView19 = (TextView)findViewById(R.id.textView19);

        //textView19.setText("アプリの円滑な利用のため、\n"+"必ずロックを許可してください");

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

        if(LinkedList1==null){
            Toast.makeText(this,"設定から文を入力もしくは\n"+"更新してください",Toast.LENGTH_LONG).show();
        } else{
        Log.d("text1", ""+editText1.length());
        Log.d("text2", ""+editText2.length());

        if(editText1.length()==0&&editText2.length() == 0){

            Toast toast = Toast.makeText(MainActivity.this, "時間を入力してください", Toast.LENGTH_SHORT);
            toast.show();

        }else {


            text1 = editText1.getText().toString();
            text2 = editText2.getText().toString();
            text3 = editText3.getText().toString();

            if (editText1.length() == 0) {
                text1 = "0";
            }
            if (editText2.length() == 0) {
                text2 = "0";
            }


            Text1 = Integer.parseInt(text1);
            Text2 = Integer.parseInt(text2);
            fText1 = Text1 * 3600;
            fText2 = Text2 * 60;
            fText = fText1 + fText2;

            Intent intent2 = new Intent(this, subActivity.class);
            intent2.putExtra("mokuhyou", text3);//Edittext3にある目標をsubActivityに受け渡す
            intent2.putExtra("t1", Text1);
            intent2.putExtra("t2", Text2);
            sentence = LinkedList1.get(index).toString();//落ちる
            intent2.putExtra("sentence", sentence);
            startActivity(intent2);
            }

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
    public void list(View v){
        Intent intent = new Intent(this,TodoActivity.class);
        startActivity(intent);
    }

}
