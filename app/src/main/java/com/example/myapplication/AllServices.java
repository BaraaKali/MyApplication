package com.example.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.Departmant;
import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.MyJavaClass.Service;

import java.util.ArrayList;






import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

//import com.androidtutorialshub.expandablelistview.adapter.ExpandableListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class AllServices extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    ArrayList<Departmant> arrayListDepartmant ;
    TableLayout tableLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);
        arrayListDepartmant = GetFromDB.getDepartmants();
        tableLayout = (TableLayout) findViewById(R.id.table_all_Depardments);
        drawDepartments();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_all_service);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_all_services);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void drawDepartments(){

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 0, 20, 0);



        TableRow tableRow = new TableRow(this);
        for (int i = 0 ; i< arrayListDepartmant.size() ; i++){
            final Departmant d = arrayListDepartmant.get(i);
            if( (i%3) == 0 ){
                tableLayout.addView(tableRow);
                tableRow = new TableRow(this);

            }

            LinearLayout linearLayoutV = new LinearLayout(this);
            linearLayoutV.setOrientation(LinearLayout.VERTICAL);

            TextView textViewicon = new TextView(this);

            if(d.getImage().equals("fa-drafting-compass")){
                textViewicon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fadraftingcompass, 0, 0);
                textViewicon.setBackgroundResource(R.drawable.shape_blue);
            }else if(d.getImage().equals("fa-dollar-sign")){
                textViewicon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fadollarsign, 0, 0);
                textViewicon.setBackgroundResource(R.drawable.shape_red);
            }else if(d.getImage().equals("fa-users")) {
                textViewicon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fausers, 0, 0);
                textViewicon.setBackgroundResource(R.drawable.shape_green);

            }else if(d.getImage().equals("fa-eye")) {
                textViewicon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.faeye, 0, 0);
                textViewicon.setBackgroundResource(R.drawable.shape_blue2);

            }else {
                textViewicon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fafire, 0, 0);
                textViewicon.setBackgroundResource(R.drawable.shape_orange);
            }


            textViewicon.setPadding(0,25,0,0);

            TextView textView = new TextView(this);
            textView.setText(d.getName());
            textView.setTypeface(null, Typeface.BOLD);

            textView.setBackgroundResource(R.drawable.shape_button);

            textView.setPadding(20,20,20,20);
            linearLayoutV.addView(textViewicon,layoutParams);

            linearLayoutV.addView(textView,layoutParams);

            linearLayoutV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToPageServicesInThisDepartment(d.getId(), d.getName());
                }
            });

            tableRow.addView(linearLayoutV);
        }
        tableLayout.addView(tableRow);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_all_service);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_all_service);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void goToPageServicesInThisDepartment(int idDepartment , String nameDepartment) {
        Intent myIntent = new Intent(this, ServicesInDepartment.class);
        Bundle myBundle = new Bundle();
        myBundle.putInt("idDepartment", idDepartment);
        myBundle.putString("nameDepartment", nameDepartment);

        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }



}
