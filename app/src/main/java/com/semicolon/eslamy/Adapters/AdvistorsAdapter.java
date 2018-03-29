package com.semicolon.eslamy.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.semicolon.eslamy.Models.AdvisorsModel;
import com.semicolon.eslamy.R;
import java.util.List;

/**
 * Created by Elashry on 29/03/2018.
 */

public class AdvistorsAdapter extends RecyclerView.Adapter <AdvistorsAdapter.myViewHolder>{
    List<AdvisorsModel> AdvisorsModelList;
    Context context;

    public AdvistorsAdapter(List<AdvisorsModel> AdvisorsModelList, Context context) {
        this.AdvisorsModelList = AdvisorsModelList;
        this.context = context;

    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.advistors_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {
        AdvisorsModel AdvisorsModel = AdvisorsModelList.get(position);
        holder.BindData(AdvisorsModel);


    }

    @Override
    public int getItemCount() {
        return AdvisorsModelList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        private TextView name,phone,address;
         myViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_advistor_name);
            phone = itemView.findViewById(R.id.txt_advistor_phone);
            address = itemView.findViewById(R.id.txt_advistor_address);


         }

        public void BindData(AdvisorsModel AdvisorsModel)
        {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"JannaLT-Regular.ttf");
            name.setText(AdvisorsModel.getName());
            name.setTypeface(typeface);
            phone.setText(AdvisorsModel.getPhone());
            phone.setTypeface(typeface);
            address.setText(AdvisorsModel.getAddress());
            address.setTypeface(typeface);
        }
    }
}
