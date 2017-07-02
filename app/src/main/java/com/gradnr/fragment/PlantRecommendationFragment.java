package com.gradnr.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.gradnr.R;
import com.gradnr.activity.GardnActivity;
import com.gradnr.adapter.PlantRecommendationAdapter;
import com.gradnr.common.Util;
import com.gradnr.dao.SurveyDao;
import com.gradnr.dto.PlantRecommendationDTO;
import com.gradnr.service.SurveyService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlantRecommendationFragment extends DialogFragment implements View.OnClickListener {
    private View view;

    @BindView(R.id.plant_recommendation)Toolbar toolbar;
    @BindView(R.id.plant_later)FancyButton plantLaterButton;
    @BindView(R.id.plant_recommendationList)RecyclerView plant_recommendationList;
    RecyclerView.Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_plant_recommendation, container, false);
        ButterKnife.bind(this, view);
        plantLaterButton.setOnClickListener(this);
        toolbar.setTitle("Recommendations");
        toolbar.setTitleTextColor(Color.WHITE);
        Dialog dialog = getDialog();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        SurveyDao surveyDao = Util.retro().create(SurveyDao.class);

        Call<List<PlantRecommendationDTO>> call = surveyDao.plantRecommendations(new PlantRecommendationDTO());
        Log.i("TETst", call.request().url().toString());
        call.enqueue(new Callback<List<PlantRecommendationDTO>>() {
            @Override
            public void onResponse(Call<List<PlantRecommendationDTO>> call, Response<List<PlantRecommendationDTO>> response) {
                Log.d("debug", String.valueOf(response.body()));
                adapter = new PlantRecommendationAdapter(response.body(),getActivity());
                plant_recommendationList.setAdapter(adapter);
                plant_recommendationList.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<List<PlantRecommendationDTO>> call, Throwable t) {
                Log.d("debug", t.getMessage());
            }
        });

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
