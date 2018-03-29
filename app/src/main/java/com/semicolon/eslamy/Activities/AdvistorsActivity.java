package com.semicolon.eslamy.Activities;

import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.semicolon.eslamy.Adapters.AdvistorsAdapter;
import com.semicolon.eslamy.Models.AdvisorsModel;
import com.semicolon.eslamy.Models.LangModel;
import com.semicolon.eslamy.R;
import com.semicolon.eslamy.Services.Api;
import com.semicolon.eslamy.Services.Service;

import java.util.ArrayList;
import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AdvistorsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private List<AdvisorsModel> adviistorsModelList;
    private ProgressBar progBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advistors);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);

        initView();
        getDataFromServer();
    }

    private void getDataFromServer() {

        Service service = Api.getClient().create(Service.class);
        Call<List<AdvisorsModel>> call = service.Displayadvisors();
        call.enqueue(new Callback<List<AdvisorsModel>>() {
            @Override
            public void onResponse(Call<List<AdvisorsModel>> call, Response<List<AdvisorsModel>> response) {
                if (response.isSuccessful())
                {
                    progBar.setVisibility(View.GONE);
                    adviistorsModelList.clear();
                    adviistorsModelList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<AdvisorsModel>> call, Throwable t) {
                Log.e("error",t.getMessage());
                progBar.setVisibility(View.GONE);
                Toast.makeText(AdvistorsActivity.this, R.string.connection, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initView() {
        progBar = findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        adviistorsModelList = new ArrayList<>();
        recyclerView = findViewById(R.id.rec_advistors);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        adapter = new AdvistorsAdapter(adviistorsModelList,this);
        recyclerView.setAdapter(adapter);



    }
}
