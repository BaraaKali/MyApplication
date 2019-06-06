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
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.models.MunInfo;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MunicipalityInformation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MunInfo munInfo = new MunInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality_information);

        R_loadMunicipalityInformatione();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_municipality_information);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_municipality_information);
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_municipality_information);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_municipality_information);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

