package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.MyJavaClass.ServiceCitizen;

import java.util.ArrayList;

public class MyServiceDoneActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<ServiceCitizen> arraylistMyDoneServices;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service_done);

        arraylistMyDoneServices = new ArrayList<>();
        arraylistMyDoneServices = GetFromDB.getDoneServicesCitizen();


        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_my_done_services);
        drawMyServices();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_done_services);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_my_done_services);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void drawMyServices() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 20, 30, 10);
        for (int i = 0 ; i < arraylistMyDoneServices.size() ; i++) {
            ServiceCitizen newServiceCitizen = arraylistMyDoneServices.get(i);

            TextView newTextView1 = new TextView(this);
            newTextView1.setTextSize(18);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setText(newServiceCitizen.getService().getName());

            TextView newTextView2 = new TextView(this);
            newTextView2.setText(newServiceCitizen.getDate());

            TextView newTextView3 = new TextView(this);
            newTextView3.setText(newServiceCitizen.getStatus());


            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(newTextView2);


            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);
            linearLayouth.setBackgroundResource(R.drawable.shape_button);

            linearLayouth.addView(linearLayoutv);
            layoutParams.setMargins(50, 0, 50, 0);
            linearLayouth.addView(newTextView3,layoutParams);

            layoutParams.setMargins(30, 20, 30, 10);
            linearLayout.addView(linearLayouth, layoutParams);
        }
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
        } else if (id == R.id.nav_my_services) {
            startActivity(new Intent(this, MyServicesActivity.class));
        } else if (id == R.id.nav_my_done_services) {
            startActivity(new Intent(this, MyServiceDoneActivity.class));
        } else if (id == R.id.nav_my_not_done_services) {
            startActivity(new Intent(this, MyServiceNotDoneActivity.class));
        } else if (id == R.id.nav_help) {
            startActivity(new Intent(this, HelpActivity.class));
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, MainActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_done_services);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


