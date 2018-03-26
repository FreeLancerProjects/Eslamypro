package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.semicolon.eslamy.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout quran,aslamt,qustion,mohammed,about,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);
        initView();
        
    }

    private void initView() {

        quran    = findViewById(R.id.rl1);
        aslamt   = findViewById(R.id.rl2);
        qustion  = findViewById(R.id.rl3);
        mohammed = findViewById(R.id.rl4);
        share    = findViewById(R.id.rl5);
        about    = findViewById(R.id.rl6);

        quran.setOnClickListener(this);
        aslamt.setOnClickListener(this);
        qustion.setOnClickListener(this);
        mohammed.setOnClickListener(this);
        share.setOnClickListener(this);
        about.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.rl1:
                Intent intent1 = new Intent(OtherActivity.this,LanguageActivity.class);
                intent1.putExtra("type","1");
                startActivity(intent1);
                break;
            case R.id.rl2:
                Intent intent2 = new Intent(OtherActivity.this,LanguageActivity.class);
                intent2.putExtra("type","2");
                startActivity(intent2);
                break;
            case R.id.rl3:
                Intent intent3 = new Intent(OtherActivity.this,LanguageActivity.class);
                startActivity(intent3);
                break;
            case R.id.rl4:
                Intent intent4 = new Intent(OtherActivity.this,LanguageActivity.class);
                intent4.putExtra("type","3");
                startActivity(intent4);
                break;
            case R.id.rl5:
                break;
            case R.id.rl6:
                break;
        }
    }
}
