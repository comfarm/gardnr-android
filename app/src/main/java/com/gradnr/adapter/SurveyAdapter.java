package com.gradnr.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.gradnr.R;
import com.gradnr.fragment.SurveyStepFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

/**
 * Created by bri on 7/1/17.
 */

public class SurveyAdapter extends AbstractFragmentStepAdapter {

    private static final String CURRENT_STEP_POSITION_KEY = "position";

    public SurveyAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return SurveyStepFragment.newInstance(R.layout.fragment_survey_step_exp);
            case 1:
                return SurveyStepFragment.newInstance(R.layout.fragment_survey_step_type);
            case 2:
                return SurveyStepFragment.newInstance(R.layout.fragment_survey_step_where);
            default:
                return SurveyStepFragment.newInstance(R.layout.fragment_survey_step_exp);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        return new StepViewModel.Builder(context)
                .setTitle("Survey") //can be a CharSequence instead
                .create();
    }
}
