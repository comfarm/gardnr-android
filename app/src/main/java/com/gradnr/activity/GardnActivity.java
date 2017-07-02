package com.gradnr.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.gradnr.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class GardnActivity extends AppCompatActivity {

    @BindView(R.id.profile_image)CircleImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardn);
        ButterKnife.bind(this);
        Glide.with(this).load("https://s3-ap-southeast-1.amazonaws.com/gardnr/milestone/day72.jpg").into(image);
    }

    public void goToMileStone(View view){
        startActivity(new Intent(this, MilestoneActivity.class));
    }
}
