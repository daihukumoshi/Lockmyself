package com.lifeistech.android.lockmyself;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.view.WindowManager;

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


    static final int RESULT_ENABLE = 1;

    DevicePolicyManager mDevicePolicyManager;
    ComponentName mDarSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

        // DevicePolicyManagerを取得する。
        mDevicePolicyManager = (DevicePolicyManager)getSystemService(this.DEVICE_POLICY_SERVICE);
        // ComponentNameを取得する。
        mDarSample = new ComponentName(this, DarSample.class);
        // デバイス管理を有効にする。
        Intent intent2 = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent2.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
                mDarSample);
        startActivityForResult(intent2, RESULT_ENABLE);

        setContentView(R.layout.activity_sub);
        mDevicePolicyManager.lockNow();



        final Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RESULT_ENABLE:
                if (resultCode == Activity.RESULT_OK) {
                    Log.i("DeviceAdminSample", "Administration enabled!");
                } else {
                    Log.i("DeviceAdminSample", "Administration enable FAILED!");
                }
                return;
        }
        super.onActivityResult(requestCode, resultCode, data);
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


