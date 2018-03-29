package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.semicolon.eslamy.Models.QuesModel;
import com.semicolon.eslamy.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class AnswerActivity extends AppCompatActivity {
    private TextView question,answer;
    private QuesModel quesModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"JannaLT-Regular.ttf",true);

        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("data"))
            {
                quesModel = (QuesModel) intent.getSerializableExtra("data");
                updateUi(quesModel);
            }
        }
    }

    private void updateUi(QuesModel quesModel) {
        question.setText(quesModel.getQuestion());
        answer.setText(quesModel.getAnswer());
    }

    private void initView() {
        question = findViewById(R.id.question);
        answer   = findViewById(R.id.answer);
    }
}
