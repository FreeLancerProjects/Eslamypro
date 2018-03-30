package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.semicolon.eslamy.Adapters.LangAdapter;
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

public class LanguageActivity extends AppCompatActivity {

    private RecyclerView lang_recView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private List<LangModel> langModelList;
    private ProgressBar progBar;
    private String type;
    private ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);

        initView();
        getDataFromIntent();
    }


    private void initView() {

        home=findViewById(R.id.img_home);
        progBar = findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        langModelList = new ArrayList<>();
        lang_recView = findViewById(R.id.lang_recView);
        manager = new GridLayoutManager(this,3);
        lang_recView.setLayoutManager(manager);
        lang_recView.setHasFixedSize(true);
        adapter = new LangAdapter(langModelList,this);
        lang_recView.setAdapter(adapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LanguageActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }
    private void getDataFromIntent() {

        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("type"))
            {
                type = intent.getStringExtra("type");
                //Toast.makeText(this, ""+type, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void displayLanguages() {
        Retrofit retrofit = Api.getClient();
        Service service = retrofit.create(Service.class);
        Call<List<LangModel>> call = service.DisplayLanguage();
        call.enqueue(new Callback<List<LangModel>>() {
            @Override
            public void onResponse(Call<List<LangModel>> call, Response<List<LangModel>> response) {
                if (response.isSuccessful())
                {
                    progBar.setVisibility(View.GONE);
                    langModelList.clear();
                    langModelList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<LangModel>> call, Throwable t) {
                Log.e("error",t.getMessage());
                progBar.setVisibility(View.GONE);
                Toast.makeText(LanguageActivity.this, R.string.connection, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setPos(int pos)
    {
        if (type.equals("question"))
        {
            String lang_id = langModelList.get(pos).getId();
            Intent intent = new Intent(LanguageActivity.this,QuestionActivity.class);
            intent.putExtra("id",lang_id);

            //Toast.makeText(this, "id"+lang_id+"\n"+type, Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }else
            {
                String lang_id = langModelList.get(pos).getId();
                Intent intent = new Intent(LanguageActivity.this,DetailsActivity.class);
                intent.putExtra("type",type);
                intent.putExtra("id",lang_id);

               // Toast.makeText(this, "id"+lang_id+"\n"+type, Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayLanguages();
    }



}
