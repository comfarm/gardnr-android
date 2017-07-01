package com.gradnr.dao;


import com.gradnr.dto.PlantRecommendationDTO;
import com.gradnr.dto.SurveyDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by bri on 7/1/17.
 */

public interface SurveyDao {
    @POST("/api/survey")
    Call<List<PlantRecommendationDTO>> plantRecommendations(@Body PlantRecommendationDTO plantRecommendationDTO);
    @POST("survey/")
    Call<SurveyDTO> getItem(@Body SurveyDTO survey);
}
