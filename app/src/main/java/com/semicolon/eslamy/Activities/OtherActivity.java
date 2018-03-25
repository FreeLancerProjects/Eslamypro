package com.semicolon.eslamy.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.semicolon.eslamy.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);

        
    }


}
