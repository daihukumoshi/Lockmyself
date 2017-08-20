package com.lifeistech.android.lockmyself;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
    public void list(View v){
        Intent intent = new Intent(this,WhichActivity.class);
        startActivity(intent);
    }
}
