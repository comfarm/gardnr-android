package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bri on 7/1/17.
 */

public class CheckListDTO {
    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("checklistCategoryId")
    @Expose
    private int checklistCategoryId;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("wikiId")
    @Expose
    private int wikiId;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getChecklistCategoryId() {
        return checklistCategoryId;
    }

    public void setChecklistCategoryId(int checklistCategoryId) {
        this.checklistCategoryId = checklistCategoryId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWikiId() {
        return wikiId;
    }

    public void setWikiId(int wikiId) {
        this.wikiId = wikiId;
    }
}
