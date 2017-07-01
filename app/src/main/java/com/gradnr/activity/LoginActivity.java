package com.gradnr.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

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
import com.gradnr.fragment.RegisterFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.gradnr.service.LoginService;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.login_emailAddress)TextInputLayout emailAddress;
    @BindView(R.id.login_password)TextInputLayout password;
    @BindView(R.id.login_noFb)FancyButton loginNoFb;
    @BindView(R.id.login_withFb)FancyButton loginWithFb;
    @BindView(R.id.login_register)FancyButton register;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        ButterKnife.bind(this);


        progressDialog = new ProgressDialog(this);

        loginNoFb.setOnClickListener(this);
        loginWithFb.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    private void validateForms(){
        emailAddress.setError("");
        password.setError("");

        if(emailAddress.getEditText().getText().toString().isEmpty()
                || !Patterns.EMAIL_ADDRESS.matcher(emailAddress.getEditText().getText().toString().trim()).matches()){
            emailAddress.setError("Invalid Email Address");
        }else if(password.getEditText().getText().toString().isEmpty()){
            password.setError("Invalid Password");
        }else{
            UserDTO userDTO = new UserDTO();
            LoginService loginService = new LoginService();
            userDTO = loginService.login(emailAddress.getEditText().getText().toString().trim())[0];

            if(!userDTO.getPassword().equals(password.getEditText().getText().toString())){
                showDialog(false);
            }else {
                showDialog(true);
            }

        }
    }

    private void showDialog(boolean result) {
        progressDialog.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(result){
            builder.setMessage("Logged in Successfully");
        }else{
            builder.setMessage("Invalid Email Address/Password");
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

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.login_noFb:
                    validateForms();
                break;
            case R.id.login_withFb:
                    //loginWithFb();
                break;
            case R.id.login_register:
                RegisterFragment registerFragment = new RegisterFragment();
                registerFragment.show(getFragmentManager(),"Register");
                break;
        }
    }
}
