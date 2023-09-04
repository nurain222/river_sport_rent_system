package com.example.gp_riversport;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    Button openBooking;
    EditText e, pw;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openBooking = (Button) findViewById(R.id.loginBtn);
        e = (EditText)findViewById(R.id.inputEmail);
        pw = (EditText)findViewById(R.id.inputPassword);
        mAuth = FirebaseAuth.getInstance();
    }

    public void loginButton(View v){
        if(e.getText().toString().equals("") && pw.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Blank not allowed", Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(e.getText().toString(),pw.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"User logged in successfully",Toast.LENGTH_SHORT).show();
                                finish();
                                Intent i = new Intent(getApplicationContext(),BookingActivity.class); //Redirect to booking page
                                startActivity(i);
                            }else{
                                Toast.makeText(getApplicationContext(),"User could not be login",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }

}