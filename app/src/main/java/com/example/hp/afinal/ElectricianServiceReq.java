package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ElectricianServiceReq extends AppCompatActivity implements View.OnClickListener {



    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;

    public TextView gew,mcp,hti,gewPrice,mcpPrice,htiPrice;

    public ServiceDetail serviceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician_service_req);


        linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout)findViewById(R.id.linearLayout2);
        linearLayout3 = (LinearLayout)findViewById(R.id.linearLayout3);

        gew = (TextView)findViewById(R.id.gew);
        mcp = (TextView)findViewById(R.id.mcp);
        hti = (TextView)findViewById(R.id.hti);

        gewPrice = (TextView)findViewById(R.id.gewPrice);
        mcpPrice = (TextView)findViewById(R.id.mcpPrice);
        htiPrice = (TextView)findViewById(R.id.htiPrice);


        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == linearLayout1)
        {
            serviceDetail = new ServiceDetail(gew.getText().toString(),null,null,gewPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == linearLayout2)
        {
            serviceDetail = new ServiceDetail(mcp.getText().toString(),null,null,mcpPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
        if(v == linearLayout3)
        {
            serviceDetail = new ServiceDetail(hti.getText().toString(),null,null,htiPrice.getText().toString(),null);
            Intent intent = new Intent(this,DateActivity.class);
            intent.putExtra("obj",serviceDetail);
            startActivity(intent);
        }
    }
}
