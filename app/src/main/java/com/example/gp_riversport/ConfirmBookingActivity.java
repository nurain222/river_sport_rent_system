package com.example.gp_riversport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmBookingActivity extends AppCompatActivity {

    Button openReceipt;
    ImageButton backButton, lockButton;
    EditText mDate;
    EditText mTimeTo;
    EditText mTimeFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);
        String msgg = getIntent().getExtras().getString("msg","defaultKey");
        Integer price= getIntent().getExtras().getInt("prc");
        TextView textView = (TextView) findViewById(R.id.outputPack);
        textView.setText(""+msgg);
        TextView textView1 = (TextView) findViewById(R.id.outputPrice);
        textView1.setText("RM "+price);
        openReceipt = (Button) findViewById(R.id.confirmBtn);
        backButton = (ImageButton) findViewById(R.id.backBtn);
        lockButton = (ImageButton) findViewById(R.id.logoutIcn);

    }

    //Redirect to receipt page
    public void confirmButton(View view)
    {
        mDate   = (EditText)findViewById(R.id.inputDate);
        mTimeTo   = (EditText)findViewById(R.id.inputTimeTo);
        mTimeFrom   = (EditText)findViewById(R.id.inputTimeFrom);
        Intent i = new Intent(this, ReceiptActivity.class);
        String msggg = getIntent().getExtras().getString("msg","defaultKey");
        Integer price= getIntent().getExtras().getInt("prc");
        i.putExtra("msggg",msggg);
        i.putExtra("price",price);
        i.putExtra("mDate",mDate.getText().toString());
        i.putExtra("mTimeTo",mTimeTo.getText().toString());
        i.putExtra("mTimeFrom",mTimeFrom.getText().toString());
        startActivity(i);
    }

    //Redirect to back previous page
    public void bckButton(View view)
    {
        Intent i = new Intent(this, BookingActivity.class);
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