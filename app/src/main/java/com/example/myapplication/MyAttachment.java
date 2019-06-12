package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.AttachmentArchiveCitizen;
import com.example.myapplication.models.Service;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAttachment extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_attachment);


        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_citizen_attachment);

        R_loadAttachmentCitizen();
        drawAttachment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_attachment);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_my_attachment);
        navigationView.setNavigationItemSelectedListener(this);

    }


    private void R_loadAttachmentCitizen() {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<List<AttachmentArchiveCitizen>> call = apiInterface.getAttachmentArchiveCitizen(GetFromDB.getIdCitizen());
        call.enqueue(new Callback<List<AttachmentArchiveCitizen>>() {

            @Override
            public void onResponse(Call<List<AttachmentArchiveCitizen>> call, Response<List<AttachmentArchiveCitizen>> response) {
                GetFromDB.setAttachmentsArchiveCitizen(response.body());


            }

            @Override
            public void onFailure(Call<List<AttachmentArchiveCitizen>> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });


    }

    private void drawAttachment() {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(35, 0, 35, 35);

        List<AttachmentArchiveCitizen> attachmentsArchiveCitizen = GetFromDB.getAttachmentsArchiveCitizen();


        int id = 0;
        if (!attachmentsArchiveCitizen.isEmpty()) {
            final AttachmentArchiveCitizen ar = attachmentsArchiveCitizen.get(0);
            id = ar.getServiceAttachmentNameID();

            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);

            TextView textView = new TextView(this);
            textView.setText(ar.getNameAtt());
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(26);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(0,20,0,20);

            linearLayouth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToPageThisAttachment(ar.getServiceAttachmentNameID(),ar.getNameAtt());
                }
            });


            linearLayouth.setBackgroundResource(R.drawable.shape_button);
            linearLayouth.addView(textView);
            linearLayout.addView(linearLayouth,layoutParams);

            for (AttachmentArchiveCitizen archivesCitizen : attachmentsArchiveCitizen) {
                Log.i(" Message 1", ""+archivesCitizen.getServiceAttachmentNameID());
                Log.i(" Message 2", ""+id);

                final AttachmentArchiveCitizen arc = archivesCitizen;


                if (archivesCitizen.getServiceAttachmentNameID() != id) {

                    LinearLayout linearLayouth2 = new LinearLayout(this);
                    linearLayouth2.setOrientation(LinearLayout.HORIZONTAL);

                    TextView textView2 = new TextView(this);
                    textView2.setText(archivesCitizen.getNameAtt());
                    textView2.setTextColor(Color.BLACK);
                    textView2.setTextSize(26);
                    textView2.setGravity(Gravity.CENTER);
                    textView2.setPadding(0,20,0,20);

                    linearLayouth2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            goToPageThisAttachment(arc.getServiceAttachmentNameID(),arc.getNameAtt());
                        }
                    });


                    linearLayouth2.setBackgroundResource(R.drawable.shape_button);
                    linearLayouth2.addView(textView2);
                    linearLayout.addView(linearLayouth2,layoutParams);

                    id = archivesCitizen.getServiceAttachmentNameID();
                }
            }
        }

    }


    public void goToPageThisAttachment(int id,String name){
        Intent myIntent = new Intent(this, specificArchive.class);
        Bundle myBundle = new Bundle();
        myBundle.putInt("id", id);
        myBundle.putString("name", name);
        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_attachment);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_attachment);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

