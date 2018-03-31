package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.semicolon.eslamy.Models.OthersModel;
import com.semicolon.eslamy.R;
import com.semicolon.eslamy.Services.Api;
import com.semicolon.eslamy.Services.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SimpleInvitationActivity extends AppCompatActivity {

    String type,id;
    private VideoView videoView;
    MediaController controller;
    private ImageView play;
    private ProgressBar progBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getDataFromIntent();

        initView();




    }

    private void initView() {
        progBar = findViewById(R.id.progBar);
        play = findViewById(R.id.play);
        videoView = findViewById(R.id.videoView);
        controller = new MediaController(this);
        videoView.setMediaController(controller);
        controller.setAnchorView(videoView);
        videoView.setVideoURI(Uri.parse("http://islam.tansiq.net/uploads/videoplayback.mp4"));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.start();
                play.setVisibility(View.GONE);
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                        if (MediaPlayer.MEDIA_INFO_BUFFERING_START==i)
                        {
                            progBar.setVisibility(View.VISIBLE);
                        } if (MediaPlayer.MEDIA_INFO_BUFFERING_START==i)
                        {
                            progBar.setVisibility(View.GONE);

                        }

                        return false;
                    }
                });
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                play.setVisibility(View.VISIBLE);
            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("type")&&intent.hasExtra("id"))
            {
                type = intent.getStringExtra("type");
                id   = intent.getStringExtra("id");

                Toast.makeText(this, "type :"+type+"\n"+"id"+id, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void DisplayDetails()
    {
        Retrofit retrofit = Api.getClient();
        Service service = retrofit.create(Service.class);
        Call<List<OthersModel>> call = service.DisplayDetails(id,type);

        call.enqueue(new Callback<List<OthersModel>>() {
            @Override
            public void onResponse(Call<List<OthersModel>> call, Response<List<OthersModel>> response) {
                if (response.isSuccessful())
                {
                    List<OthersModel> othersModelList = response.body();
                    if (othersModelList.size()>0)
                    {
                        Intent intent = new Intent(SimpleInvitationActivity.this,WebViewActivity.class);
                        intent.putExtra("url",othersModelList.get(0).getLink());
                        startActivity(intent);
                    }else
                        {
                            Toast.makeText(SimpleInvitationActivity.this, R.string.novideo, Toast.LENGTH_LONG).show();
                        }
                }
            }

            @Override
            public void onFailure(Call<List<OthersModel>> call, Throwable t) {
                Log.e("Error",t.getMessage());
                Toast.makeText(SimpleInvitationActivity.this, getString(R.string.connection), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        //DisplayDetails();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
}
