package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.semicolon.eslamy.R;

import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;

public class OtherActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout quran,aslamt,qustion,mohammed,about,share,advistors;
    private ImageView home;
    private TextView hq,pm,faq,nm,cu,sh;
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
        advistors=findViewById(R.id.txt_advistors);
        home     =findViewById(R.id.img_home);
        quran.setOnClickListener(this);
        aslamt.setOnClickListener(this);
        qustion.setOnClickListener(this);
        mohammed.setOnClickListener(this);
        share.setOnClickListener(this);
        about.setOnClickListener(this);
        advistors.setOnClickListener(this);
        home.setOnClickListener(this);

        hq = findViewById(R.id.hq);
        nm = findViewById(R.id.nm);
        faq= findViewById(R.id.faq);
        cu = findViewById(R.id.cu);
        sh = findViewById(R.id.sh);
        pm = findViewById(R.id.pm);

        Typeface typeface  = Typeface.createFromAsset(getAssets(),"JannaLT-Regular.ttf");
        if (Locale.getDefault().equals("ar"))
        {
            hq.setTypeface(typeface);
            nm.setTypeface(typeface);
            faq.setTypeface(typeface);
            cu.setTypeface(typeface);
            sh.setTypeface(typeface);
            pm.setTypeface(typeface);
        }
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
                intent3.putExtra("type","question");
                startActivity(intent3);
                break;
            case R.id.rl4:
                Intent intent4 = new Intent(OtherActivity.this,LanguageActivity.class);
                intent4.putExtra("type","3");
                startActivity(intent4);
                break;
            case R.id.rl5:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, download this app!");
                startActivity(shareIntent.createChooser(shareIntent,"Share via"));
                break;
            case R.id.rl6:
                Intent intent6 = new Intent(OtherActivity.this,AboutUsActivity.class);
                startActivity(intent6);
                break;

            case R.id.txt_advistors:
                Intent intent5 = new Intent(OtherActivity.this,AdvistorsActivity.class);
                startActivity(intent5);
                break;
            case R.id.img_home:
                Intent intent7 = new Intent(OtherActivity.this,HomeActivity.class);
                startActivity(intent7);
                break;
        }
    }
}
