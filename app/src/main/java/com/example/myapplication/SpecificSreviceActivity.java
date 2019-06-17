package com.example.myapplication;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.AttFileTex;
import com.example.myapplication.models.Attachment;
import com.example.myapplication.models.AttwhithFile;
import com.example.myapplication.models.CitizenRequest;
import com.example.myapplication.models.ServerResponse;
import com.example.myapplication.models.Service;
import com.example.myapplication.models.ServiceCitizen;
import com.example.myapplication.models.UpLoadFiles;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.nbsp.materialfilepicker.utils.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecificSreviceActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Service service;

    ServiceCitizen serviceCitizen;

    LinearLayout linearLayout_attachment;
    LinearLayout linearLayout_requirements;
    List<Attachment> arraylistrequirements;
    List<AttwhithFile> arraylistAttachment;

    TextView newTextViewfilename;
    TextView TVrequirements;
    TextView TVattachment;

    int idService;
    int idMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_srevice);

        newTextViewfilename = new TextView(this);


        Bundle bundle = getIntent().getExtras();
        idService = bundle.getInt("idService");
        service = GetFromDB.getSelectedService(idService);


        TextView textView_service_cost = findViewById(R.id.textView_service_cost);
        textView_service_cost.setText(service.getCost() + "");
        TextView textView_service_days = findViewById(R.id.textView_service_days);
        textView_service_days.setText(service.getDays() + "");
        TextView textView_service_note = findViewById(R.id.textView_service_note);
        textView_service_note.setText(service.getNote() + "");

        TVrequirements = (TextView) findViewById(R.id.TVrequirements);
        TVattachment = (TextView) findViewById(R.id.TVattachment);

        linearLayout_requirements = (LinearLayout) findViewById(R.id.LinerLayout_service_requirements);
        arraylistrequirements = service.getAttachment();
        drawRequirements();


        linearLayout_attachment = (LinearLayout) findViewById(R.id.LinerLayout_attachment);
        arraylistAttachment = service.getAttwhithFile();
        drawAttachment();

        serviceCitizen = new ServiceCitizen();

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

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.usernameTitle);
        navUsername.setText(GetFromDB.getUsernameTitle());
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
        } else if (id == R.id.nav_my_attachment) {
            startActivity(new Intent(this, MyAttachment.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_specific_service);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
public int idTextViewSelected = 0;

    public void drawRequirements() {
        if (arraylistrequirements.size() == 0)
            TVrequirements.setText("");
        for (int i = 0; i < arraylistrequirements.size(); i++) {
            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);

            TextView newTextView1 = new TextView(this);
            newTextView1.setText(arraylistrequirements.get(i).getName());
            newTextView1.setTextSize(18);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setTextColor(Color.BLACK);
            newTextView1.setPadding(30, 30, 30, 10);

            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            TextView newTextView2 = new TextView(this);
            newTextView2.setTextColor(Color.BLACK);
            newTextView2.setText(arraylistrequirements.get(i).getNotes());
            newTextView2.setPadding(40, 10, 40, 30);

            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(newTextView2);


            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 0, 10, 30);

            Button button1 = new Button(this);
            SpannableString spanString = new SpannableString(getString(R.string.upload));
            spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
            button1.setText(spanString);
            button1.setTextSize(20);
            button1.setBackgroundColor(Color.rgb(33, 150, 243));
            button1.setTextColor(Color.WHITE);
            button1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_file_upload_black_24dp, 0, 0, 0);


            newTextViewfilename.setTextSize(18);
            newTextViewfilename.setTypeface(Typeface.DEFAULT_BOLD);
            newTextViewfilename.setTextColor(Color.BLACK);
            newTextViewfilename.setPadding(30, 30, 30, 10);

            linearLayouth.addView(newTextViewfilename);

            TextView TextViewnamefile = new TextView(this);
            idTextViewSelected = arraylistrequirements.get(i).getId();
            Log.i("id requ ","id  at = "+idTextViewSelected);

            TextViewnamefile.setId(idTextViewSelected);

            linearLayouth.addView(button1);
            linearLayouth.addView(TextViewnamefile);

            linearLayouth.setGravity(Gravity.LEFT);
            button1.setId(idTextViewSelected);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("enter","click bun");
                    idTextViewSelected = v.getId();
                    Log.i("id button", "id = " + idTextViewSelected);
                    new MaterialFilePicker()
                            .withActivity(SpecificSreviceActivity.this)
                            .withRequestCode(1000)
                            .withHiddenFiles(true)
                            .start();
                }
            });

            linearLayoutv.addView(linearLayouth, layoutParams);

            linearLayoutv.setBackgroundResource(R.drawable.shape_button);
            linearLayout_requirements.addView(linearLayoutv, layoutParams);

        }

    }


    public void drawAttachment() {
        if (arraylistAttachment.size() == 0)
            TVattachment.setText("");

        for (int i = 0; i < arraylistAttachment.size(); i++) {
            AttwhithFile attwhithFile = arraylistAttachment.get(i);

            LinearLayout linearLayouth = new LinearLayout(this);
            linearLayouth.setOrientation(LinearLayout.HORIZONTAL);

            TextView newTextView1 = new TextView(this);
            newTextView1.setText(attwhithFile.getName());
            newTextView1.setTextSize(18);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setTextColor(Color.BLACK);
            newTextView1.setPadding(30, 30, 30, 10);

            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);
            TextView newTextView2 = new TextView(this);
            newTextView2.setTextColor(Color.BLACK);
            newTextView2.setText(attwhithFile.getNotes());
            newTextView2.setPadding(40, 10, 40, 30);

            linearLayoutv.addView(newTextView1);
            linearLayoutv.addView(newTextView2);


            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams1.setMargins(10, 0, 10, 10);


            final Button button1 = new Button(this);
            SpannableString spanString = new SpannableString(getString(R.string.upload));
            spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
            button1.setText(spanString);
            button1.setTextSize(20);
            button1.setBackgroundColor(Color.rgb(33, 150, 243));
            button1.setTextColor(Color.WHITE);
            button1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_file_upload_black_24dp, 0, 0, 0);
            TextView TextViewnamefile = new TextView(this);
            idTextViewSelected = attwhithFile.getId();
            Log.i("id att ","id  at = "+idTextViewSelected);
            //TextViewnamefile.setId(idTextViewSelected);
            linearLayouth.addView(TextViewnamefile, layoutParams1);
            linearLayouth.addView(button1, layoutParams1);
            linearLayouth.setGravity(Gravity.LEFT);
            button1.setId(idTextViewSelected);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("enter","click bun");
                    idTextViewSelected = v.getId();
                    Log.i("id button", "id = " + idTextViewSelected);
                    new MaterialFilePicker()
                            .withActivity(SpecificSreviceActivity.this)
                            .withRequestCode(1000)
                            .withHiddenFiles(true)
                            .start();
                }
            });

            Button button2 = new Button(this);
            SpannableString spanString2 = new SpannableString(getString(R.string.download));
            spanString2.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
            button2.setText(spanString2);
            button2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_file_download_black_24dp, 0, 0, 0);
            button2.setTextSize(20);
            button2.setBackgroundColor(Color.rgb(255, 152, 0));
            button2.setTextColor(Color.WHITE);


            linearLayouth.addView(button2, layoutParams1);
            button2.setId(10000+idTextViewSelected);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idthousend = v.getId();
                    int id = idthousend - 10000;
                    for (int i = 0; i < arraylistAttachment.size(); i++) {
                        AttwhithFile attwhithFile = arraylistAttachment.get(i);
                        if(id == attwhithFile.getId()){
                            Log.i("find att in click" ," done ");
                            showimage(attwhithFile);
                            break;
                        }

                    }

                }
            });

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10, 0, 10, 30);

            linearLayoutv.addView(linearLayouth, layoutParams);
            linearLayoutv.setBackgroundResource(R.drawable.shape_button);
            linearLayout_attachment.addView(linearLayoutv, layoutParams);

        }

    }


    public void showimage(AttwhithFile attwhithFile) {

        try {

            if (attwhithFile.getImage().equals(true)) {
                Intent myIntent = new Intent(this, ShowImage.class);
                Bundle myBundle = new Bundle();
                myBundle.putInt("idfile", attwhithFile.getId());
                myBundle.putString("name", attwhithFile.getName());
                myBundle.putString("fileAtt", "fileAtt");


                myIntent.putExtras(myBundle);
                startActivity(myIntent);
            } else {

                R_loadfile(attwhithFile.getId());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            Log.i("Not filePath", "Not filePath" + filePath);
            GetFromDB.getFiles().add(new UpLoadFiles(filePath,idService,GetFromDB.getIdCitizen()));
            Log.i("id button", "id on onActivityResult is  " + idTextViewSelected);
            TextView  textView = findViewById(idTextViewSelected);
            String ss = filePath.substring(filePath.lastIndexOf("/")+1);
            textView.setText(ss);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 1001: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }


//    public byte[] getBytesFromBitmap(Bitmap bitmap) {
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        // bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
//        bitmap.compress(Bitmap.CompressFormat.PNG, 70, stream);
//        return stream.toByteArray();
//    }


    public void requesrService(View view) {
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String citizenNote = editText2.getText().toString();
        Log.i("Nooott = ", citizenNote);
        R_loadgetidMaxServCit();
        R_loadAplyService(citizenNote,idService,idMax);
        for (UpLoadFiles f :GetFromDB.getFiles()) {
            uploadFile(f.getPath(),f.getIdService(),idMax,GetFromDB.getIdCitizen());
        }


    }

    private void R_loadAplyService(String note, int idService, int idMax) {

        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<String> call = apiInterface.applyService(note,idService,GetFromDB.getIdCitizen(),idMax);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(" Message","success");

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });

    }

    private void R_loadgetidMaxServCit() {

        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<Integer> call = apiInterface.getidMaxServCit(GetFromDB.getIdCitizen());

        call.enqueue(new Callback<Integer>() {

            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.i(" Message", "success");
                 Integer id = response.body();
                 idMax = id+1;
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });
    }

