package com.gradnr.service;

import android.util.Log;
import android.widget.Toast;

import com.gradnr.dao.SurveyDao;
import com.gradnr.dto.PlantRecommendationDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LIM on 02/07/2017.
 */

public class SurveyService {

    public static final String BASE_URL = "http://172.16.0.72:8091";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public void plantRecommendations(){
        PlantRecommendationDTO plantRecommendationDTO = new PlantRecommendationDTO();
        plantRecommendationDTO.setPlant_id(0);
        SurveyDao surveyDao = retrofit.create(SurveyDao.class);
        Call<List<PlantRecommendationDTO>> call = surveyDao.plantRecommendations(plantRecommendationDTO);
        call.enqueue(new Callback<List<PlantRecommendationDTO>>() {
            @Override
            public void onResponse(Call<List<PlantRecommendationDTO>> call, Response<List<PlantRecommendationDTO>> response) {
                Log.i("Recommendation: ", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<List<PlantRecommendationDTO>> call, Throwable t) {
                Log.d("Fail", t.getMessage());
            }
        });
    }

}
