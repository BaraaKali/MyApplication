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
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.AttFileTex;
import com.example.myapplication.models.AttachmentServiceEmployee;
import com.example.myapplication.models.AttwhithFile;
import com.example.myapplication.models.DecisionSection;
import com.example.myapplication.models.Section;
import com.example.myapplication.models.StepsAndDecsions;
import com.example.myapplication.models.StepsAndDecsionsJob;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;
import com.nbsp.materialfilepicker.MaterialFilePicker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PathInDep extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    List<StepsAndDecsions> stepsAndDecsions ;
    private LinearLayout linearLayout;
    StepsAndDecsions step = new StepsAndDecsions();
    public int idTextViewSelected = 0;


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

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.usernameTitle);
        navUsername.setText(GetFromDB.getUsernameTitle());

    }

    private void draw(StepsAndDecsions step) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 30, 30, 30);

        for (int i = 0 ; i < step.getSections().size() ; i++) {
            final DecisionSection section = step.getSections().get(i);

            LinearLayout linearLayoutv = new LinearLayout(this);
            linearLayoutv.setOrientation(LinearLayout.VERTICAL);

            TextView newTextView1 = new TextView(this);
            newTextView1.setText(section.getSection().getName());
            newTextView1.setTextSize(24);
            newTextView1.setTypeface(Typeface.DEFAULT_BOLD);
            newTextView1.setTextColor(Color.rgb(255,152,0));
            newTextView1.setGravity(Gravity.CENTER);
            newTextView1.setPadding(30,30,30,5);


            linearLayout.addView(newTextView1);

            for (int j = 0 ; j < section.getJob().size(); j++) {

                LinearLayout linearLayoutv1 = new LinearLayout(this);
                linearLayoutv1.setOrientation(LinearLayout.VERTICAL);
                linearLayoutv1.setBackgroundResource(R.drawable.shape_button);

                final StepsAndDecsionsJob job = section.getJob().get(j);

                TextView newTextView2 = new TextView(this);
                newTextView2.setText(job.getJobPath().getName()+" : ");
                newTextView2.setTextSize(18);
                newTextView2.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView2.setTextColor(Color.rgb(33,150,243));
                newTextView2.setPadding(30,30,30,5);

                TextView newTextView3 = new TextView(this);
                newTextView3.setText(job.getDecisionsJob().getEmployee().getEmpName());
                newTextView3.setTextSize(18);
                newTextView3.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView3.setTextColor(Color.BLACK);
                newTextView3.setPadding(30,30,30,5);
                LinearLayout linearLayouth1 = new LinearLayout(this);
                linearLayouth1.setOrientation(LinearLayout.HORIZONTAL);
                linearLayouth1.addView(newTextView2);
                linearLayouth1.addView(newTextView3);
                linearLayoutv1.addView(linearLayouth1);

                TextView newTextView4 = new TextView(this);
                newTextView4.setText(R.string.emp_com);
                newTextView4.setTextSize(18);
                newTextView4.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView4.setTextColor(Color.rgb(33,150,243));
                newTextView4.setPadding(30,30,30,5);

                TextView newTextView5 = new TextView(this);
                newTextView5.setText(job.getDecisionsJob().getExternalMessage());
                newTextView5.setTextSize(18);
                newTextView5.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView5.setTextColor(Color.BLACK);
                newTextView5.setPadding(30,30,30,5);
                LinearLayout linearLayouth2v = new LinearLayout(this);
                linearLayouth2v.setOrientation(LinearLayout.VERTICAL);
                linearLayouth2v.addView(newTextView4);
                linearLayouth2v.addView(newTextView5);
                linearLayoutv1.addView(linearLayouth2v);

                TextView newTextView6 = new TextView(this);
                newTextView6.setText(R.string.emp_cost);
                newTextView6.setTextSize(18);
                newTextView6.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView6.setTextColor(Color.rgb(33,150,243));
                newTextView6.setPadding(30,30,30,5);

                TextView newTextView7 = new TextView(this);
                newTextView7.setText(""+job.getDecisionsJob().getCost());
                newTextView7.setTextSize(18);
                newTextView7.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView7.setTextColor(Color.BLACK);
                newTextView7.setPadding(30,30,30,5);
                LinearLayout linearLayouth3 = new LinearLayout(this);
                linearLayouth3.setOrientation(LinearLayout.HORIZONTAL);
                linearLayouth3.addView(newTextView6);
                linearLayouth3.addView(newTextView7);
                linearLayoutv1.addView(linearLayouth3);

                TextView newTextView8 = new TextView(this);
                newTextView8.setText(R.string.emp_att);
                newTextView8.setTextSize(18);
                newTextView8.setTypeface(Typeface.DEFAULT_BOLD);
                newTextView8.setTextColor(Color.rgb(33,150,243));
                newTextView8.setPadding(30,30,30,5);


                LinearLayout linearLayouth4 = new LinearLayout(this);
                linearLayouth4.setOrientation(LinearLayout.VERTICAL);
                linearLayouth4.addView(newTextView8);


                for (int k = 0; k < job.getAttachmentServiceEmployee().size(); k++) {
                    final AttachmentServiceEmployee ase = job.getAttachmentServiceEmployee().get(k);

                    TextView TextView1 = new TextView(this);
                    TextView1.setText(ase.getFilename());
                    TextView1.setTextSize(18);
                    TextView1.setTypeface(Typeface.DEFAULT_BOLD);
                    TextView1.setTextColor(Color.BLACK);
                    TextView1.setPadding(30, 30, 30, 10);


                    Button button2 = new Button(this);
                    SpannableString spanString2 = new SpannableString(getString(R.string.download));
                    spanString2.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString2.length(), 0);
                    button2.setText(spanString2);
                    button2.setTextSize(20);
                    button2.setBackgroundColor(Color.rgb(33, 150, 243));
                    button2.setTextColor(Color.WHITE);

                    button2.setId(10000+idTextViewSelected);
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i("find att in click" ," on ");
                            showimage(ase);

                        }
                    });

                    linearLayouth4.addView(TextView1);
                    linearLayouth4.addView(button2);

                }

                linearLayoutv1.addView(linearLayouth4);
                linearLayoutv.addView(linearLayoutv1,layoutParams);

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
        } else if (id == R.id.nav_my_attachment) {
            startActivity(new Intent(this, MyAttachment.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_show_service_path);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void showimage( AttachmentServiceEmployee ase ) {
            Log.i("sssss","sssss");
        try {

            if (ase.getImage().equals(true)) {
                Intent myIntent = new Intent(this, ShowImage.class);
                Bundle myBundle = new Bundle();
                myBundle.putInt("idfile", ase.getAttachmentServiceEmployeeID());
                myBundle.putString("name", ase.getFilename());
                myBundle.putString("fileAtt", "fileAttEmp");

                myIntent.putExtras(myBundle);
                startActivity(myIntent);
            } else {

                R_loadfile(ase.getAttachmentServiceEmployeeID());

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    private void R_loadfile(int idAttTex) {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<AttFileTex> call = apiInterface.getfileAttTexE(idAttTex);
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

}



