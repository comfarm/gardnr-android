package com.gradnr.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.gradnr.common.Constants;
import com.gradnr.dao.UserDao;
import com.gradnr.dto.UserDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WikiService extends Service {
    public WikiService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Integer register(UserDTO userDTO){
        final int[] code = new int[1];
        UserDao userDao = retrofit.create(UserDao.class);
        Call<UserDTO> call = userDao.register(userDTO);
        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                code[0] = response.code();
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });
        return code[0];
    }

    public UserDTO[] login(String email){
        final UserDTO[] userDTO = {new UserDTO()};
        final UserDao userDao = retrofit.create(UserDao.class);
        Call<UserDTO> call = userDao.login(email);
        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                userDTO[0] = response.body();
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });
        return userDTO;
    }
}
