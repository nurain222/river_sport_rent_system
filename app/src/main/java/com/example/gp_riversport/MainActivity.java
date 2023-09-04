package com.example.gp_riversport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button openRegister;
    Button openLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openRegister = (Button) findViewById(R.id.registerBtn);
        openLogin = (Button) findViewById(R.id.loginBtn);

    }

    //Redirect to register page
    public void registerButton(View view)
    {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    //Redirect to login page
    public void loginButton(View view)
    {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

}