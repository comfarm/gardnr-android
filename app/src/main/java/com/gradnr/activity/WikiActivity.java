package com.gradnr.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gradnr.R;
import com.gradnr.adapter.WikiStepsAdapter;
import com.gradnr.common.Util;
import com.gradnr.dao.WikiDao;
import com.gradnr.dto.StepsDTO;
import com.gradnr.dto.WikiDTO;
import com.gradnr.service.WikiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WikiActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);

//        WikiService wService = new WikiService();
//        WikiDTO w = wService.getWiki(1);
//        Log.d("test","test");

        WikiDao wikiDao = Util.retro().create(WikiDao.class);
        Call<WikiDTO> call = wikiDao.getWiki(1);
        Log.d("B",call.request().url().toString());
        final Context ctx = this;
        call.enqueue(new Callback<WikiDTO>() {
            @Override
            public void onResponse(Call<WikiDTO> call, Response<WikiDTO> response) {
                Log.d("Res",response.body().getTitle());
                ArrayList<StepsDTO> steps = response.body().getSteps();
                adapter = new WikiStepsAdapter(steps, ctx);
                mRecyclerView = (RecyclerView) findViewById(R.id.wikiRecyclerView);
                mRecyclerView.setAdapter(adapter);
                mLinearLayoutManager = new LinearLayoutManager(ctx);

                mRecyclerView.setLayoutManager(mLinearLayoutManager);
            }

            @Override
            public void onFailure(Call<WikiDTO> call, Throwable t) {
                Log.d("Err", t.getMessage());
            }
        });

//        Log.d("test2",w.getTitle());

    }
}
