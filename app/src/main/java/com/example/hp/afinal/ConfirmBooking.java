package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmBooking extends AppCompatActivity implements View.OnClickListener{

    private TextView service_Name,Price,Address,Date,time;
    private Button confirmBooking;
    public ServiceDetail serviceDetail;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        databaseReference = FirebaseDatabase.getInstance().getReference("Bookings");

        firebaseAuth = FirebaseAuth.getInstance();

        serviceDetail = (ServiceDetail)getIntent().getSerializableExtra("obj");

        service_Name = (TextView)findViewById(R.id.serviceName);
        Price = (TextView)findViewById(R.id.Price);
        Address = (TextView)findViewById(R.id.address);
        Date = (TextView)findViewById(R.id.date);
        time = (TextView)findViewById(R.id.time);

        confirmBooking = (Button)findViewById(R.id.confirmBooking);
        confirmBooking.setOnClickListener(this);

        service_Name.setText(serviceDetail.getServiceName());
        Price.setText(serviceDetail.getPrice());
        Address.setText(serviceDetail.getAddress());
        Date.setText(serviceDetail.getDate());
        time.setText(serviceDetail.getHours());




    }

    @Override
    public void onClick(View v) {
        if (v == confirmBooking){
            add();
        }
    }

    private void add() {
        String name = service_Name.getText().toString().trim();
        String address = Address.getText().toString().trim();
        String hours = time.getText().toString().trim();
        String price = Price.getText().toString().trim();
        String date =  Date.getText().toString().trim();

        String id = databaseReference.push().getKey();
        ServiceDetail serviceDetail = new ServiceDetail(name,address,hours,price,date);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).child(id).setValue(serviceDetail);

        Intent intent = new Intent(this,MyBookings.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
