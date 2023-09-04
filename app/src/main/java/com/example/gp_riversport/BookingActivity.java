package com.example.gp_riversport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    Button openConfirmBook;
    ImageButton backButton, lockButton;
    CheckBox ch, ch1, ch2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        ch=(CheckBox)findViewById(R.id.checkBoxA);
        ch1=(CheckBox)findViewById(R.id.checkBoxB);
        ch2=(CheckBox)findViewById(R.id.checkBoxC);
        openConfirmBook = (Button) findViewById(R.id.nextBtn);
        backButton = (ImageButton) findViewById(R.id.backBtn);
        lockButton = (ImageButton) findViewById(R.id.logoutIcn);
    }

    //Redirect to confirm booking page
    public void nextButton(View view)
    {
        String msg="";
        Integer prc=0;

        // Concatenation of the checked options in if

        // isChecked() is used to check whether
        // the CheckBox is in true state or not.

        if(ch.isChecked()) {
            msg = msg + "Package A " +
                    "\n1x Kayak Boat + 2x paddles + 2 safety jackets\n\n";
            prc = prc + 5;
        }
        if(ch1.isChecked()) {
            msg = msg + " Package B " +
                    "\n1x Raft Boat + 4x paddles + 4 safety jackets\n\n";
            prc = prc + 10;
        }
        if(ch2.isChecked()) {
            msg = msg + " Package C " +
                    "\n1x Canoe Boat + 2X paddles + 2 safety jackets";
            prc = prc + 15;
        }
        Toast.makeText(this, msg + "\n\n are selected",
                Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, ConfirmBookingActivity.class);
        i.putExtra("msg",msg);
        i.putExtra("prc",prc);
        startActivity(i);
    }

    //Redirect to back previous page
    public void bckButton(View view)
    {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    //Redirect to main page
    public void logoutIcon(View view)
    {
        Toast.makeText(getApplicationContext(),"User has logged out",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}