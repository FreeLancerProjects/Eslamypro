package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.semicolon.eslamy.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout other,simple_call,detail_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);

        initView();
    }

    private void initView() {
        other = findViewById(R.id.other);
        simple_call = findViewById(R.id.simple_call);
        detail_call = findViewById(R.id.detail_call);

        other.setOnClickListener(this);
        simple_call.setOnClickListener(this);
        detail_call.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.other:
                Intent intent = new Intent(HomeActivity.this,OtherActivity.class);
                startActivity(intent);
                break;
            case R.id.simple_call:
                Toast.makeText(this, "simple call", Toast.LENGTH_SHORT).show();

                break;
            case R.id.detail_call:
                Toast.makeText(this, "detail call", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
