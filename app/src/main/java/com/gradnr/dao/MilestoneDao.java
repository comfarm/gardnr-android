package com.gradnr.dao;

import com.gradnr.dto.MilestoneDTO;
import com.gradnr.dto.PlantDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by LIM on 02/07/2017.
 */

public interface MilestoneDao {

    @POST("/api/plant/{tanim_id}")
    Call<List<PlantDTO>> plantDtoList(@Path("tanim_id") Integer tanim_id);

}
