package com.gradnr.dao;

import com.gradnr.dto.UserDTO;
import com.gradnr.dto.WikiDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by bri on 7/1/17.
 */

public interface WikiDao {

    @POST("wiki/item/{itemId}")
    Call<WikiDTO> getItem(@Path("itemId") int itemId);

    @POST("wiki/{wikiId}")
    Call<UserDTO> getWiki(@Path("wikiId") int wikiId);

}