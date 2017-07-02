package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by bri on 7/2/17.
 */

public class ProgressDTO {
    @SerializedName("tanimId")
    @Expose
    private int tanimId;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("progress")
    @Expose
    private Date progress;

    @SerializedName("title")
    @Expose
    private String title;

}
