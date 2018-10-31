package com.example.hp.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity {

    private CalendarView calendarView;

    public ServiceDetail serviceDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        serviceDetail = (ServiceDetail)getIntent().getSerializableExtra("obj");

        calendarView = (CalendarView) findViewById(R.id.calenderView);

        calendarView.setMinDate(System.currentTimeMillis());

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + month + "/" + year;

                Calendar calendar = Calendar.getInstance();

                int thisDay = calendar.get(Calendar.DAY_OF_MONTH);

                if(thisDay == dayOfMonth){
                    Toast.makeText(DateActivity.this,"Service unavailable on selected date",Toast.LENGTH_SHORT).show();
                }
                else{

                    serviceDetail.setDate(date.toString());

                    Intent intent = new Intent(DateActivity.this,PlumberPricing.class);
                    intent.putExtra("obj",serviceDetail);
                    Toast.makeText(DateActivity.this,"Date selected"+date,Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

            }
        });

    }
}
