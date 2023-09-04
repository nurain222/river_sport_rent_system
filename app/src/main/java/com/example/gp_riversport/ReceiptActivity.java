package com.example.gp_riversport;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ReceiptActivity extends AppCompatActivity {

    Button finishBook;
    Button openMain;
    ImageButton backButton, lockButton;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        //Displaying Customer Name
        auth = FirebaseAuth.getInstance();
        name = (TextView)findViewById(R.id.outputCust);
        user = auth.getCurrentUser();
        name.setText(user.getEmail());
        //Displaying Package Set and Price
        String msggg = getIntent().getExtras().getString("msggg","defaultKey");
        Integer price= getIntent().getExtras().getInt("price");
        Intent i = getIntent();
        TextView textView1 = (TextView) findViewById(R.id.outputPack);
        textView1.setText(""+msggg);
        TextView textView2 = (TextView) findViewById(R.id.outputPrice);
        textView2.setText("RM "+price);
        //Displaying date and Time
        String mDate = i.getStringExtra("mDate");
        String mTimeTo = i.getStringExtra("mTimeTo");
        String mTimeFrom = i.getStringExtra("mTimeFrom");
        TextView textView3 = (TextView) findViewById(R.id.outputDT);
        textView3.setText("Date: " +mDate +"  Time: " +mTimeFrom +"-"+mTimeTo);

        finishBook = (Button) findViewById(R.id.doneBtn);
        openMain = (Button) findViewById(R.id.logoutBtn);
        backButton = (ImageButton) findViewById(R.id.backBtn);
        lockButton = (ImageButton) findViewById(R.id.logoutIcn);
    }

    //Redirect to back to booking page
    public void doneButton(View view)
    {
        Intent i = new Intent(this, BookingActivity.class);
        startActivity(i);
    }

    //Redirect to back to main page
    public void logoutButton(View view)
    {
        Toast.makeText(getApplicationContext(),"User has logged out",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    //Redirect to back previous page
    public void bckButton(View view)
    {
        Intent i = new Intent(this, ConfirmBookingActivity.class);
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