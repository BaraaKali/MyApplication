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
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.models.StepsAndDecsions;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowServiceDone extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

     List<StepsAndDecsions> stepsAndDecsions ;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service_done);

        Bundle bundle = getIntent().getExtras();
        int idServiceCitizen = bundle.getInt("idServiceCitizen");
        int idServiceProvided = bundle.getInt("idServiceProvided");
        int idCitizen = bundle.getInt("idCitizen");
        String name = bundle.getString("name");


        R_loadDoneServiceCitizen();
        stepsAndDecsions = GetFromDB.getStepsAndDecsions();
        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_path);
        draw();

        setTitle(name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_show_service_done);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_show_service_done);
        navigationView.setNavigationItemSelectedListener(this);



    }


    private void draw() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 30, 30, 30);

        for (int i = 0 ; i < stepsAndDecsions.size() ; i++) {
            final StepsAndDecsions step = stepsAndDecsions.get(i);

            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            linearLayoutv.setBackgroundResource(R.drawable.shape_button);


            TextView newTextView1 = new TextView(this);
            newTextView1.setText(step.getDepartmentPaths().getNameA());


            TextView newTextView2 = new TextView(this);
            newTextView2.setText(getString(R.string.ser_cas));
            TextView newTextView3 = new TextView(this);
            int idstatus = step.getDecisionsDepartment().nameStatus();
            String status = getString(idstatus);
            newTextView3.setText(status);
            LinearLayout linearLayouth1 = new LinearLayout(this);
            linearLayouth1.setOrientation(LinearLayout.HORIZONTAL);
            linearLayouth1.addView(newTextView2);
            linearLayouth1.addView(newTextView3);


            TextView newTextView4 = new TextView(this);
            newTextView4.setText(getString(R.string.ser_des));
            TextView newTextView5 = new TextView(this);
            int iddecision = step.getDecisionsDepartment().nameDecision();
            String decision = getString(iddecision);
            newTextView5.setText(decision);
            LinearLayout linearLayouth2 = new LinearLayout(this);
            linearLayouth2.setOrientation(LinearLayout.HORIZONTAL);
            linearLayouth2.addView(newTextView4);
            linearLayouth2.addView(newTextView5);


            TextView newTextView6 = new TextView(this);
            newTextView6.setText(getString(R.string.ser_com));
            TextView newTextView7 = new TextView(this);
            newTextView7.setText(step.getDecisionsDepartment().getExternalMessage());
            LinearLayout linearLayouth3 = new LinearLayout(this);
            linearLayouth3.setOrientation(LinearLayout.VERTICAL);
            linearLayouth3.addView(newTextView6);
            linearLayouth3.addView(newTextView7);



            TextView newTextView8 = new TextView(this);
            newTextView8.setText(getString(R.string.ser_cost));
            TextView newTextView9 = new TextView(this);
            newTextView9.setText(""+step.getDecisionsDepartment().getTotalDepCost());
            LinearLayout linearLayouth4 = new LinearLayout(this);
            linearLayouth4.setOrientation(LinearLayout.HORIZONTAL);
            linearLayouth4.addView(newTextView8);
            linearLayouth4.addView(newTextView9);


//            TextView newTextView = new TextView(this);
//            int idstatus = step.getDecisionsDepartment().nameStatus();
//            String status = getString(idstatus);
//            newTextView.setText(status);


            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(linearLayouth1);
            linearLayoutv.addView(linearLayouth2);
            linearLayoutv.addView(linearLayouth3);
            linearLayoutv.addView(linearLayouth4);

            linearLayoutv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToPageThisDepPath(step);
                }
            });



            linearLayout.addView(linearLayoutv, layoutParams);
        }
    }

    public void goToPageThisDepPath(StepsAndDecsions step) {
        int idDep =step.getDepartmentPaths().getId();
        int orderDep =step.getDepartmentPaths().getOrder();

        Intent myIntent = new Intent(this, PathInDep.class);
        Bundle myBundle = new Bundle();
        myBundle.putInt("idDep", idDep);
        myBundle.putInt("orderDep", orderDep);
        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }


    private void R_loadDoneServiceCitizen() {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<List<StepsAndDecsions>> call = apiInterface.getStepsAndDesionCall();
        call.enqueue(new Callback<List<StepsAndDecsions>>() {


            @Override
            public void onResponse(Call<List<StepsAndDecsions>> call, Response<List<StepsAndDecsions>> response) {
                GetFromDB.setStepsAndDecsions(response.body());

            }

            @Override
            public void onFailure(Call<List<StepsAndDecsions>> call, Throwable t) {

                Log.i("Error Message", t.getMessage());

            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_show_service_done);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_show_service_done);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


