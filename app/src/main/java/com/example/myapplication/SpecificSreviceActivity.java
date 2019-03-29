package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.MyJavaClass.Service;

import java.util.ArrayList;

public class SpecificSreviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_srevice);

        Bundle bundle = getIntent().getExtras();
        int idService = bundle.getInt("idService");

        Service service = getServiceFromArray(idService);

        TextView textView_service_name = findViewById(R.id.textView_service_name);
        textView_service_name.setText(service.getName());

        TextView textView_service_case = findViewById(R.id.textView_service_case);
        textView_service_case.setText(service.getCaseserv());

    }

    public Service getServiceFromArray(int idService){

        ArrayList<Service> arrayListAllServices = GetFromDB.getArraylistAllServices();
        for (Service service:arrayListAllServices) {
            if (service.getId() == idService)
                return service;
        }
        return null;
    }
}
