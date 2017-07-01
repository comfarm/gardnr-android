package com.gradnr.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.gradnr.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.Arrays;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by bri on 7/1/17.
 */

public class SurveyStepFragment extends SingleStepFragment implements Step {

    private static final String LAYOUT_RESOURCE_ID_ARG_KEY = "messageResourceId";

//    @BindView(R.id.survey_exp_items)
//    RadioGroup surveyExpitemsRG;
//    @BindView(R.id.survey_type_item1)
//    CheckBox surveyTypeItem1CB;
//    @BindView(R.id.survey_type_item2)
//    CheckBox surveyTypeItem2CB;
//    @BindView(R.id.survey_type_item3)
//    CheckBox surveyTypeItem3CB;
//    @BindView(R.id.survey_type_item4)
//    CheckBox surveyTypeItem4CB;
//    @BindView(R.id.survey_type_item5)
//    CheckBox surveyTypeItem5CB;
//    @BindView(R.id.survey_where_item1)
//    CheckBox surveyWhereItem1CB;
//    @BindView(R.id.survey_where_item2)
//    CheckBox surveyWhereItem2CB;
//    @BindView(R.id.survey_where_item3)
//    CheckBox surveyWhereItem3CB;
//    @BindView(R.id.survey_where_item4)
//    CheckBox surveyWhereItem4CB;
//
//    SharedPreferences surveyPref;

    public static SurveyStepFragment newInstance(@LayoutRes int layoutResId) {
        Bundle args = new Bundle();
        args.putInt(LAYOUT_RESOURCE_ID_ARG_KEY, layoutResId);
        SurveyStepFragment fragment = new SurveyStepFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public  void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        surveyPref = view.getContext().getSharedPreferences("survey", Context.MODE_PRIVATE);

        Log.i("","Test");
//        surveyExpitemsRG.getCheckedRadioButtonId();
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    protected int getLayoutResId() {
        return getArguments().getInt(LAYOUT_RESOURCE_ID_ARG_KEY);
    }

}
