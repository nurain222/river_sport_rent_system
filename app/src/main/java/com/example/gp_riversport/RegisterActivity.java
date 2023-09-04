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

public class RegisterActivity extends AppCompatActivity {

    Button signUp;
    EditText e, pw;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e = (EditText)findViewById(R.id.inputEmail);
        pw = (EditText)findViewById(R.id.inputPassword);
        mAuth = FirebaseAuth.getInstance();

        signUp = (Button) findViewById(R.id.signUpBtn);
    }

    public void signUpButton(View v){
        if(e.getText().toString().equals("") && pw.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Blank not allowed", Toast.LENGTH_SHORT).show();
        }else{
            String email = e.getText().toString();
            String password = pw.getText().toString();
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"User created successfully",Toast.LENGTH_SHORT).show();
                                finish();
                                Intent i = new Intent(getApplicationContext(),LoginActivity.class); //Redirect to login page
                                startActivity(i);
                            }else{
                                Toast.makeText(getApplicationContext(),"User could not be found",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }
    }

}