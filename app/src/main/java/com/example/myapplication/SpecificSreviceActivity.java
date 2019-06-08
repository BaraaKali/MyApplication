package com.example.myapplication;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.MyAttachment;
import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.Attachment;
import com.example.myapplication.models.AttwhithFile;
import com.example.myapplication.models.Service;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SpecificSreviceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Service service;


    LinearLayout linearLayout_attachment;
    LinearLayout linearLayout_requirements;
    List<Attachment> arraylistrequirements;
    List<AttwhithFile> arraylistAttachment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_srevice);

        Bundle bundle = getIntent().getExtras();
        int idService = bundle.getInt("idService");
        service = GetFromDB.getSelectedService(idService);


        TextView textView_service_cost = findViewById(R.id.textView_service_cost);
        textView_service_cost.setText(service.getCost() + "");
        TextView textView_service_days = findViewById(R.id.textView_service_days);
        textView_service_days.setText(service.getDays() + "");
        TextView textView_service_note = findViewById(R.id.textView_service_note);
        textView_service_note.setText(service.getNote() + "");

        linearLayout_requirements = (LinearLayout) findViewById(R.id.LinerLayout_service_requirements);
        arraylistrequirements = service.getAttachment();
        drawRequirements();


        linearLayout_attachment = (LinearLayout) findViewById(R.id.LinerLayout_attachment);
        arraylistAttachment = service.getAttwhithFile();
        drawAttachment();


        setTitle(service.getName());

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




    public void drawRequirements(){
        for (int i = 0; i < arraylistrequirements.size() ; i++){
            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);

            TextView newTextView1 = new TextView(this);
            newTextView1.setText(arraylistrequirements.get(i).getName());
            newTextView1.setTextSize(18);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setTextColor(Color.BLACK);
            newTextView1.setPadding(30,30,30,10);

            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            TextView newTextView2 = new TextView(this);
            newTextView2.setTextColor(Color.BLACK);
            newTextView2.setText(arraylistrequirements.get(i).getNotes());
            newTextView2.setPadding(40,10,40,30);

            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(newTextView2);


            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 0, 10, 30);

            Button button1 = new Button(this);
            button1.setBackgroundResource(R.drawable.ic_cloud_upload_black_24dp);
            linearLayouth.addView(button1);
            linearLayouth.setGravity(Gravity.LEFT);
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

            linearLayoutv.addView(linearLayouth,layoutParams);

            linearLayoutv.setBackgroundResource(R.drawable.shape_button);
            linearLayout_requirements.addView(linearLayoutv,layoutParams);

        }

    }


    public void drawAttachment(){


        for (int i = 0; i < arraylistAttachment.size() ; i++){
            final AttwhithFile wf = arraylistAttachment.get(i);

            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);

            TextView newTextView1 = new TextView(this);
            newTextView1.setText(arraylistAttachment.get(i).getName());
            newTextView1.setTextSize(18);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setTextColor(Color.BLACK);
            newTextView1.setPadding(30,30,30,10);

            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            TextView newTextView2 = new TextView(this);
            newTextView2.setTextColor(Color.BLACK);
            newTextView2.setText(arraylistAttachment.get(i).getNotes());
            newTextView2.setPadding(40,10,40,30);

            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(newTextView2);


            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 0, 10, 30);


            final Button button1 = new Button(this);
            button1.setBackgroundResource(R.drawable.ic_cloud_upload_black_24dp);
            linearLayouth.addView(button1);
            linearLayouth.setGravity(Gravity.LEFT);
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

                Button button2 = new Button(this);
                button2.setBackgroundResource(R.drawable.ic_cloud_download_black_24dp);
                linearLayouth.addView(button2);
                button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //InputStream inputForData = new ByteArrayInputStream(wf.getOutputfinal());

//                    DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//                    DownloadManager.Request request = new DownloadManager.Request(file);
//                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                    Long referancd = downloadManager.enqueue(request);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        Log.i("tag1","Permission is granted");

                        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED){
                        // Permission is not granted
                            Log.i("tag2","Permission is granted");

//                    byte[] b = wf.getOutputfinal().getBytes();
                        File imgFile = new File("/sdcard/Download/profile_icon.png");
                        //imgFile = writeByte(b);
                        if (imgFile.exists()) {
                            //Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                            //ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);
//                            Log.i("tag3",""+myImage.getId());
//                             myImage.setImageBitmap(myBitmap);
                            showim();

                        } else {
                        }

                    }else{
                            ActivityCompat.requestPermissions(SpecificSreviceActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                            Log.i("Not Exxteeeee", "Not Existseeeee");

                        }
                }}
            });


            linearLayoutv.addView(linearLayouth,layoutParams);

            linearLayoutv.setBackgroundResource(R.drawable.shape_button);
            linearLayout_attachment.addView(linearLayoutv,layoutParams);

        }

    }

    public File writeByte(byte[] bytes)
    {
        try {


             File file = new File("");

            // Initialize a pointer
            // in file using OutputStream
            OutputStream os = new FileOutputStream(file);
            Log.i(" yesss","yesss");

            // Starts writing the bytes in it
            os.write(bytes);


            // Close the file
            os.close();
            return file;
        }

        catch (Exception e) {
            Log.i("Not Exxt",e.toString());
        }
        return null;
    }

    public void showim() {
        startActivity(new Intent(this, ShowImage.class));
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

    public void requesrService(View view) {
    }
}

