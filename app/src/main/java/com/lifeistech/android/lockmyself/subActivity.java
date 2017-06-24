package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class subActivity extends AppCompatActivity {
    String goaltext;
    TextView textView1;
    Timer timer2;
    Handler handler2;
    int fText2;
    int fText1;
    int fText;
    TextView text1;
    TextView text2;
    String sentence;

    ArrayList LinkedList1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView1 = (TextView) findViewById(R.id.textView16);
        text1 = (TextView)findViewById(R.id.textView11) ;
        text2 = (TextView)findViewById(R.id.textView12) ;
        Intent intent = getIntent();
        goaltext = intent.getStringExtra("mokuhyou");
        sentence = intent.getStringExtra("sentence");
        LinkedList1 = intent.getIntegerArrayListExtra("LinkedList1");
        fText1 = intent.getIntExtra("t1",0);
        fText2 = intent.getIntExtra("t2",0);
        textView1.setText(goaltext);
        handler2 = new Handler();

        fText = fText2+fText1*60;

        timer2 = new Timer(false);
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                handler2.post(new Runnable() {
                    @Override
                    public void run() {
                        if (fText == 0) {
                            timer2.cancel();
                            Intent intent2 = new Intent(getApplicationContext(), CongratulationsActivity.class);
                            startActivity(intent2);
                        } else {
                            fText1 = fText / 60;
                            fText2 = fText % 60;
                            text2.setText("" + fText2);
                            text1.setText("" + fText1);
                        }
                        fText--;

                        Log.d("FT=", "" + fText);
                    }
                });
            }
        },0,60000);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Disable Back key
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    public void  rock (View v){
        Intent intent = new Intent(this,ReallyActivity.class);
        intent.putExtra("sentence",sentence);
        startActivity(intent);
    }
}


