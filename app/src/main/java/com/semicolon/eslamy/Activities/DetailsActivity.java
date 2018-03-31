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

import com.semicolon.eslamy.Adapters.DetailsAdapter;
import com.semicolon.eslamy.Models.OthersModel;
import com.semicolon.eslamy.R;
import com.semicolon.eslamy.Services.Api;
import com.semicolon.eslamy.Services.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsActivity extends AppCompatActivity {
    private RecyclerView recView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private ProgressBar progBar;
    private ImageView home;
    private String id,type;
    private List<OthersModel> othersModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
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

            }
        }
    }

    private void initView() {

        home=findViewById(R.id.img_home);
        progBar = findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);


        othersModelList = new ArrayList<>();
        recView = findViewById(R.id.recView);
        manager = new GridLayoutManager(this,2);
        recView.setLayoutManager(manager);
        recView.setHasFixedSize(true);
        adapter = new DetailsAdapter(othersModelList,this);
        recView.setAdapter(adapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailsActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setPos(int pos)
    {
        if (type.equals("4"))
        {
            Intent intent = new Intent(DetailsActivity.this,SimpleInvitationActivity.class);
            //intent.putExtra("url",othersModelList.get(pos).getLink());
            startActivity(intent);
        }else
            {
                Intent intent = new Intent(DetailsActivity.this,WebViewActivity.class);
                intent.putExtra("url",othersModelList.get(pos).getLink());
                startActivity(intent);
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

                    othersModelList.clear();
                    List<OthersModel> othersList = response.body();

                    if (othersList.size()>0)
                    {
                        othersModelList.addAll(othersList);
                        adapter.notifyDataSetChanged();
                        progBar.setVisibility(View.GONE);
                        /*Intent intent = new Intent(DetailsActivity.this,WebViewActivity.class);
                        intent.putExtra("url",othersModelList.get(0).getLink());
                        startActivity(intent);*/
                    }else
                    {
                        progBar.setVisibility(View.GONE);
                        //Toast.makeText(DetailsActivity.this, R.string.novideo, Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<OthersModel>> call, Throwable t) {
                progBar.setVisibility(View.GONE);
                Log.e("Error",t.getMessage());
                Toast.makeText(DetailsActivity.this, getString(R.string.connection), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        DisplayDetails();
    }
}
