package com.gradnr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gradnr.R;
import com.gradnr.dto.MilestoneDTO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LIM on 02/07/2017.
 */

public class MilestoneAdapater extends RecyclerView.Adapter<MilestoneAdapater.ViewHolder> {
    List<MilestoneDTO> milestoneDTOList = new ArrayList<>();
    Context context;

    @BindView(R.id.milestone_image)ImageView milestone_image;
    @BindView(R.id.milestone_title)TextView milestone_title;
    @BindView(R.id.milestone_progessDate)TextView milestone_progressDate;
    @BindView(R.id.milestone_content)TextView milestone_content;

    public MilestoneAdapater(List<MilestoneDTO> milestoneDTOList, Context context){
        this.milestoneDTOList = milestoneDTOList;
        this.context = context;
    }

    @Override
    public MilestoneAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_milestone, parent, false);
        ButterKnife.bind(this, view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MilestoneAdapater.ViewHolder holder, int position) {
        if(milestoneDTOList.get(position) != null && milestoneDTOList.get(position).getImage() != null) {
            Glide.with(context).load(milestoneDTOList.get(position).getImage()).into(milestone_image);
        }
        milestone_title.setText(milestoneDTOList.get(position).getTitle());
        milestone_content.setText(milestoneDTOList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return milestoneDTOList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
