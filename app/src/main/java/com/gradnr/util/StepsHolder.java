package com.gradnr.util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gradnr.R;
import com.gradnr.activity.WikiActivity;
import com.gradnr.dto.StepsDTO;

import java.io.Serializable;

/**
 * Created by bri on 7/2/17.
 */

public class StepsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView wStepTitle;
    private TextView wStepContent;
    private StepsDTO wStep;

    private static final String STEP_KEY = "STEP";


    public StepsHolder(View itemView) {
        super(itemView);

        wStepTitle = (TextView) itemView.findViewById(R.id.wiki_step_title);
        wStepContent = (TextView) itemView.findViewById(R.id.wiki_step_content);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("RecyclerView", "CLICK!");

        Context context = itemView.getContext();
        Intent showStepIntent = new Intent(context, WikiActivity.class);
        showStepIntent.putExtra(STEP_KEY, wStep);
        context.startActivity(showStepIntent);
    }
}
