package com.example.jewelleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jewelleryapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activityLoginBinding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());
        DBHelper dbHelper = new DBHelper(LoginActivity.this);

        activityLoginBinding.loginBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = activityLoginBinding.loginPhoneId.getText().toString();
                String password = activityLoginBinding.loginPasswordId.getText().toString();

                String password_db = dbHelper.fetch_password(phone_number);

                if(password.equals(password_db)){
                    Toast.makeText(LoginActivity.this,"Logged In Successfully...",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,"Invalid Phone or Password",Toast.LENGTH_LONG).show();
                }
            }
        });

//        activityLoginBinding.loginSignupId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(LoginActivity.this,SignupActivity.class);
//                startActivity(i);
//            }
//        });
    }
}