package com.gradnr.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bri on 7/1/17.
 */

public class ItemDTO {
    @SerializedName("wiki")
    @Expose
    private ArrayList<WikiDTO> wiki;
}
