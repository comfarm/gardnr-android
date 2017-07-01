package com.gradnr.dao;


import com.gradnr.dto.PlantRecommendationDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

/**
 * Created by bri on 7/1/17.
 */

public interface SurveyDao {
//    private String surveyExp;
//    private ArrayList<String> surveyPlantTypes = new ArrayList<>();
//    private ArrayList<String> surveyPlantPlace = new ArrayList<>();
//
//    public String getSurveyExp() {
//        return surveyExp;
//    }
//
//    public void setSurveyExp(String surveyExp) {
//        this.surveyExp = surveyExp;
//    }
//
//    public ArrayList<String> getSurveyPlantTypes() {
//        return surveyPlantTypes;
//    }
//
//    public void setSurveyPlantTypes(ArrayList<String> surveyPlantTypes) {
//        this.surveyPlantTypes = surveyPlantTypes;
//    }
//
//    public ArrayList<String> getSurveyPlantPlace() {
//        return surveyPlantPlace;
//    }
//
//    public void setSurveyPlantPlace(ArrayList<String> surveyPlantPlace) {
//        this.surveyPlantPlace = surveyPlantPlace;
//    }

    @POST("/api/survey")
    Call<List<PlantRecommendationDTO>> plantRecommendations(@Body PlantRecommendationDTO plantRecommendationDTO);

}
