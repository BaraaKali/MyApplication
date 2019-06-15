package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.Citizen;
import com.example.myapplication.models.CitizenRequest;
import com.example.myapplication.models.MunInfo;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyInformation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button selectImage;
    ImageView imageView;
    private int REQUEST_CODE = 1;

    Citizen citizen = new Citizen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);

        R_loadProfile();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_information);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_my_information);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.usernameTitle);
        navUsername.setText(GetFromDB.getUsernameTitle());

        selectImage = (Button) findViewById(R.id.buttont);
        imageView = (ImageView) findViewById(R.id.imageViewt);
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "select Picture"), REQUEST_CODE);
            }
        });

    }


    @Override
    protected void onActivityResult(int reqco, int resut, Intent data) {
        super.onActivityResult(reqco, resut, data);

        if (reqco == REQUEST_CODE && resut == RESULT_OK && data != null && data.getData() != null) {
            Log.d("MyApp", "I am here");
            Uri uri = data.getData();

            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void R_loadProfile() {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<Citizen> call = apiInterface.getProfileCall(GetFromDB.getUsername(),GetFromDB.getPassWord());
        call.enqueue(new Callback<Citizen>() {

            @Override
            public void onResponse(Call<Citizen> call, Response<Citizen> response) {
                citizen = response.body();
                fillTextProfileInfo();
            }

            @Override
            public void onFailure(Call<Citizen> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });


    }

    private void fillTextProfileInfo() {

        TextView TextView_first_name = (TextView) findViewById(R.id.TextView_first_name);
        TextView_first_name.setText(citizen.getFirstName());

        TextView TextView_father_name = (TextView) findViewById(R.id.TextView_father_name);
        TextView_father_name.setText(citizen.getFatherName());

        TextView TextView_grand_father_name = (TextView) findViewById(R.id.TextView_grand_father_name);
        TextView_grand_father_name.setText(citizen.getGrandFatherName());

        TextView TextView_family_name = (TextView) findViewById(R.id.TextView_family_name);
        TextView_family_name.setText(citizen.getLastName());

        EditText editText_number_family_member = (EditText) findViewById(R.id.editText_number_family_member);
        editText_number_family_member.setText("" + citizen.getFamilyMember());

        EditText editText_id_number = (EditText) findViewById(R.id.editText_id_number);
        editText_id_number.setText(citizen.getIdCard());

        EditText editText_place_birth = (EditText) findViewById(R.id.editText_place_birth);
        editText_place_birth.setText(citizen.getPlaceOfBirth());

        EditText editText_passport_number = (EditText) findViewById(R.id.editText_passport_number);
        editText_passport_number.setText(citizen.getPassportNumber());

        EditText editText_telephone_number = (EditText) findViewById(R.id.editText_telephone_number);
        editText_telephone_number.setText(citizen.getTelephone());

        EditText editText_mobile_number = (EditText) findViewById(R.id.editText_mobile_number);
        editText_mobile_number.setText(citizen.getMobile());

        EditText editText_email = (EditText) findViewById(R.id.editText_email);
        editText_email.setText(citizen.getEmail());

        EditText editText_fax = (EditText) findViewById(R.id.editText_fax);
        editText_fax.setText(citizen.getFax());


        EditText editText_work = (EditText) findViewById(R.id.editText_work);
        editText_work.setText(citizen.getCitizenJob());

        EditText editText_address = (EditText) findViewById(R.id.editText_address);
        editText_address.setText(citizen.getAddress());

        EditText editText_street = (EditText) findViewById(R.id.editText_street);
        editText_street.setText(citizen.getStreet());

        EditText editText_region = (EditText) findViewById(R.id.editText_region);
        editText_region.setText(citizen.getRegion());

        EditText editText_zone = (EditText) findViewById(R.id.editText_zone);
        editText_zone.setText(citizen.getQuarter());

        EditText editText_New_password = (EditText) findViewById(R.id.editText_New_password);
        editText_New_password.setText(citizen.getAccount().getPassword());


        TextView TextView_New_username = (TextView) findViewById(R.id.TextView_New_username);
        TextView_New_username.setText(citizen.getAccount().getUserName());

        RadioButton female = (RadioButton) findViewById(R.id.female);
        RadioButton male = (RadioButton) findViewById(R.id.male);

        if (citizen.getGender().equals("F")) {
            female.setChecked(true);
            male.setChecked(false);

        } else {
            female.setChecked(false);
            male.setChecked(true);
        }

        TextView textView_date_birth = (TextView) findViewById(R.id.textView_date_birth);
        textView_date_birth.setText(citizen.getBirthday());


    }


    private void getTextProfileInfo() {

        TextView TextView_first_name = (TextView) findViewById(R.id.TextView_first_name);
        citizen.setFirstName(TextView_first_name.getText().toString());

        TextView TextView_father_name = (TextView) findViewById(R.id.TextView_father_name);
        citizen.setFatherName(TextView_father_name.getText().toString());

        TextView TextView_grand_father_name = (TextView) findViewById(R.id.TextView_grand_father_name);
        citizen.setGrandFatherName(TextView_grand_father_name.getText().toString());

        TextView TextView_family_name = (TextView) findViewById(R.id.TextView_family_name);
        citizen.setLastName(TextView_family_name.getText().toString());

        EditText editText_number_family_member = (EditText) findViewById(R.id.editText_number_family_member);
        citizen.setFamilyMember(Integer.parseInt(editText_number_family_member.getText().toString()));

        EditText editText_id_number = (EditText) findViewById(R.id.editText_id_number);
        citizen.setIdCard(editText_id_number.getText().toString());

        EditText editText_place_birth = (EditText) findViewById(R.id.editText_place_birth);
        citizen.setPlaceOfBirth(editText_place_birth.getText().toString());

        EditText editText_passport_number = (EditText) findViewById(R.id.editText_passport_number);
        citizen.setPassportNumber(editText_passport_number.getText().toString());

        EditText editText_telephone_number = (EditText) findViewById(R.id.editText_telephone_number);
        citizen.setTelephone(editText_telephone_number.getText().toString());

        EditText editText_mobile_number = (EditText) findViewById(R.id.editText_mobile_number);
        citizen.setMobile(editText_mobile_number.getText().toString());

        EditText editText_email = (EditText) findViewById(R.id.editText_email);
        citizen.setEmail(editText_email.getText().toString());

        EditText editText_fax = (EditText) findViewById(R.id.editText_fax);
        citizen.setFax(editText_fax.getText().toString());


        EditText editText_work = (EditText) findViewById(R.id.editText_work);
        citizen.setCitizenJob(editText_work.getText().toString());

        EditText editText_address = (EditText) findViewById(R.id.editText_address);
        citizen.setAddress(editText_address.getText().toString());

        EditText editText_street = (EditText) findViewById(R.id.editText_street);
        citizen.setStreet(editText_street.getText().toString());

        EditText editText_region = (EditText) findViewById(R.id.editText_region);
        citizen.setRegion(editText_region.getText().toString());

        EditText editText_zone = (EditText) findViewById(R.id.editText_zone);
        citizen.setQuarter(editText_zone.getText().toString());



        TextView TextView_New_username = (TextView) findViewById(R.id.TextView_New_username);
        TextView_New_username.setText(citizen.getAccount().getUserName());

        RadioButton female = (RadioButton) findViewById(R.id.female);
        RadioButton male = (RadioButton) findViewById(R.id.male);


        if (female.isSelected()) {
            citizen.setGender("F");

        } else {
            citizen.setGender("M");
        }


        TextView textView_date_birth = (TextView) findViewById(R.id.textView_date_birth);
        textView_date_birth.setText(citizen.getBirthday());


    }


    private void R_loadUpdateCitizen() {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);

        Call<String> call = apiInterface.updateCitizen(citizen);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(" Message","success");
                afterupdate();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_information);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_my_information);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void pickDate(View view) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        Dialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                processDatePickerResult(year, month, dayOfMonth);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    public void processDatePickerResult(int year, int month, int day) {
        // The month integer returned by the date picker starts counting at 0
        // for January, so you need to add 1 to show months starting at 1.
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        ((TextView) findViewById(R.id.textView_date_birth)).setText(dateMessage);
    }

    public void updateInfo(View view) {
        getTextProfileInfo();
        R_loadUpdateCitizen();
    }
    public void afterupdate() {
        Toast.makeText(getApplicationContext(), getString(R.string.edit_done), Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(this, MyInformation.class);
        startActivity(myIntent);
    }
}

