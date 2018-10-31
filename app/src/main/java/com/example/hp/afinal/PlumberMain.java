package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlumberMain extends AppCompatActivity implements View.OnClickListener {

    private Button schedule_button_plumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber_main);

        schedule_button_plumber = (Button)findViewById(R.id.schedule_button_plumber);

        schedule_button_plumber.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == schedule_button_plumber)
        {
            Intent intent = new Intent(this,PlumberServiceReq.class);
            startActivity(intent);
        }
    }
}
