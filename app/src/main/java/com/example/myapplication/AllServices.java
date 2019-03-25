package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.MyJavaClass.Service;

import java.util.ArrayList;

public class AllServices extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
           {

    ListView ListView_all_services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);
        ListView_all_services = (ListView)findViewById(R.id.ListView_all_services);

        ArrayList<Service> listAllServices = new ArrayList<>();
        listAllServices = GetFromDB.getAllServices();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listAllServices);
        ListView_all_services.setAdapter(arrayAdapter);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_all_service);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_all_services);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_all_service);
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
            Intent myIntent2 = new Intent(this,HomeActivity.class);
            startActivity(myIntent2);
        } else if (id == R.id.nav_my_information) {
            Intent myIntent3 = new Intent(this,MyInformation.class);
            startActivity(myIntent3);
        } else if (id == R.id.nav_all_services) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            Intent myIntent5 = new Intent(this,MainActivity.class);
            startActivity(myIntent5);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_all_service);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
