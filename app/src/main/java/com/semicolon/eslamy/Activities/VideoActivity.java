package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.semicolon.eslamy.Models.OthersModel;
import com.semicolon.eslamy.R;
import com.semicolon.eslamy.Services.Api;
import com.semicolon.eslamy.Services.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VideoActivity extends AppCompatActivity {

    String type,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getDataFromIntent();
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

    private void DisplayVideos()
    {
        Retrofit retrofit = Api.getClient();
        Service service = retrofit.create(Service.class);
        Call<List<OthersModel>> call = service.DisplayOthersData(id,type);

        call.enqueue(new Callback<List<OthersModel>>() {
            @Override
            public void onResponse(Call<List<OthersModel>> call, Response<List<OthersModel>> response) {
                if (response.isSuccessful())
                {
                    List<OthersModel> othersModelList = response.body();
                    if (othersModelList.size()>0)
                    {
                        Intent intent = new Intent();
                        intent.putExtra("url",othersModelList.get(0).getLink());
                        startActivity(intent);
                    }else
                        {
                            Toast.makeText(VideoActivity.this, R.string.novideo, Toast.LENGTH_LONG).show();
                        }
                }
            }

            @Override
            public void onFailure(Call<List<OthersModel>> call, Throwable t) {
                Log.e("Error",t.getMessage());
                Toast.makeText(VideoActivity.this, getString(R.string.connection), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        DisplayVideos();
    }
}
