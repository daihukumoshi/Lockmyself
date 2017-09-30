package com.lifeistech.android.lockmyself;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mikikyouka on 2017/09/16.
 */
public class LayerService extends Service {
    View player_view;
    //画面に全面表示させるビュー
    WindowManager wm;
    Timer timer2;
    Handler handler2;
    int fText;
    int time1;
    int time2;
    TextView text1;
    TextView text2;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        LayoutInflater inflater = LayoutInflater.from(this);

        //SharedPreferences pref = getSharedPreferences("time",Context.MODE_PRIVATE);
        //time1 = pref.getInt("1",0);
        //time2 = pref.getInt("2",0);
        //Log.d("time1",time1+"");
        //Log.d("time2",time2+"");
        //handler2 = new Handler();

        //fText = time2+time1*60;
        //Log.d("aikatsu",fText+"");

        //timer2 = new Timer(false);
        //timer2.schedule(new TimerTask() {
            //@Override
            //public void run() {
                //handler2.post(new Runnable() {
                    //@Override
                    //public void run() {
                        //if (fText == 0) {
                            //timer2.cancel();
                            //onDestroy();

                        //} else {
                            //time1 = fText / 60;
                            //time2 = fText % 60;
                            //text1 = (TextView) player_view.findViewById(R.id.textView3);
                            //text2 = (TextView) player_view.findViewById(R.id.textView4);
                            //text1.setText(time1+"");
                            //text2.setText(time2+"");
                        //}
                        //fText--;

                        //Log.d("FT=", "" + fText);
                    //}
                //});
            //}
        //},0,60000);
        //画面に常に表示するビューのレイアウトの設定
        WindowManager.LayoutParams params
                = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0, 80,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);
        wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        player_view = inflater.inflate(R.layout.overlay, null);

        wm.addView(player_view, params);
        //レイヤーにビューを重ねる。

        final Button closeButton
                = (Button) player_view.findViewById(R.id.closebutton);
        closeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onDestroy();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        wm.removeView(player_view);
        //ビューをレイヤーから削除する
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}