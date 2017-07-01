package com.gradnr.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gradnr.R;
import com.gradnr.activity.WikiActivity;
import com.gradnr.dto.StepsDTO;
import com.gradnr.dto.WikiDTO;
import com.gradnr.fragment.WikiStepsFragment;
import com.gradnr.util.StepsHolder;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

import java.util.ArrayList;

/**
 * Created by bri on 7/2/17.
 */

public class WikiStepsAdapter extends RecyclerView.Adapter<WikiStepsAdapter.ViewHolder> {

    private ArrayList<StepsDTO> wikiSteps = new ArrayList<>();
    Context context;

    public WikiStepsAdapter(ArrayList<StepsDTO> steps, Context context){
        Log.d("D",String.valueOf(steps.size()));
        wikiSteps = steps;

        this.context = context;
    }

    @Override
    public WikiStepsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_wiki_steps, parent, false);

        return new ViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(WikiStepsAdapter.ViewHolder holder, int position) {
        holder.bindView(wikiSteps.get(position));
    }

    @Override
    public int getItemCount() {
        return wikiSteps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView wStepTitle;
        private TextView wStepContent;
        private ArrayList<StepsDTO> wikiSteps = new ArrayList<>();

        public ViewHolder(View itemView) {
            super(itemView);
            wStepTitle = (TextView) itemView.findViewById(R.id.wiki_step_title);
            wStepContent = (TextView) itemView.findViewById(R.id.wiki_step_content);
            itemView.setOnClickListener(this);
        }

        public void bindView(StepsDTO step){
            wStepTitle.setText(step.getTitle());
            wStepContent.setText(step.getContent());
            Log.d("View",step.getTitle() + " - " + step.getContent());


        }

        @Override
        public void onClick(View view) {
            Log.d("RecyclerView", "CLICK!");

            Context context = itemView.getContext();
            Intent showStepIntent = new Intent(context, WikiStepsFragment.class);
            context.startActivity(showStepIntent);
        }
    }
}
