package com.gradnr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gradnr.R;
import com.gradnr.adapter.MilestoneAdapater;
import com.gradnr.common.Util;
import com.gradnr.dao.MilestoneDao;
import com.gradnr.dto.MilestoneDTO;
import com.gradnr.dto.PlantDTO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MilestoneActivity extends AppCompatActivity {

    @BindView(R.id.milestone_milestoneLists)RecyclerView milestoneList;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        final MilestoneDao milestoneDao = Util.retro().create(MilestoneDao.class);
        //Call<List<PlantDTO>> call = milestoneDao.plantDtoList(bundle.getInt("tanim_id"));
        Call<List<PlantDTO>> call = milestoneDao.plantDtoList(1);
        call.enqueue(new Callback<List<PlantDTO>>() {
            @Override
            public void onResponse(Call<List<PlantDTO>> call, Response<List<PlantDTO>> response) {
                Log.d("Milestone", String.valueOf(response.body()));
                List<MilestoneDTO> milestoneDTOList = new ArrayList<MilestoneDTO>();
                for(int i = 0; i< response.body().size(); i++) {
                    if(response.body().get(i).getMilestoneDTO() != null) {
                        milestoneDTOList.add(response.body().get(i).getMilestoneDTO());
                    }
                }
                adapter = new MilestoneAdapater(milestoneDTOList,MilestoneActivity.this);
                milestoneList.setAdapter(adapter);
                milestoneList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<PlantDTO>> call, Throwable t) {
                Log.d("Milestone", t.getMessage());
            }
        });
    }
}
