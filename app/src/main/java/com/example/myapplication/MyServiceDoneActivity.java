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
import com.example.myapplication.models.Service;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyServiceDoneActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<ServiceCitizen> listDoneServices;
    private LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(" Message", "start");

        R_loadDoneServiceCitizen();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service_done);




        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_my_done_services);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_done_services);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_my_done_services);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.usernameTitle);
        navUsername.setText(GetFromDB.getUsernameTitle());
    }

    private void R_loadDoneServiceCitizen() {
        Log.i(" Message", "start22");
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<List<ServiceCitizen>> call = apiInterface.getDoneServiceCitizenCall(GetFromDB.getIdCitizen());

        call.enqueue(new Callback<List<ServiceCitizen>>() {

            @Override
            public void onResponse(Call<List<ServiceCitizen>> call, Response<List<ServiceCitizen>> response) {
                GetFromDB.setDoneServicesCitizen(response.body());
                Log.i(" Message", "length1 = "+GetFromDB.getDoneServicesCitizen().size()+"   start");
                drawMyServices();
            }

            @Override
            public void onFailure(Call<List<ServiceCitizen>> call, Throwable t) {

                Log.i("Error Message", t.getMessage());
            }
        });
        Log.i(" Message", "length2 = "+GetFromDB.getDoneServicesCitizen().size()+"   start");


    }

    private void drawMyServices() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 0, 30, 0);



        for (int i = 0 ; i < GetFromDB.getDoneServicesCitizen().size() ; i++) {
            final ServiceCitizen newServiceCitizen = GetFromDB.getDoneServicesCitizen().get(i);

            TextView newTextView2 = new TextView(this);
            newTextView2.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_check_circle_black_24dp,0);


            TextView newTextView1 = new TextView(this);
            newTextView1.setTextSize(24);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setText(newServiceCitizen.getService().getName());
            newTextView1.setTextColor(Color.parseColor("#1cc88a"));
            newTextView1.setTypeface(null, Typeface.BOLD);

            TextView newTextView3 = new TextView(this);
            newTextView3.setText(newServiceCitizen.getDate());
            newTextView3.setTextColor(Color.BLACK);

//             newTextView3.setLayoutParams(layoutParams);

//            TextView newTextView3 = new TextView(this);
//            newTextView3.setText(newServiceCitizen.getStatus());


            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(newTextView3);


            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);
            linearLayouth.setBackgroundResource(R.drawable.shape_button);
            linearLayouth.addView(newTextView2);
            linearLayouth.addView(linearLayoutv);


            //linearLayouth.addView(newTextView1);
//            layoutParams.setMargins(50, 0, 50, 0);
//            linearLayouth.addView(newTextView3,layoutParams);

            linearLayouth.setPadding(20,40,50,40);

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
        String name = serviceCitizen.getService().getName();

        Intent myIntent = new Intent(this, ShowServiceDone.class);
        Bundle myBundle = new Bundle();
        myBundle.putInt("idServiceCitizen", idServiceCitizen);
        myBundle.putInt("idServiceProvided", idServiceProvided);
        myBundle.putInt("idCitizen", idCitizen);
        myBundle.putString("name", name);

        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_done_services);
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
        } else if (id == R.id.nav_my_attachment) {
            startActivity(new Intent(this, MyAttachment.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_done_services);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


