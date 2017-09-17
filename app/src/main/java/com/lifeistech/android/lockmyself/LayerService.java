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

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        LayoutInflater inflater = LayoutInflater.from(this);

        //画面に常に表示するビューのレイアウトの設定
        WindowManager.LayoutParams params
                = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0, 80,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);
        wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        player_view = inflater.inflate(R.layout.overlay, null);

        final Button closeButton
                = (Button) player_view.findViewById(R.id.button7);
        closeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onDestroy();
            }
        });

        wm.addView(player_view, params);
        //レイヤーにビューを重ねる。
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