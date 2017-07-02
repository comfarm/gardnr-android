package com.gradnr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gradnr.R;
import com.gradnr.adapter.MilestoneAdapater;
import com.gradnr.adapter.ProgressAdapter;
import com.gradnr.common.Util;
import com.gradnr.dao.MilestoneDao;
import com.gradnr.dto.MilestoneDTO;
import com.gradnr.dto.PlantDTO;
import com.gradnr.dto.ProgressDTO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgressActivity extends AppCompatActivity {

    @BindView(R.id.progress_progressLists)RecyclerView progressLists;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        final MilestoneDao milestoneDao = Util.retro().create(MilestoneDao.class);
        //Call<List<PlantDTO>> call = milestoneDao.plantDtoList(bundle.getInt("tanim_id"));
        Call<List<PlantDTO>> call = milestoneDao.plantDtoList(1);
        Log.d("Progress", call.request().url().toString());
        call.enqueue(new Callback<List<PlantDTO>>() {
            @Override
            public void onResponse(Call<List<PlantDTO>> call, Response<List<PlantDTO>> response) {
                Log.d("Progress", String.valueOf(response.body()));
                List<ProgressDTO> progressDTOList = new ArrayList<ProgressDTO>();
                for(int i = 0; i< response.body().size(); i++) {
                    if(response.body().get(i).getProgressDTO() != null) {
                        progressDTOList.add(response.body().get(i).getProgressDTO());
                    }
                }
                adapter = new ProgressAdapter(progressDTOList,ProgressActivity.this);
                progressLists.setAdapter(adapter);
                progressLists.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<PlantDTO>> call, Throwable t) {
                Log.d("Progress", t.getMessage());
            }
        });

    }
}
