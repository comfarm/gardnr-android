package com.gradnr.fragment;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.gradnr.R;
import com.gradnr.dto.UserDTO;
import com.gradnr.service.LoginService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by LIM on 01/07/2017.
 */

public class RegisterFragment extends DialogFragment{

    @BindView(R.id.register_toolbar)Toolbar toolbar;
    @BindView(R.id.register_firstName)TextInputLayout firstName;
    @BindView(R.id.register_lastName)TextInputLayout lastName;
    @BindView(R.id.register_emailAddress)TextInputLayout emailAddress;
    @BindView(R.id.register_password)TextInputLayout password;
    @BindView(R.id.register_confirmPassword)TextInputLayout confirmPassword;
    @BindView(R.id.register_register)FancyButton register;
    @BindView(R.id.register_withFb)FancyButton registerWithFb;

    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);

        progressDialog = new ProgressDialog(view.getContext());

        toolbar.setTitle("Register");
        toolbar.setTitleTextColor(Color.WHITE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForms();
            }
        });


        return view;
    }


    private void validateForms(){
        firstName.setError("");
        lastName.setError("");
        emailAddress.setError("");
        password.setError("");
        confirmPassword.setError("");

        if(firstName.getEditText().getText().toString().isEmpty()
                || firstName.getEditText().getText().toString().trim().matches(".*\\d.*")){
            firstName.setError("Invalid First Name");
        }else if(lastName.getEditText().getText().toString().isEmpty()
                || lastName.getEditText().getText().toString().trim().matches(".*\\d.*")){
            lastName.setError("Invalid Last Name");
        }else if(emailAddress.getEditText().getText().toString().isEmpty()
                || !Patterns.EMAIL_ADDRESS.matcher(emailAddress.getEditText().getText().toString().trim()).matches()){
            emailAddress.setError("Invalid Email Address");
        }else if(password.getEditText().getText().toString().isEmpty()){
            password.setError("Invalid Password");
        }else if(confirmPassword.getEditText().getText().toString().isEmpty()
                || !confirmPassword.getEditText().getText().toString().trim().equals(password.getEditText().getText().toString().trim())){
            confirmPassword.setError("Password Mismatch");
        }else{
            progressDialog.setMessage("Registering...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(firstName.getEditText().getText().toString());
            userDTO.setLastName(lastName.getEditText().getText().toString());
            userDTO.setEmail(emailAddress.getEditText().getText().toString());
            userDTO.setPassword(password.getEditText().getText().toString());

            LoginService loginService = new LoginService();


            if(loginService.register(userDTO) == 201){
                showDialog(true);
            }else{
                showDialog(false);
            }


        }
    }

    private void showDialog(boolean result) {
        progressDialog.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(result){
            builder.setMessage("Successfully Registered");
        }else{
            builder.setMessage("Registration Failed");
        }
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
