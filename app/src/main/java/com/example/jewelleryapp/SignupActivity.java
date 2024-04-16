package com.example.jewelleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jewelleryapp.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding activitySignupBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        activitySignupBinding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(activitySignupBinding.getRoot());
        DBHelper dbHelper = new DBHelper(SignupActivity.this);

        activitySignupBinding.signupBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = activitySignupBinding.signupPhoneId.getText().toString();
                String password = activitySignupBinding.signupPasswordId.getText().toString();
                String name  = activitySignupBinding.signupNameId.getText().toString();

                String password_db =dbHelper.fetch_password(phone_number);

                if(password_db.equals("")){
                    dbHelper.addData(phone_number,name,password);
                    Toast.makeText(SignupActivity.this,"SignUp Successfully...",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignupActivity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(SignupActivity.this,"User Already Registered!!!",Toast.LENGTH_LONG).show();
                }
            }
        });
//        activitySignupBinding.signupLoginId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SignupActivity.this,LoginActivity.class);
//                startActivity(i);
//            }
//        });
    }
}