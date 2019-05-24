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
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.MyJavaClass.Service;

import java.util.ArrayList;

public class ServicesInDepartment extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<Service> arraylistServices;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_in_department);

        Bundle bundle = getIntent().getExtras();
        int idDepartment = bundle.getInt("idDepartment");
        String nameDepartment = bundle.getString("nameDepartment");
        arraylistServices = GetFromDB.getServicesInDep(idDepartment);

        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_service_in_dep);
        drawServices();

        setTitle(nameDepartment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_services_in_department);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_services_in_department);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void drawServices() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(35, 0, 35, 35);


        for (int i = 0 ; i< arraylistServices.size() ; i++){
             final Service s = arraylistServices.get(i);

            TextView textView = new TextView(this);
            textView.setText(s.getName());
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(28);
            textView.setGravity(Gravity.CENTER);
            textView.setTypeface(null, Typeface.BOLD);
            textView.setBackgroundResource(R.drawable.shape_orange);
            textView.setPadding(0,20,0,20);
            if(s.getCaseserv().equals("valid")){
                textView.setBackgroundResource(R.drawable.shape_green);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goToPageThisService(s.getId());
                    }
                });
            }else {
                textView.setBackgroundResource(R.drawable.shape_red);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),R.string.not_valid,Toast.LENGTH_SHORT).show();

                    }
                });

            }

            linearLayout.addView(textView,layoutParams);

        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_services_in_department);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_services_in_department);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void goToPageThisService(int idService) {
        Intent myIntent = new Intent(this, SpecificSreviceActivity.class);
        Bundle myBundle = new Bundle();
        myBundle.putInt("idService", idService);
        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }

}
