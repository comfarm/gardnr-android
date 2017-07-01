package com.gradnr.activity;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.gradnr.R;
import com.gradnr.fragment.RegisterFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import mehdi.sakout.fancybuttons.FancyButton;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.login_emailAddress)TextInputLayout emailAddress;
    @BindView(R.id.login_password)TextInputLayout password;
    @BindView(R.id.login_noFb)FancyButton loginNoFb;
    @BindView(R.id.login_withFb)FancyButton loginWithFb;
    @BindView(R.id.login_register)FancyButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        ButterKnife.bind(this);

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
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.login_noFb:
                    validateForms();
                break;
            case R.id.login_withFb:
                    //connect to fb
                break;
            case R.id.login_register:
                RegisterFragment registerFragment = new RegisterFragment();
                registerFragment.show(getFragmentManager(),"Register");
                break;
        }
    }
}
