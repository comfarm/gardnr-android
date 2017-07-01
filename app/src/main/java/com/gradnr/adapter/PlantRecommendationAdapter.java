package com.gradnr.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gradnr.R;
import com.gradnr.dto.PlantRecommendationDTO;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by LIM on 01/07/2017.
 */

public class PlantRecommendationAdapter extends RecyclerView.Adapter<PlantRecommendationAdapter.ViewHolder>{
    ArrayList<PlantRecommendationDTO> plantRecommendationDTOs;
    Context context;

    @BindView(R.id.plant_image)ImageView plant_image;
    @BindView(R.id.plant_name)TextView plant_name;
    @BindView(R.id.plant_description)TextView plant_description;
    @BindView(R.id.plant_select)FancyButton plant_select;

    public PlantRecommendationAdapter(ArrayList<PlantRecommendationDTO> plantRecommendationDTOs, Context context){
        this.plantRecommendationDTOs = plantRecommendationDTOs;
        this.context = context;
    }


    @Override
    public PlantRecommendationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_plant_recommendations, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlantRecommendationAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(plantRecommendationDTOs.get(position).getPlant_image()).into(plant_image);
        plant_name.setText(plantRecommendationDTOs.get(position).getPlant_name());
        plant_description.setText(plantRecommendationDTOs.get(position).getPlant_description());
        plant_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putInt("plant_id", plantRecommendationDTOs.get(position).getPlant_id());
//                Intent intent = new Intent(view.getContext(), )
            }
        });
    }

    @Override
    public int getItemCount() {
        return plantRecommendationDTOs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