//    private void R_loadtest() {
//
//        String path = "/sdcard/Download/profile_icon.png" ;
//        File file = new File(path);
//        try {
//            InputStream inputStream = new FileInputStream(file);
//            byte[] bytes = new byte[(int) file.length()];
//            FileInputStream fis = new FileInputStream(file);
//            fis.read(bytes); //read file into bytes[]
//            fis.close();
//            String s = Base64.encodeToString(bytes,Base64.DEFAULT);
//
//
//         APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
//         Call<String> call = apiInterface.test(s);
//         call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i(" Message", "success");
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.i("Error Message", t.getMessage());
//
//            }
//        });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void R_loadfile(int idAttTex) {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<AttFileTex> call = apiInterface.getfileAttTex(idAttTex);
        call.enqueue(new Callback<AttFileTex>() {
            @Override
            public void onResponse(Call<AttFileTex> call, Response<AttFileTex> response) {
                Log.i(" Message", "success");
                createFile(response.body());

            }

            @Override
            public void onFailure(Call<AttFileTex> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });

    }

    public void createFile(AttFileTex attFileTex) {
        try {
            String path = "/sdcard/Download/" + attFileTex.getName();
            File newFile = new File(path);
            newFile.createNewFile();
            newFile.setWritable(true);
            byte[] bytes = attFileTex.getS().getBytes();
            FileOutputStream fOut = new FileOutputStream(newFile);
            fOut.write(bytes);
            fOut.close();
            Toast.makeText(this, getString(R.string.download) + "  " + attFileTex.getName(), Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//
//    private void updateProfile() {
//        String path = "/sdcard/Download/profile_icon.png" ;
//        File file = new File(path);
//
////        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
////
////        MultipartBody.Part body = MultipartBody.Part.createFormData("image", "fileName()", requestFile);
//
//        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
//        Call<ResponseBody> call = apiInterface.updateProfile(file);
//
//        call.enqueue(new Callback<ResponseBody>() {
//
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.i("success Message", "success");
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.i("Error Message", t.getMessage());
//
//            }
//        });
//
//    }
//

    private void uploadFile(String mediaPath , int idService , int idMax,int idCitizin) {


        // Map is used to multipart the file using okhttp3.RequestBody
        //String mediaPath = "/sdcard/Download/profile_icon.png" ;

        File file = new File(mediaPath);

        // Parsing any Media type file
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        APIInterface getResponse = RetrofitClient.getClient().create(APIInterface.class);
        Call<ServerResponse> call = getResponse.uploadFile(fileToUpload,idService,idCitizin,idMax);

        Log.i(" uploadFile", "enter uploadFile");

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse = response.body();
                Log.i(" uploadFile onResponse", "enter uploadFile onResponse" );
                if (serverResponse != null) {
                    if (serverResponse.getSuccess()) {
                        Log.v("Response", serverResponse.toString());
                    } else {
                        Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    assert serverResponse != null;
                    Log.v("Response", serverResponse.toString());
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.i(" uploadFile onFailure", t.getMessage() );

            }
        });
    }


}

