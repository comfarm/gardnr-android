package com.gradnr.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.gradnr.common.Constants;
import com.gradnr.dao.UserDao;
import com.gradnr.dao.WikiDao;
import com.gradnr.dto.ItemDTO;
import com.gradnr.dto.UserDTO;
import com.gradnr.dto.WikiDTO;

import java.util.ArrayList;

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

    public WikiDTO getWiki(int id){
        final WikiDTO[] wikiDTO = {new WikiDTO()};
        WikiDao wikiDao = retrofit.create(WikiDao.class);
        Call<WikiDTO> call = wikiDao.getWiki(id);

        call.enqueue(new Callback<WikiDTO>() {
            @Override
            public void onResponse(Call<WikiDTO> call, Response<WikiDTO> response) {
                wikiDTO[0] = response.body();
            }

            @Override
            public void onFailure(Call<WikiDTO> call, Throwable t) {

            }
        });
        return wikiDTO[0];
    }

    public ItemDTO getItem(int id){
        final ItemDTO[] itemDTO = {new ItemDTO()};
        WikiDao wikiDao = retrofit.create(WikiDao.class);
        Call<ItemDTO> call = wikiDao.getItem(id);
        call.enqueue(new Callback<ItemDTO>() {
            @Override
            public void onResponse(Call<ItemDTO> call, Response<ItemDTO> response) {
                itemDTO[0] = response.body();
            }

            @Override
            public void onFailure(Call<ItemDTO> call, Throwable t) {

            }
        });
        return itemDTO[0];
    }
}
