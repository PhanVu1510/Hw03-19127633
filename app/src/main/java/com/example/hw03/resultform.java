package com.example.hw03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

public class resultform extends AppCompatActivity {
    TextView tvUserName, tvPassWord, tvBirthDate, tvGender, tvHobbies;
    Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultform);

        tvUserName=(TextView) findViewById(R.id.tvUsername2);
        tvPassWord=(TextView) findViewById(R.id.tvPwd2);
        tvBirthDate=(TextView) findViewById(R.id.tvBirhdate2);
        tvGender=(TextView) findViewById(R.id.tvGender2);
        tvHobbies=(TextView) findViewById(R.id.tvHobbies2);

        btnExit=(Button) findViewById(R.id.btnExit2);

        Intent signUp=getIntent();
        Bundle datas=signUp.getExtras();

        tvUserName.setText(datas.getString("username"));
        tvPassWord.setText(datas.getString("password"));
        tvBirthDate.setText(datas.getString("birthdate"));
        tvGender.setText(datas.getString("gender"));
        tvHobbies.setText(datas.getString("hobbies"));

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}