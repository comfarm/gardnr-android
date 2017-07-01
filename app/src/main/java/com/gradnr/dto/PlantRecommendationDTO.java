package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LIM on 01/07/2017.
 */

public class PlantRecommendationDTO {

    @SerializedName("id")
    @Expose
    private Integer plant_id;

    @SerializedName("icon")
    @Expose
    private String plant_image;

    @SerializedName("name")
    @Expose
    private String plant_name;

    @SerializedName("description")
    @Expose
    private String plant_description;

    public Integer getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }

    public String getPlant_image() {
        return plant_image;
    }

    public void setPlant_image(String plant_image) {
        this.plant_image = plant_image;
    }

    public String getPlant_name() {
        return plant_name;
    }

    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getPlant_description() {
        return plant_description;
    }

    public void setPlant_description(String plant_description) {
        this.plant_description = plant_description;
    }
}
