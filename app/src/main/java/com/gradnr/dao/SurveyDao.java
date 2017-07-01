package com.gradnr.dao;

import com.gradnr.dto.SurveyDTO;
import com.gradnr.dto.WikiDTO;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by bri on 7/1/17.
 */

public interface SurveyDao {
    @POST("survey/")
    Call<SurveyDTO> getItem(@Body SurveyDTO survey);
}
