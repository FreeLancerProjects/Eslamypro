package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.semicolon.eslamy.R;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout other,simple_call,detail_call;
    TextView txt_other,txt_si,txt_di,en_txt,ar_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);
*/
        initView();
    }

    private void initView() {
        other = findViewById(R.id.other);
        simple_call = findViewById(R.id.simple_call);
        detail_call = findViewById(R.id.detail_call);

        txt_other   = findViewById(R.id.txt_other);
        txt_si      = findViewById(R.id.txt_si);
        txt_di      = findViewById(R.id.di);

        en_txt = findViewById(R.id.en_txt);
        ar_txt = findViewById(R.id.ar_txt);

        other.setOnClickListener(this);
        simple_call.setOnClickListener(this);
        detail_call.setOnClickListener(this);

        Typeface typeface  = Typeface.createFromAsset(getAssets(),"JannaLT-Regular.ttf");
        en_txt.setTypeface(typeface);
        ar_txt.setTypeface(typeface);

        if (Locale.getDefault().equals("ar"))
        {


            txt_si.setTypeface(typeface);
            txt_other.setTypeface(typeface);
            txt_di.setTypeface(typeface);
        }
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
                Intent intent2 = new Intent(HomeActivity.this,LanguageActivity.class);
                intent2.putExtra("type","4");
                startActivity(intent2);
                break;
            case R.id.detail_call:
                Intent intent3 = new Intent(HomeActivity.this,LanguageActivity.class);
                intent3.putExtra("type","5");
                startActivity(intent3);
                break;
        }
    }
}
