package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bri on 7/1/17.
 */

public class StepsDTO {
    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("stepNum")
    @Expose
    private int stepNum;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("wikiId")
    @Expose
    private int wikiId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStepNum() {
        return stepNum;
    }

    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWikiId() {
        return wikiId;
    }

    public void setWikiId(int wikiId) {
        this.wikiId = wikiId;
    }
}
