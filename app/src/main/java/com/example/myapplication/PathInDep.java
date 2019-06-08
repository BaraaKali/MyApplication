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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.DecisionSection;
import com.example.myapplication.models.Section;
import com.example.myapplication.models.StepsAndDecsions;
import com.example.myapplication.models.StepsAndDecsionsJob;

import java.util.List;

public class PathInDep extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    List<StepsAndDecsions> stepsAndDecsions ;
    private LinearLayout linearLayout;
    StepsAndDecsions step = new StepsAndDecsions();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_in_dep);


        Bundle bundle = getIntent().getExtras();
        int idDep = bundle.getInt("idDep");
        int orderDep = bundle.getInt("orderDep");

        stepsAndDecsions = GetFromDB.getStepsAndDecsions();
        for (int i = 0 ; i < stepsAndDecsions.size() ; i++) {
            if(stepsAndDecsions.get(i).getDepartmentPaths().getId() == idDep && stepsAndDecsions.get(i).getDepartmentPaths().getOrder() == orderDep){
                step = stepsAndDecsions.get(i);
            }
        }

        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_path_InDep);
        draw(step);


        setTitle(step.getDepartmentPaths().getNameA());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_show_service_path);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_show_service_path);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void draw(StepsAndDecsions step) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 30, 30, 30);

        for (int i = 0 ; i < step.getSections().size() ; i++) {
            final DecisionSection section = step.getSections().get(i);

            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            linearLayoutv.setBackgroundResource(R.drawable.shape_button);

            TextView newTextView1 = new TextView(this);
            newTextView1.setText(section.getSection().getName());

            linearLayout.addView(newTextView1);

            for (int j = 0 ; j < section.getJob().size(); j++) {
                final StepsAndDecsionsJob job = section.getJob().get(j);

                TextView newTextView2 = new TextView(this);
                newTextView2.setText(job.getJobPath().getName());
                TextView newTextView3 = new TextView(this);
                newTextView3.setText(job.getDecisionsJob().getEmployee().getEmpName());
                LinearLayout linearLayouth1 = new LinearLayout(this);
                linearLayouth1.setOrientation(LinearLayout.HORIZONTAL);
                linearLayouth1.addView(newTextView2);
                linearLayouth1.addView(newTextView3);
                linearLayoutv.addView(linearLayouth1);

                TextView newTextView4 = new TextView(this);
                newTextView4.setText(R.string.emp_com);
                TextView newTextView5 = new TextView(this);
                newTextView5.setText(job.getDecisionsJob().getExternalMessage());
                LinearLayout linearLayouth2 = new LinearLayout(this);
                linearLayouth2.setOrientation(LinearLayout.HORIZONTAL);
                linearLayouth2.addView(newTextView4);
                linearLayouth2.addView(newTextView5);
                linearLayoutv.addView(linearLayouth2);


            }




            linearLayout.addView(linearLayoutv, layoutParams);

        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_show_service_path);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_show_service_path);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}



