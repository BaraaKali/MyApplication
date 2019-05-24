package com.example.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.Attachment;
import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.MyJavaClass.Service;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class SpecificSreviceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Service service;

   // ListView ListView_attachment;
    ArrayList<Attachment> arraylistAttachment;
   // ArrayAdapter arrayAdapter_attachment;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_srevice);

        Bundle bundle = getIntent().getExtras();
        int idService = bundle.getInt("idService");
        service = getServiceFromArray(idService);

        TextView textView_service_name = findViewById(R.id.textView_service_name);
        textView_service_name.setText(service.getName());
        TextView textView_service_cost = findViewById(R.id.textView_service_cost);
        textView_service_cost.setText(service.getCost() + "");
        TextView textView_service_days = findViewById(R.id.textView_service_days);
        textView_service_days.setText(service.getDays() + "");
        TextView textView_service_case = findViewById(R.id.textView_service_case);
        textView_service_case.setText(service.getCaseserv());

        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_service);
        arraylistAttachment = new ArrayList<>();
        arraylistAttachment = GetFromDB.getServiceAttachment(idService);
        Log.d("MyApp", arraylistAttachment.size()+"");

        drawAttachment();

//        ListView_attachment = (ListView) findViewById(R.id.ListView_attachment);
//        arraylistAttachment = new ArrayList<>();
//        arraylistAttachment = GetFromDB.getServiceAttachment(idService);
//
//        arrayAdapter_attachment = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylistAttachment);
//        ListView_attachment.setAdapter(arrayAdapter_attachment);
//
//        ListView_attachment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Attachment select_attachment = (Attachment) ListView_attachment.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(), select_attachment.getName(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_specific_service);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_specific_service);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_specific_service);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_specific_service);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Service getServiceFromArray(int idService) {

        ArrayList<Service> arrayListAllServices = GetFromDB.getArraylistServicesInDepartment();
        for (Service service : arrayListAllServices) {
            if (service.getId() == idService)
                return service;
        }
        return null;
    }



    public void drawAttachment(){
        for (int i = 0 ; i < arraylistAttachment.size() ; i++){
            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);

            TextView newTextView1 = new TextView(this);
            newTextView1.setText(arraylistAttachment.get(i).getName());
            newTextView1.setTextSize(18);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);


            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            TextView newTextView2 = new TextView(this);
            newTextView2.setText(arraylistAttachment.get(i).getNote());
            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(newTextView2);


            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 0, 10, 0);

            linearLayouth.addView(linearLayoutv);

            Button button1 = new Button(this);
            button1.setText(getString(R.string.upload));
            linearLayouth.addView(button1,layoutParams);

            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    new MaterialFilePicker()
                            .withActivity(SpecificSreviceActivity.this)
                            .withRequestCode(1000)
                            .withFilter(Pattern.compile(".*\\.jpg")) // Filtering files and directories by file name using regexp

                            .withHiddenFiles(true) // Show hidden files and folders
                            .start();
                }
            });

            if(arraylistAttachment.get(i).getSrc() != null){
                Button button2 = new Button(this);
                button2.setText(getString(R.string.download));
                linearLayouth.addView(button2,layoutParams);
            }
            layoutParams.setMargins(30, 20, 30, 10);
            linearLayout.addView(linearLayouth,layoutParams);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            // Do anything with file
           // textView.setText(filePath);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 1001:{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"Permission not granted",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}

