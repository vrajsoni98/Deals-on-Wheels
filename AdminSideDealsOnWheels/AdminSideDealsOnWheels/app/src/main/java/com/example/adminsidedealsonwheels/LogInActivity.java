package com.example.adminsidedealsonwheels;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity {

    Button login;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        login = findViewById(R.id.button);
        password = findViewById(R.id.editText2);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplicationContext(),"Password is: dow",Toast.LENGTH_LONG).show();
                if(password.getText().toString().equals("dow"))
                {
                    Intent intent3 = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent3);
                    finish();
                }
                else if(password.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Password",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Right Password",Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}
