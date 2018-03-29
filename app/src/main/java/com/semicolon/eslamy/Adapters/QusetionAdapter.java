package com.semicolon.eslamy.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.semicolon.eslamy.Activities.QuestionActivity;
import com.semicolon.eslamy.Models.QuesModel;
import com.semicolon.eslamy.R;

import java.util.List;

/**
 * Created by Delta on 27/03/2018.
 */

public class QusetionAdapter extends RecyclerView.Adapter <QusetionAdapter.myViewHolder>{
    List<QuesModel> quesModelList;
    Context context;
    QuestionActivity questionActivity;

    public QusetionAdapter(List<QuesModel> quesModelList, Context context) {
        this.quesModelList = quesModelList;
        this.context = context;
        questionActivity= (QuestionActivity) context;
    }

    @Override
    public QusetionAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final QusetionAdapter.myViewHolder holder, int position) {
        QuesModel quesModel = quesModelList.get(position);
        holder.BindData(quesModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                questionActivity.setPos(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quesModelList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        private TextView question;
        myViewHolder(View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.question);

        }

        public void BindData(QuesModel quesModel)
        {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"JannaLT-Regular.ttf");
            question.setText(quesModel.getQuestion());
            question.setTypeface(typeface);
        }
    }
}
