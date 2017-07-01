package com.gradnr.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
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

import java.util.Arrays;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bri on 7/1/17.
 */

public abstract class SingleStepFragment extends Fragment{


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);

//        surveyTypeItem1CB.setOnCheckedChangeListener(this);

        return view;
    }

    @LayoutRes
    protected abstract  int getLayoutResId();


//    Set<String> surveyType = new ArraySet<>();
//
//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        SharedPreferences.Editor edtr = surveyPref.edit();
//
//        int[] surveyTypes = {R.id.survey_type_item1, R.id.survey_type_item2, R.id.survey_type_item3, R.id.survey_type_item4, R.id.survey_type_item5};
//        int[] surveyWhere = {R.id.survey_where_item1, R.id.survey_where_item2, R.id.survey_where_item3, R.id.survey_where_item4};
//
//        if(Arrays.asList(surveyTypes).contains(compoundButton.getId())){
//            Log.i("A","Survey Types");
//        } else if(Arrays.asList(surveyWhere).contains(compoundButton.getId())){
//            Log.i("A","Survey Where");
//        }
//
//        switch (compoundButton.getId()) {
//
//            case R.id.survey_type_item1:
//                if(b){
//                    surveyType.add(compoundButton.getText().toString());
//                    edtr.putStringSet("plantType", surveyType);
//                } else {
//                    surveyType.add(compoundButton.getText().toString());
//                }
//        }
//    }
}
