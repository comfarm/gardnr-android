package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LIM on 02/07/2017.
 */

public class ProgressDTO {

    @SerializedName("tanimId")
    @Expose
    private Integer tanim_id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("progressDate")
    @Expose
    private String progressDate;

    public Integer getTanim_id() {
        return tanim_id;
    }

    public void setTanim_id(Integer tanim_id) {
        this.tanim_id = tanim_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProgressDate() {
        return progressDate;
    }

    public void setProgressDate(String progressDate) {
        this.progressDate = progressDate;
    }
}
