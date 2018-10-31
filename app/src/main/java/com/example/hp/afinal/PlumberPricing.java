package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlumberPricing extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout timeLayout1;
    private LinearLayout timeLayout2;
    private LinearLayout timeLayout3;

    public ServiceDetail serviceDetail;

    public TextView time1,time2,time3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_pricing);

        serviceDetail = (ServiceDetail)getIntent().getSerializableExtra("obj");

        timeLayout1 = (LinearLayout)findViewById(R.id.timeLayout1);
        timeLayout2 = (LinearLayout)findViewById(R.id.timeLayout2);
        timeLayout3 = (LinearLayout)findViewById(R.id.timeLayout3);

        time1 = (TextView)findViewById(R.id.time1);
        time2 = (TextView)findViewById(R.id.time2);
        time3 = (TextView)findViewById(R.id.time3);

        timeLayout1.setOnClickListener(this);
        timeLayout2.setOnClickListener(this);
        timeLayout3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == timeLayout1)
        {
            serviceDetail.setHours(time1.getText().toString());
            Intent intent = new Intent(this,SelectAddress.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == timeLayout2)
        {
            serviceDetail.setHours(time2.getText().toString());
            Intent intent = new Intent(this,SelectAddress.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == timeLayout3)
        {
            serviceDetail.setHours(time3.getText().toString());
            Intent intent = new Intent(this,SelectAddress.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
    }
}
