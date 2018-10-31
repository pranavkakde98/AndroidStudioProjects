package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SelectAddress extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layout2;
    private EditText address;
    private Button addButton;
    public ServiceDetail serviceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_address);

        serviceDetail = (ServiceDetail)getIntent().getSerializableExtra("obj");

        layout2 = (LinearLayout)findViewById(R.id.layout2);
        address = (EditText)findViewById(R.id.address);
        addButton = (Button)findViewById(R.id.addButton);

        address.setVisibility(View.GONE);
        addButton.setVisibility(View.GONE);

        layout2.setOnClickListener(this);
        addButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
       if(v == layout2){
           address.setVisibility(View.VISIBLE);
           addButton.setVisibility(View.VISIBLE);
       }

       if (v == addButton){
           add();
       }

    }

    private void add() {
        serviceDetail.setAddress(address.getText().toString());
        Intent intent = new Intent(this,ConfirmBooking.class);
        intent.putExtra("obj",serviceDetail);
        startActivity(intent);
    }
}
