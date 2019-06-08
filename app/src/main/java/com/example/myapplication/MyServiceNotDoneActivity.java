package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.MyJavaClass.MyServiceCitizen;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyServiceNotDoneActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<ServiceCitizen> listNotDoneServices;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service_not_done);


        R_loadNotDoneServiceCitizen();
        listNotDoneServices = new ArrayList<>();
        listNotDoneServices = GetFromDB.getNotDoneServicesCitizen();

        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_my_not_done_services);
        drawMyServices();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_not_done_services);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_my_not_done_services);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void R_loadNotDoneServiceCitizen() {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<List<ServiceCitizen>> call = apiInterface.getNotDoneServiceCitizenCall();
        call.enqueue(new Callback<List<ServiceCitizen>>() {

            @Override
            public void onResponse(Call<List<ServiceCitizen>> call, Response<List<ServiceCitizen>> response) {
                GetFromDB.setNotDoneServicesCitizen(response.body());
            }

            @Override
            public void onFailure(Call<List<ServiceCitizen>> call, Throwable t) {

                Log.i("Error Message", t.getMessage());
            }
        });


    }
    private void drawMyServices() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 20, 30, 10);
        for (int i = 0 ; i < listNotDoneServices.size() ; i++) {
            final ServiceCitizen newServiceCitizen = listNotDoneServices.get(i);

            TextView newTextView1 = new TextView(this);
            newTextView1.setTextSize(24);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setText(newServiceCitizen.getService().getName());
            newTextView1.setTextColor(Color.parseColor("#FF9800"));
            newTextView1.setTypeface(null, Typeface.BOLD);

//            TextView newTextView2 = new TextView(this);
//            newTextView2.setText(newServiceCitizen.getDate());

            TextView newTextView3 = new TextView(this);
            newTextView3.setText(newServiceCitizen.getDate()+"d");
            newTextView3.setTextColor(Color.BLACK);


            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            linearLayoutv.addView(newTextView1);
            //linearLayoutv.addView(newTextView2);


            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);
            linearLayouth.setBackgroundResource(R.drawable.shape_button);

            linearLayouth.setPadding(20,40,50,40);

            linearLayouth.addView(linearLayoutv);
            layoutParams.setMargins(50, 0, 50, 0);
            linearLayouth.addView(newTextView3,layoutParams);

            linearLayouth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToPageThisService(newServiceCitizen);
                }
            });

            layoutParams.setMargins(30, 20, 30, 10);
            linearLayout.addView(linearLayouth, layoutParams);
        }
    }


    public void goToPageThisService(ServiceCitizen serviceCitizen) {
        int idServiceCitizen =serviceCitizen.getServiceCitizenID();
        int idServiceProvided =serviceCitizen.getService().getId();
        int idCitizen = serviceCitizen.getCitID();

        Intent myIntent = new Intent(this, ShowServiceDone.class);
        Bundle myBundle = new Bundle();
        myBundle.putInt("idServiceCitizen", idServiceCitizen);
        myBundle.putInt("idServiceProvided", idServiceProvided);
        myBundle.putInt("idCitizen", idCitizen);
        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_not_done_services);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(this, HomeActivity.class));
        } else if (id == R.id.nav_my_information) {
            startActivity(new Intent(this, MyInformation.class));
        } else if (id == R.id.nav_all_services) {
            startActivity(new Intent(this, AllServices.class));
        }
//        else if (id == R.id.nav_my_services) {
//            startActivity(new Intent(this, MyServicesActivity.class));
//        }
        else if (id == R.id.nav_my_done_services) {
            startActivity(new Intent(this, MyServiceDoneActivity.class));
        } else if (id == R.id.nav_my_not_done_services) {
            startActivity(new Intent(this, MyServiceNotDoneActivity.class));
        } else if (id == R.id.nav_help) {
            startActivity(new Intent(this, HelpActivity.class));
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_municipality_information) {
            startActivity(new Intent(this, MunicipalityInformation.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_not_done_services);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


