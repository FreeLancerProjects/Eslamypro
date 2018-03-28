package com.semicolon.eslamy.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.semicolon.eslamy.Activities.DetailsActivity;
import com.semicolon.eslamy.Models.OthersModel;
import com.semicolon.eslamy.R;

import java.util.List;

/**
 * Created by Delta on 27/03/2018.
 */

public class DetailsAdapter  extends RecyclerView.Adapter <DetailsAdapter.myViewHolder>{
    List<OthersModel> othersModelList;
    Context context;
    DetailsActivity detailsActivity;

    public DetailsAdapter(List<OthersModel> othersModelList, Context context) {
        this.othersModelList = othersModelList;
        this.context = context;
        detailsActivity= (DetailsActivity) context;
    }

    @Override
    public DetailsAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_item_row,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DetailsAdapter.myViewHolder holder, int position) {
        OthersModel othersModel = othersModelList.get(position);
        holder.BindData(othersModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                detailsActivity.setPos(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return othersModelList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        private TextView address;
        myViewHolder(View itemView) {
            super(itemView);

            address = itemView.findViewById(R.id.address);

        }

        public void BindData(OthersModel othersModel)
        {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"JannaLT-Regular.ttf");
            address.setText(othersModel.getAddress());
            address.setTypeface(typeface);
        }
    }
}
