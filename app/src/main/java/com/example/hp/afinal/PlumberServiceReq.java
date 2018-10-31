package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PlumberServiceReq extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;

    public TextView wmc,lwt,cws,wmcPrice,lwtPrice,cwsPrice;

    public ServiceDetail serviceDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_service_req);

        linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout)findViewById(R.id.linearLayout2);
        linearLayout3 = (LinearLayout)findViewById(R.id.linearLayout3);

        wmc = (TextView)findViewById(R.id.wmc);
        lwt = (TextView)findViewById(R.id.lwt);
        cws = (TextView)findViewById(R.id.cws);

        wmcPrice = (TextView)findViewById(R.id.wmcPrice);
        lwtPrice = (TextView)findViewById(R.id.lwtPrice);
        cwsPrice = (TextView)findViewById(R.id.cwsPrice);


        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == linearLayout1)
        {
            serviceDetail = new ServiceDetail(wmc.getText().toString(),null,null,wmcPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == linearLayout2)
        {
            serviceDetail = new ServiceDetail(lwt.getText().toString(),null,null,lwtPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == linearLayout3)
        {
            serviceDetail = new ServiceDetail(cws.getText().toString(),null,null,cwsPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }

    }
}
