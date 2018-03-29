package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.semicolon.eslamy.Models.AboutUsModel;
import com.semicolon.eslamy.R;
import com.semicolon.eslamy.Services.Api;
import com.semicolon.eslamy.Services.Service;
import java.util.List;
import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener{

    TextView title,address,phone;
    ImageView twitter,instgram;
    String instgram_url,twitter_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);

        getDataFromServer();
        initView();
    }

    private void getDataFromServer() {

        Service service = Api.getClient().create(Service.class);
        Call<List<AboutUsModel>> call = service.Displayaboutus();
        call.enqueue(new Callback<List<AboutUsModel>>() {
            @Override
            public void onResponse(Call<List<AboutUsModel>> call, Response<List<AboutUsModel>> response) {
                if (response.isSuccessful())
                {
                    title.setText(response.body().get(0).getTitle());
                    address.setText(response.body().get(0).getAddress());
                    phone.setText(response.body().get(0).getPhone());
                    twitter_url=response.body().get(0).getTw_id();
                    instgram_url=response.body().get(0).getInstagram_id();
                   
                }
            }

            @Override
            public void onFailure(Call<List<AboutUsModel>> call, Throwable t) {
                Log.e("error",t.getMessage());
                Toast.makeText(AboutUsActivity.this, R.string.connection, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initView() {
        title=findViewById(R.id.txt_title);
        address=findViewById(R.id.txt_address);
        phone=findViewById(R.id.txt_phone);
        twitter=findViewById(R.id.img_twitter);
        instgram=findViewById(R.id.img_instgram);

        twitter.setOnClickListener(this);
        instgram.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.img_twitter:
                Intent intent1=new Intent(this,WebViewActivity.class);
                intent1.putExtra("url",twitter_url);
                startActivity(intent1);

                break;

            case R.id.img_instgram:
                Intent intent2=new Intent(this,WebViewActivity.class);
                intent2.putExtra("url",instgram_url);
                startActivity(intent2);
                break;
        }

    }
}
