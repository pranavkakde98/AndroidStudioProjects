package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CarpenterServiceReq extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;

    public TextView gcw,adf,vp,gcwPrice,adfPrice,vpPrice;

    public ServiceDetail serviceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpenter_service_req);

        linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout)findViewById(R.id.linearLayout2);
        linearLayout3 = (LinearLayout)findViewById(R.id.linearLayout3);

        gcw = (TextView)findViewById(R.id.gcw);
        adf = (TextView)findViewById(R.id.adf);
        vp = (TextView)findViewById(R.id.vp);

        gcwPrice = (TextView)findViewById(R.id.gcwPrice);
        adfPrice = (TextView)findViewById(R.id.adfPrice);
        vpPrice = (TextView)findViewById(R.id.vpPrice);


        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == linearLayout1)
        {
            serviceDetail = new ServiceDetail(gcw.getText().toString(),null,null,gcwPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == linearLayout2)
        {
            serviceDetail = new ServiceDetail(adf.getText().toString(),null,null,adfPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == linearLayout3)
        {
            serviceDetail = new ServiceDetail(vp.getText().toString(),null,null,vpPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
    }
}
