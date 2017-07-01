package com.gradnr.dao;

import com.gradnr.dto.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by LIM on 01/07/2017.
 */

public interface UserDao {

    @POST("user/saveUser")
    Call<UserDTO> register(@Body UserDTO userDTO);

    @POST("user/getUser/{user}")
    Call<UserDTO> login(@Path("user") String user);

}
