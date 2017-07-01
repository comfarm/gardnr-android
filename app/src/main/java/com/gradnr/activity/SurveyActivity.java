package com.gradnr.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gradnr.R;
import com.gradnr.adapter.SurveyAdapter;
import com.gradnr.fragment.PlantRecommendationFragment;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

public class SurveyActivity extends AppCompatActivity implements StepperLayout.StepperListener{

    private StepperLayout mStepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        getSupportActionBar().hide();
        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperLayout.setAdapter(new SurveyAdapter(getSupportFragmentManager(), this));
        mStepperLayout.setListener(this);
    }

    @Override
    public void onCompleted(View completeButton) {
//        Toast.makeText(this, "onCompleted!", Toast.LENGTH_SHORT).show();
        PlantRecommendationFragment plantRecommendationFragment = new PlantRecommendationFragment();
        plantRecommendationFragment.show(getFragmentManager(),"Plant Recommendation");
    }

    @Override
    public void onError(VerificationError verificationError) {
        Toast.makeText(this, "onError! -> " + verificationError.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStepSelected(int newStepPosition) {
     //    Toast.makeText(this, "onStepSelected! -> " + newStepPosition, Toast.LENGTH_SHORT).show();
//        switch(newStepPosition){
//            case 1:
//                RadioButton exp = (RadioButton)findViewById(survey_exp.getCheckedRadioButtonId());
//                Toast.makeText(getApplicationContext(), exp.getText(), Toast.LENGTH_SHORT).show();
//                break;
//            case 2:
//
//                break;
//        }

    }

    @Override
    public void onReturn() {
        finish();
    }
}
