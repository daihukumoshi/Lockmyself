package com.lifeistech.android.lockmyself;

import android.app.TimePickerDialog;
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
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    EditText editText3;
    String text3;
    ArrayList LinkedList1;
    int index;
    String sentence;
    int index2;
    TextView textView19;
    TextView TextView1;
    TextView TextView2;
    int oclock;
    int minutes;
    String oText;
    String mText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        LinkedList1 = intent.getIntegerArrayListExtra("LinkedList1");

        index2 = intent.getIntExtra("size",0);
        editText3 = (EditText) findViewById(R.id.editText3);

        TextView1 = (TextView)findViewById(R.id.TextView2);
        TextView2 = (TextView)findViewById(R.id.TextView1);

        if(index2!=0){
            Random random = new Random();
            index = random.nextInt(index2);
        }else{
            index2=0;
        }


        //textView19 = (TextView)findViewById(R.id.textView19);

        //textView19.setText("アプリの円滑な利用のため、\n"+"必ずロックを許可してください");

    }

    public void change (View v) {

        final Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        final TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(MainActivity.this,
                                String.valueOf(hourOfDay) + ":" + String.valueOf(minute),
                                Toast.LENGTH_SHORT);



                        oclock = hourOfDay;
                        minutes = minute;
                        oText = String.valueOf(oclock);
                        mText = String.valueOf(minutes);

                        TextView1.setText(oText);
                        TextView2.setText(mText);
                    }
                }, hour, minute, true);
        timePickerDialog.show();
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

        Log.d("start","start = ");

        if(LinkedList1==null){
            Toast.makeText(this,"設定から文を入力もしくは\n"+"更新してください",Toast.LENGTH_SHORT).show();
        } else{

        if(oText.length()==0&&mText.length() == 0){

            Toast toast = Toast.makeText(MainActivity.this, "時間を入力してください", Toast.LENGTH_SHORT);
            toast.show();
            }
        else{
            Text1 = oclock;
            Text2 = minutes;
            fText1 = Text1 * 3600;
            fText2 = Text2 * 60;
            fText = fText1 + fText2;
            text3 = editText3.getText().toString();

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


