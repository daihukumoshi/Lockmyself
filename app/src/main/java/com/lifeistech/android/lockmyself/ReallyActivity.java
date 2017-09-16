package com.lifeistech.android.lockmyself;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.lifeistech.android.lockmyself.R.id.listView;
import static com.lifeistech.android.lockmyself.R.id.text;

public class ReallyActivity extends AppCompatActivity {

    String sentence;
    String reason;
    TextView textView3;
    ArrayList LinkedList1;
    int index2;
    String reasons[];
    AutoCompleteTextView ATview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_really);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ReasonData> reasonData = realm.where(ReasonData.class).findAll();
        int size =reasonData.size();
        reasons = new String[size];
        for(int a = 0;a<size;a++){
            reasons[a] = (reasonData.get(a).reason);
        }
        realm.close();

        ATview= (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView_reasons);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, reasons);
        ATview.setAdapter(adapter);

        //ドロップダウンリスト最下段に表示されるヒント
        ATview.setCompletionHint("過去の言い訳");
        //オートコンプリート開始までの文字数(0以下は指定できない)
        ATview.setThreshold(1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);


        textView3 = (TextView)findViewById(R.id.textView3) ;

        Intent intent2 = getIntent();
        index2 = intent2.getIntExtra("size",0);
        LinkedList1 = intent2.getIntegerArrayListExtra("LinkedList1");
        sentence =intent2.getStringExtra("sentence");

        Log.d("sentence",""+sentence);

        textView3.setText(sentence);
    }
    public void clear(View v){
        if(ATview.length()==0){
            Toast toast = Toast.makeText(ReallyActivity.this, "言い訳を入力してください", Toast.LENGTH_SHORT);
            toast.show();
        }

        else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            reason = ATview.getText().toString();
                    Realm.init(this);
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    ReasonData reasonData = realm.createObject(ReasonData.class);
                    reasonData.reason=reason;
                    realm.commitTransaction();
                    realm.close();
                    Intent intent = new Intent(this,ReasonActivity.class);
                intent.putExtra("LinkedList1",LinkedList1);
                intent.putExtra("size",index2);
                startActivity(intent);

        }
    }
    public void back(View v){
       finish();
    }


}
