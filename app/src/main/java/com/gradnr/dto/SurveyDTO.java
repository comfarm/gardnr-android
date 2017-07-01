package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bri on 7/1/17.
 */

public class SurveyDTO {

    @SerializedName("surveyExp")
    @Expose
    private String surveyExp;

    @SerializedName("surveyPlantTypes")
    @Expose
    private ArrayList<String> surveyPlantTypes = new ArrayList<>();

    @SerializedName("surveyPlantPlace")
    @Expose
    private ArrayList<String> surveyPlantPlace = new ArrayList<>();

    public String getSurveyExp() {
        return surveyExp;
    }

    public void setSurveyExp(String surveyExp) {
        this.surveyExp = surveyExp;
    }

    public ArrayList<String> getSurveyPlantTypes() {
        return surveyPlantTypes;
    }

    public void setSurveyPlantTypes(ArrayList<String> surveyPlantTypes) {
        this.surveyPlantTypes = surveyPlantTypes;
    }

    public ArrayList<String> getSurveyPlantPlace() {
        return surveyPlantPlace;
    }

    public void setSurveyPlantPlace(ArrayList<String> surveyPlantPlace) {
        this.surveyPlantPlace = surveyPlantPlace;
    }
}
