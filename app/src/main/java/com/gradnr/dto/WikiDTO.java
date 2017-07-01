package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bri on 7/1/17.
 */

public class WikiDTO {
    @SerializedName("checklist")
    @Expose
    private ArrayList<CheckListDTO> checklist;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("itemId")
    @Expose
    private int itemId;

    @SerializedName("steps")
    @Expose
    private ArrayList<StepsDTO> steps;

    @SerializedName("title")
    @Expose
    private String title;

    public ArrayList<CheckListDTO> getChecklist() {
        return checklist;
    }

    public void setChecklist(ArrayList<CheckListDTO> checklist) {
        this.checklist = checklist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public ArrayList<StepsDTO> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<StepsDTO> steps) {
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
