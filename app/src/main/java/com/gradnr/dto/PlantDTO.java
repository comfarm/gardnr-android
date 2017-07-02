package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LIM on 02/07/2017.
 */

public class PlantDTO {

    @SerializedName("milestoneDto")
    @Expose
    private MilestoneDTO milestoneDTO;

    @SerializedName("progressDto")
    @Expose
    private ProgressDTO progressDTO;

    @SerializedName("date")
    @Expose
    private String date;

    public MilestoneDTO getMilestoneDTO() {
        return milestoneDTO;
    }

    public void setMilestoneDTO(MilestoneDTO milestoneDTO) {
        this.milestoneDTO = milestoneDTO;
    }

    public ProgressDTO getProgressDTO() {
        return progressDTO;
    }

    public void setProgressDTO(ProgressDTO progressDTO) {
        this.progressDTO = progressDTO;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
