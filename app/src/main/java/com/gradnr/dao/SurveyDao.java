package com.gradnr.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bri on 7/1/17.
 */

public class SurveyDao {
    private String surveyExp;
    private ArrayList<String> surveyPlantTypes = new ArrayList<>();
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
