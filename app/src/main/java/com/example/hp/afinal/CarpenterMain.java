package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarpenterMain extends AppCompatActivity implements View.OnClickListener {

    private Button schedule_button_carpenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpenter_main);

        schedule_button_carpenter = (Button)findViewById(R.id.schedule_button_carpenter);
        schedule_button_carpenter.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
            if(v == schedule_button_carpenter)
            {
                Intent intent = new Intent(this,CarpenterServiceReq.class);
                startActivity(intent);
            }
    }
}
