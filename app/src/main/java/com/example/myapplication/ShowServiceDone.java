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
import android.view.Gravity;
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

        Log.i("idServiceCitizen",""+idServiceCitizen);
        Log.i("idServiceProvided",""+idServiceProvided);


        R_loadDoneServiceCitizen(idServiceCitizen,idServiceProvided);
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
        layoutParams.setMargins(30, 30, 30, 70);
        if (stepsAndDecsions != null) {
            for (int i = 0; i < stepsAndDecsions.size(); i++) {
                final StepsAndDecsions step = stepsAndDecsions.get(i);

                LinearLayout linearLayoutv = new LinearLayout(this);
                linearLayoutv.setOrientation(LinearLayout.VERTICAL);

                if (step.getDecisionsDepartment().getDecision() == null) {
                    linearLayoutv.setBackgroundResource(R.drawable.shape_around_blue);
                } else if (step.getDecisionsDepartment().getDecision().equals("yes")) {
                    linearLayoutv.setBackgroundResource(R.drawable.shape_around_green);
                } else if (step.getDecisionsDepartment().getDecision().equals("no")) {
                    linearLayoutv.setBackgroundResource(R.drawable.shape_around_red);
                } else {
                    linearLayoutv.setBackgroundResource(R.drawable.shape_button);
                }


                TextView newTextView1 = new TextView(this);
                newTextView1.setText(step.getDepartmentPaths().getNameA());
                newTextView1.setTextSize(20);
                newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView1.setTextColor(Color.rgb(33, 150, 243));
                newTextView1.setPadding(30, 30, 30, 5);
                newTextView1.setGravity(Gravity.CENTER);


                TextView newTextViewimg1 = new TextView(this);
                newTextViewimg1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_build_black_24dp);

                TextView newTextView2 = new TextView(this);
                newTextView2.setText(getString(R.string.ser_cas));
                newTextView2.setTextSize(18);
                newTextView2.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView2.setTextColor(Color.BLACK);
                newTextView2.setPadding(30, 30, 30, 5);

                TextView newTextView3 = new TextView(this);
                newTextView3.setTextSize(18);
                newTextView3.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView3.setTextColor(Color.BLACK);
                newTextView3.setPadding(30, 30, 30, 5);

                int idstatus = step.getDecisionsDepartment().nameStatus();
                String status = getString(idstatus);
                newTextView3.setText(status);
                LinearLayout linearLayouth1v = new LinearLayout(this);
                linearLayouth1v.setOrientation(LinearLayout.VERTICAL);
                linearLayouth1v.addView(newTextViewimg1);
                linearLayouth1v.addView(newTextView2);
                linearLayouth1v.addView(newTextView3);
                if (step.getDecisionsDepartment().getDecision() == null) {
                    linearLayouth1v.setBackgroundResource(R.drawable.shape_button);
                } else if (step.getDecisionsDepartment().getDecision().equals("yes")) {
                    linearLayouth1v.setBackgroundResource(R.drawable.shape_around_green);
                } else if (step.getDecisionsDepartment().getDecision().equals("no")) {
                    linearLayouth1v.setBackgroundResource(R.drawable.shape_around_red);
                } else {
                    linearLayouth1v.setBackgroundResource(R.drawable.shape_button);
                }


                TextView newTextView4 = new TextView(this);
                newTextView4.setText(getString(R.string.ser_des));
                newTextView4.setTextSize(18);
                newTextView4.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView4.setTextColor(Color.BLACK);
                newTextView4.setPadding(30, 30, 30, 5);
                TextView newTextView5 = new TextView(this);
                newTextView5.setTextSize(18);
                newTextView5.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView5.setTextColor(Color.BLACK);
                newTextView5.setPadding(30, 30, 30, 5);
                int iddecision = step.getDecisionsDepartment().nameDecision();
                String decision = getString(iddecision);
                newTextView5.setText(decision);
                LinearLayout linearLayouth2v = new LinearLayout(this);
                linearLayouth2v.setOrientation(LinearLayout.VERTICAL);
                TextView newTextViewimg2 = new TextView(this);
                newTextViewimg2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_settings_black_24dp);
                linearLayouth2v.addView(newTextViewimg2);
                linearLayouth2v.addView(newTextView4);
                linearLayouth2v.addView(newTextView5);
                if (step.getDecisionsDepartment().getDecision() == null) {
                    linearLayouth2v.setBackgroundResource(R.drawable.shape_around_red);
                } else if (step.getDecisionsDepartment().getStatus().equals("done")) {
                    linearLayouth2v.setBackgroundResource(R.drawable.shape_around_green);
                } else {
                    linearLayouth2v.setBackgroundResource(R.drawable.shape_around_red);
                }


                TextView newTextView8 = new TextView(this);
                newTextView8.setText(getString(R.string.ser_cost));
                newTextView8.setTextSize(18);
                newTextView8.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView8.setTextColor(Color.BLACK);
                newTextView8.setPadding(30, 30, 30, 5);
                TextView newTextView9 = new TextView(this);
                newTextView9.setText("" + step.getDecisionsDepartment().getTotalDepCost() + " " + getString(R.string.money));
                newTextView9.setTextSize(18);
                newTextView9.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView9.setTextColor(Color.BLACK);
                newTextView9.setPadding(30, 30, 30, 5);
                LinearLayout linearLayouth4v = new LinearLayout(this);
                linearLayouth4v.setOrientation(LinearLayout.VERTICAL);
                linearLayouth4v.setBackgroundResource(R.drawable.shape_around_orange);
                TextView newTextViewimg3 = new TextView(this);
                newTextViewimg3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_attach_money_black_24dp);
                linearLayouth4v.addView(newTextViewimg3);
                linearLayouth4v.addView(newTextView8);
                linearLayouth4v.addView(newTextView9);


                TextView newTextView6 = new TextView(this);
                newTextView6.setText(getString(R.string.ser_com));
                newTextView6.setTextSize(18);
                newTextView6.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView6.setTextColor(Color.BLACK);
                newTextView6.setPadding(30, 30, 30, 5);
                TextView newTextView7 = new TextView(this);
                newTextView7.setText(step.getDecisionsDepartment().getExternalMessage());
                newTextView7.setTextSize(18);
                newTextView7.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView7.setTextColor(Color.BLACK);
                newTextView7.setPadding(30, 30, 30, 5);
                LinearLayout linearLayouth3 = new LinearLayout(this);
                linearLayouth3.setOrientation(LinearLayout.VERTICAL);
                linearLayouth3.setBackgroundResource(R.drawable.shape_button);
                linearLayouth3.addView(newTextView6);
                linearLayouth3.addView(newTextView7);


//            TextView newTextView = new TextView(this);
//            int idstatus = step.getDecisionsDepartment().nameStatus();
//            String status = getString(idstatus);
//            newTextView.setText(status);


                linearLayoutv.addView(newTextView1);

                LinearLayout linearLayouthor = new LinearLayout(this);
                linearLayouthor.setOrientation(LinearLayout.HORIZONTAL);
                linearLayouthor.setGravity(Gravity.CENTER);

                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams2.setMargins(55, 10, 55, 10);

                linearLayouthor.addView(linearLayouth1v, layoutParams2);
                linearLayouthor.addView(linearLayouth2v, layoutParams2);
                linearLayouthor.addView(linearLayouth4v, layoutParams2);
                linearLayoutv.addView(linearLayouthor);

                linearLayoutv.addView(linearLayouth3, layoutParams);

                linearLayoutv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goToPageThisDepPath(step);
                    }
                });


                linearLayout.addView(linearLayoutv, layoutParams);
            }
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


    private void R_loadDoneServiceCitizen(int idSerCit, int idService) {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<List<StepsAndDecsions>> call = apiInterface.getStepsAndDesionCall(GetFromDB.getIdCitizen(),idSerCit,idService);
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


