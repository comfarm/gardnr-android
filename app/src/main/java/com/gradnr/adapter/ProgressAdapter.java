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
import com.gradnr.dto.ProgressDTO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LIM on 02/07/2017.
 */

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ViewHolder>{
    List<ProgressDTO> progressDTOList = new ArrayList<>();
    Context context;

    @BindView(R.id.progress_image)ImageView progress_image;
    //@BindView(R.id.progress_title)TextView progress_title;
    @BindView(R.id.progress_date)TextView progress_date;
    @BindView(R.id.progress_content)TextView progress_content;

    public ProgressAdapter(List<ProgressDTO> progressDTOList, Context context){
        this.progressDTOList = progressDTOList;
        this.context = context;
    }

    @Override
    public ProgressAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_progress, parent, false);
        ButterKnife.bind(this, view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgressAdapter.ViewHolder holder, int position) {

        if(progressDTOList.get(position) != null && progressDTOList.get(position).getImage() != null) {
            Glide.with(context).load(progressDTOList.get(position).getImage()).into(progress_image);
        }
        //progress_title.setText(progressDTOList.get(position).getTitle());
        progress_date.setText(progressDTOList.get(position).getProgressDate());
        progress_content.setText(progressDTOList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return progressDTOList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
