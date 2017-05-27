package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void time (View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void reason(View v){
        Log.d("reason","クリックされました");
        Intent intent = new Intent(this,ReasonActivity.class);
        startActivity(intent);
    }
    public void settei(View v){
        Intent intent = new Intent(this,Sentence2Activity.class);
        startActivity(intent);
    }
    public void home (View v){
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setAction(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }
}
