package com.example.myapplication;

import android.app.ActionBar;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.SearchView;
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

    ListView ListView_all_services;
    ArrayList<Service> arraylistAllServices;
    ArrayAdapter arrayAdapter;





    private ExpandableListView expandableListView;

    private ExpandableListViewAdapter expandableListViewAdapter;

    private List<String> listDataGroup;

    private HashMap<String, List<String>> listDataChild;
    private EditText search;
    ArrayList<Departmant> arrayListDepartmant ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_services);
        ListView_all_services = (ListView) findViewById(R.id.ListView_all_services);
        arraylistAllServices = new ArrayList<>();
        arraylistAllServices = GetFromDB.getAllServices();






        arrayListDepartmant = GetFromDB.getDepartmants();

        // initializing the views
        initViews();

        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();

        // preparing list data
        initListData();





//        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylistAllServices);
//        ListView_all_services.setAdapter(arrayAdapter);
//
//        ListView_all_services.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Service select_service = (Service) ListView_all_services.getItemAtPosition(position);
//
//                Toast.makeText(getApplicationContext(), select_service.getName(), Toast.LENGTH_SHORT).show();
//                goToPageThisService(select_service.getId());
//
//            }
//        });
//
//        SearchView searchView = (SearchView) findViewById(R.id.SearchView_filter);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                arrayAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });

                SearchView searchView = (SearchView) findViewById(R.id.SearchView_filter);
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                expandableListView.setFilterText(newText);
                //expandableListView.refreshDrawableState();
                initListData();
                return false;
            }
        });





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

    public void goToPageThisService(int idService) {
        Intent myIntent = new Intent(this, SpecificSreviceActivity.class);
        Bundle myBundle = new Bundle();
        myBundle.putInt("idService", idService);
        myIntent.putExtras(myBundle);
        startActivity(myIntent);
    }





















    /**
     * method to initialize the views
     */
    private void initViews() {

        expandableListView = findViewById(R.id.ListView_all_services);

    }

    /**
     * method to initialize the listeners
     */
    private void initListeners() {

        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataGroup.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataGroup.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
                Departmant d = arrayListDepartmant.get(groupPosition);
                Service select_service = (Service) d.getServices().get(childPosition);
                goToPageThisService(select_service.getId());
                return false;
            }
        });

        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
//                        Toast.LENGTH_SHORT).show();
            }
        });

        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
//                        Toast.LENGTH_SHORT).show();

            }
        });

    }

    /**
     * method to initialize the objects
     */
    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child
        listDataChild = new HashMap<>();

        // initializing the adapter object
        expandableListViewAdapter = new ExpandableListViewAdapter(this, listDataGroup, listDataChild);

        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);

    }

    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {
          int i = 0 ;
        for (Departmant departmant:arrayListDepartmant) {

            listDataGroup.add(departmant.getName());

            List<String> ChildList = new ArrayList<>();

            for (Service service:departmant.getServices()) {
                ChildList.add(service.getName());
            }
            listDataChild.put(listDataGroup.get(i), ChildList);
            i++;
        }
        // Adding group data
//        listDataGroup.add(getString(R.string.text_alcohol));
//        listDataGroup.add(getString(R.string.text_coffee));
//        listDataGroup.add(getString(R.string.text_pasta));
//        listDataGroup.add(getString(R.string.text_cold_drinks));

        // array of strings
        //String[] array;

        // list of alcohol

//        List<String> alcoholList = new ArrayList<>();
//        array = getResources().getStringArray(R.array.string_array_alcohol);
//        for (String item : array) {
//            alcoholList.add(item);
//        }

//        // list of coffee
//        List<String> coffeeList = new ArrayList<>();
//        array = getResources().getStringArray(R.array.string_array_coffee);
//        for (String item : array) {
//            coffeeList.add(item);
//        }
//
//        // list of pasta
//        List<String> pastaList = new ArrayList<>();
//        array = getResources().getStringArray(R.array.string_array_pasta);
//        for (String item : array) {
//            pastaList.add(item);
//        }
//
//        // list of cold drinks
//        List<String> coldDrinkList = new ArrayList<>();
//        array = getResources().getStringArray(R.array.string_array_cold_drinks);
//        for (String item : array) {
//            coldDrinkList.add(item);
//        }

        // Adding child data
//        listDataChild.put(listDataGroup.get(0), alcoholList);
//        listDataChild.put(listDataGroup.get(1), coffeeList);
//        listDataChild.put(listDataGroup.get(2), pastaList);
//        listDataChild.put(listDataGroup.get(3), coldDrinkList);

        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();
    }

}
