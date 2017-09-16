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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mikikyouka on 2017/09/16.
 */
public class LayerService extends Service {
    View view;
    WindowManager wm;
    Timer timer2;
    Handler handler2;
    int fText;
    TextView text1;
    TextView text2;
    int fText1;
    int fText2;


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        SharedPreferences pref = getSharedPreferences("time",Context.MODE_PRIVATE);
        fText1 = pref.getInt("1",0);
        fText2 = pref.getInt("2",0);


        // Viewからインフレータを作成する
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        // 重ね合わせするViewの設定を行う
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT);

        // WindowManagerを取得する
        wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        // レイアウトファイルから重ね合わせするViewを作成する
        view = layoutInflater.inflate(R.layout.overlay, null);

        // Viewを画面上に重ね合わせする
        wm.addView(view, params);
        handler2 = new Handler();

    }

    @Override
    public void onCreate() {
        super.onCreate();

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
    public void onDestroy() {
        super.onDestroy();

        // サービスが破棄されるときには重ね合わせしていたViewを削除する
        wm.removeView(view);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
