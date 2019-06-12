package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.MunInfo;
import com.example.myapplication.models.Service;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
      MunInfo munInfo = new MunInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         R_loadMunicipalityInformatione();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_home);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_home);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_home);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_home);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void goToAllService(View view) {
        startActivity(new Intent(this, AllServices.class));
    }

    private void R_loadMunicipalityInformatione() {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<MunInfo> call = apiInterface.getMunicipalityInformationeCall();
        call.enqueue(new Callback<MunInfo>() {

            @Override
            public void onResponse(Call<MunInfo> call, Response<MunInfo> response) {
               munInfo = response.body();
                fillTextMunInfo();
            }

            @Override
            public void onFailure(Call<MunInfo> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });


    }
    public void goTodoneService(View view) {
        startActivity(new Intent(this, MyServiceDoneActivity.class));
    }

    public void goToNotDoneService(View view) {
        startActivity(new Intent(this, MyServiceNotDoneActivity.class));
    }

    public void fillTextMunInfo(){

        TextView textView_muni_name = (TextView)findViewById(R.id.textView_muni_name);
        textView_muni_name.setText(munInfo.getMunName());

        TextView textView_muni_city = (TextView)findViewById(R.id.textView_muni_city);
        textView_muni_city.setText(munInfo.getMunCity());

        TextView textView_muni_zone = (TextView)findViewById(R.id.textView_muni_zone);
        textView_muni_zone.setText(munInfo.getMunZone());

        TextView textView_muni_street = (TextView)findViewById(R.id.textView_muni_street);
        textView_muni_street.setText(munInfo.getMunStreet());

        TextView textView_muni_email = (TextView)findViewById(R.id.textView_muni_email);
        textView_muni_email.setText(munInfo.getEmail());

        TextView textView_muni_telephone = (TextView)findViewById(R.id.textView_muni_telephone);
        textView_muni_telephone.setText(munInfo.getTelephone());

        TextView textView_muni_fax = (TextView)findViewById(R.id.textView_muni_fax);
        textView_muni_fax.setText(munInfo.getFax());


    }

}
