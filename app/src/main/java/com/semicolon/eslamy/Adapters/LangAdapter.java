package com.semicolon.eslamy.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.semicolon.eslamy.Activities.LanguageActivity;
import com.semicolon.eslamy.Models.LangModel;
import com.semicolon.eslamy.R;
import com.semicolon.eslamy.Services.Tags;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Delta on 25/03/2018.
 */

public class LangAdapter extends RecyclerView.Adapter <LangAdapter.myViewHolder>{
    List<LangModel> langModelList;
    Context context;
    LanguageActivity languageActivity;

    public LangAdapter(List<LangModel> langModelList, Context context) {
        this.langModelList = langModelList;
        this.context = context;
        languageActivity = (LanguageActivity) context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_simple_invitation,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {
        LangModel langModel = langModelList.get(position);
        holder.BindData(langModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                languageActivity.setPos(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return langModelList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private ImageView flag;
        private TextView lang;
         myViewHolder(View itemView) {
            super(itemView);

            flag = itemView.findViewById(R.id.flag);
            lang = itemView.findViewById(R.id.lang);

        }

        public void BindData(LangModel langModel)
        {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"JannaLT-Regular.ttf");
            lang.setText(langModel.getName());
            lang.setTypeface(typeface);
            Picasso.with(context).load(Uri.parse(Tags.imgPath+langModel.getFlag())).noFade().into(flag);
        }
    }
}
