package com.semicolon.eslamy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;


public class Splash extends Activity implements AnimationListener {

    ImageView imgPoster;
    Animation animSlideUp;
    TextView arabic;
    TextView english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);
        imgPoster =  findViewById(R.id.imgLogo);
        arabic=findViewById(R.id.txtarabic);
        english=findViewById(R.id.txtenglish);

        // load the animation
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);

        // set animation listener
        animSlideUp.setAnimationListener(this);
        imgPoster.setVisibility(View. VISIBLE);
        imgPoster.startAnimation(animSlideUp);
        arabic.setVisibility(View. VISIBLE);
        arabic.startAnimation(animSlideUp);
        english.setVisibility(View. VISIBLE);
        english.startAnimation(animSlideUp);
        animSlideUp.setDuration(3000);


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for zoom in animation

          Intent i =new Intent(this,HomeActivity.class);
            startActivity(i);


    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }



}
