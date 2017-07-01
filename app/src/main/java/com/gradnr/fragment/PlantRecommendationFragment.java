package com.gradnr.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gradnr.R;
import com.gradnr.activity.GardnActivity;
import com.gradnr.service.SurveyService;

import butterknife.BindView;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;

public class PlantRecommendationFragment extends DialogFragment implements View.OnClickListener {
    private View view;

    @BindView(R.id.plant_later)FancyButton plantLaterButton;
    @BindView(R.id.plant_recommendationList)RecyclerView plant_recommendationList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_plant_recommendation, container, false);
        ButterKnife.bind(this, view);
        plantLaterButton.setOnClickListener(this);

        SurveyService surveyService = new SurveyService();
        surveyService.plantRecommendations();

        return view;
    }

//    @Override
//    public void onDismiss(final DialogInterface dialog) {
//        super.onDismiss(dialog);
//        view.getContext().startActivity(new Intent(view.getContext(), GardnActivity.class));
//    }

    @Override
    public void onClick(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), GardnActivity.class));
    }
}
