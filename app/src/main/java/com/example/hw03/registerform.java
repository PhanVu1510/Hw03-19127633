package com.example.hw03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class registerform extends AppCompatActivity {
    EditText edtUsername, edtPwd, edtRetype, edtBirthdate;
    RadioGroup rdgGender;
    RadioButton rdbMale, rdbFemale;
    CheckBox cbTennis, cbFutbal, cbOthers;
    Button btnReset, btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername=(EditText) findViewById(R.id.edtUsername);
        edtPwd=(EditText) findViewById(R.id.edtPwd);
        edtRetype=(EditText) findViewById(R.id.edtRetype);
        edtBirthdate=(EditText) findViewById(R.id.edtBirthdate);

        rdgGender=(RadioGroup)findViewById(R.id.rdgGender);
        rdbMale=(RadioButton) findViewById(R.id.rdbMale);
        rdbFemale=(RadioButton) findViewById(R.id.rdbFemale);

        cbTennis=(CheckBox) findViewById(R.id.cbTennis);
        cbFutbal=(CheckBox) findViewById(R.id.cbFutball);
        cbOthers=(CheckBox) findViewById(R.id.cbOthers);

        btnReset=(Button) findViewById(R.id.btnReset);
        btnSignUp=(Button) findViewById(R.id.btnSignup);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtUsername.setText("");
                edtPwd.setText("");
                edtRetype.setText("");
                edtBirthdate.setText("");

                rdbFemale.setChecked(false);
                rdbMale.setChecked(false);

                cbFutbal.setChecked(false);
                cbTennis.setChecked(false);
                cbOthers.setChecked(false);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName= edtUsername.getText().toString();
                String passWord= edtPwd.getText().toString();
                String reType= edtRetype.getText().toString();
                String birthDate= edtBirthdate.getText().toString();

                Boolean female= rdbFemale.isChecked();
                Boolean male= rdbMale.isChecked();

                String gender="Male";
                if (rdbFemale.isChecked())
                    gender="Female";

                String hobbies="";

                if (userName.equals("") || passWord.equals("") || reType.equals("")
                    || birthDate.equals("") || (!female && !male)) {
                    Toast toast = Toast.makeText(registerform.this, "\n" +
                            "Please fill out all fields", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }


                if (!passWord.equals(reType)) {
                    Toast toast = Toast.makeText(registerform.this, "\n" +
                            "Passwords do not match", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                if (cbTennis.isChecked())
                    hobbies +=cbTennis.getText().toString();

                if (cbFutbal.isChecked()) {
                    if (!hobbies.equals(""))
                        hobbies += ", ";
                    hobbies += cbFutbal.getText();
                }

                if (cbOthers.isChecked()) {
                    if (!hobbies.equals(""))
                        hobbies += ", ";
                    hobbies += cbOthers.getText();
                }

                if (hobbies.equals(""))
                    hobbies="None";

                Intent signUp= new Intent(registerform.this,resultform.class);
                Bundle datas=new Bundle();
                datas.putString("username",userName);
                datas.putString("password",passWord);
                datas.putString("birthdate",birthDate);
                datas.putString("gender",gender);
                datas.putString("hobbies",hobbies);
                signUp.putExtras(datas);
                startActivity(signUp);
                finish();
            }
        });
    }
}