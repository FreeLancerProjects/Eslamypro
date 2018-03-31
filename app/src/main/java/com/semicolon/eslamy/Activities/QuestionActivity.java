package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.semicolon.eslamy.Adapters.QusetionAdapter;
import com.semicolon.eslamy.Models.QuesModel;
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

public class QuestionActivity extends AppCompatActivity {
    private RecyclerView recView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private ProgressBar progBar;
    private String lang_id;
    private List<QuesModel> quesModelList;
    private ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);

        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("id"))
            {
                lang_id = intent.getStringExtra("id");
                Toast.makeText(this, "langId"+lang_id, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initView() {

        home=findViewById(R.id.img_home);
        quesModelList  = new ArrayList<>();
        progBar = findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);


        recView = findViewById(R.id.recView);
        manager = new LinearLayoutManager(this);
        recView.setLayoutManager(manager);
        recView.setHasFixedSize(true);
        adapter = new QusetionAdapter(quesModelList,this);
        recView.setAdapter(adapter);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuestionActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void DisplayQuestions()
    {
        Retrofit retrofit = Api.getClient();
        Service service = retrofit.create(Service.class);
        Call<List<QuesModel>> call = service.DisplayQuestion(lang_id);
        call.enqueue(new Callback<List<QuesModel>>() {
            @Override
            public void onResponse(Call<List<QuesModel>> call, Response<List<QuesModel>> response) {
                if (response.isSuccessful())
                {
                    quesModelList.clear();
                    progBar.setVisibility(View.GONE);
                    quesModelList.addAll(response.body());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<QuesModel>> call, Throwable t) {
                Log.e("error",t.getMessage());
                progBar.setVisibility(View.GONE);
                Toast.makeText(QuestionActivity.this, getString(R.string.connection), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setPos(int pos)
    {
        QuesModel quesModel = quesModelList.get(pos);
        Intent intent = new Intent(QuestionActivity.this,AnswerActivity.class);
        intent.putExtra("data",quesModel);
        startActivity(intent);
        //DisplayAnswer(quesModel.getId());

    }


    @Override
    protected void onStart() {
        super.onStart();
        DisplayQuestions();
    }
}
