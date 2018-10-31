package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElectricianMain extends AppCompatActivity implements View.OnClickListener {

    private Button schedule_button_electrician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician_main);

        schedule_button_electrician = (Button)findViewById(R.id.schedule_button_electrician);
        schedule_button_electrician.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == schedule_button_electrician)
        {
            Intent intent = new Intent(this,ElectricianServiceReq.class);
            startActivity(intent);
        }
    }
}
