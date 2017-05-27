package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class subActivity extends AppCompatActivity {

    String goaltext;
    TextView textView1;
    Timer mTimer;
    Timer timer1;
    Timer timer2;
    Handler mHandler;
    Handler handler1;
    Handler handler2;
    int fText;
    int fText1;
    int fText2;
    TextView text1;
    TextView text2;
    String sentence;

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
        fText = intent.getIntExtra("f",0);
        fText1 = intent.getIntExtra("t1",0);
        fText2 = intent.getIntExtra("t2",0);
        textView1.setText(goaltext);
        mHandler = new Handler();
        handler1 = new Handler();
        handler2 = new Handler();


        mTimer = new Timer(false);
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        fText--;
                        Log.d("fT", "「" + fText + "」");

                    }


                });
            }

        },0,1000);

        timer1 = new Timer(false);
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                handler1.post(new Runnable() {
                    @Override
                    public void run() {
                        fText1--;
                        if(fText1<=0) {
                            text1.setText("0");
                        }
                        else {
                            text1.setText(String.valueOf(fText1));
                        }

                    }


                });
            }

        },0,3600000);

        timer2 = new Timer(false);
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                handler2.post(new Runnable() {
                    @Override
                    public void run() {
                        fText2--;
                        if(fText2<=0) {
                            text2.setText("0");
                        }
                        else {
                            text2.setText(String.valueOf(fText2));
                        }

                    }


                });
            }

        },0,60000);



        //if (fText == 0) {
        //    mTimer.cancel();
        //    Intent intent2 = new Intent(this, CongratulationsActivity.class);
        //    startActivity(intent2);
        //}
        //↑ReallyActivityから戻ってきた時、CongratulationsActivityに飛んでしまう原因。
        //本当は、0秒の時、CongratulationsActivityに遷移したい


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


