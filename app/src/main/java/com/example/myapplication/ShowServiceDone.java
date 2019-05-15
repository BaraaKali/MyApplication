package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowServiceDone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service_done);

        Bundle bundle = getIntent().getExtras();
        int idServiceCitizen = bundle.getInt("idServiceCitizen");
        int idServiceProvided = bundle.getInt("idServiceProvided");
        int idCitizen = bundle.getInt("idCitizen");




    }
}
