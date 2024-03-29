package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.AttachmentArchiveCitizen;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class specificArchive extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Bitmap bitmap;
    LinearLayout linearLayout;
    ImageView imageView;
    String namefile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_archive);

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        String name = bundle.getString("name");

        linearLayout = (LinearLayout) findViewById(R.id.LinerLayout_specific_attachment);
        drawthisAttachment(id);

        setTitle(name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_specific_archive);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_specific_archive);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.usernameTitle);
        navUsername.setText(GetFromDB.getUsernameTitle());

    }

    private void drawthisAttachment(int id) {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(35, 0, 35, 35);

        List<AttachmentArchiveCitizen> attachmentsArchiveCitizen = GetFromDB.getAttachmentsArchiveCitizen();

        for (AttachmentArchiveCitizen archivesCitizen : attachmentsArchiveCitizen) {
            if(id == archivesCitizen.getServiceAttachmentNameID()){

                LinearLayout linearLayouth = new LinearLayout(this);
                linearLayouth.setOrientation(LinearLayout.VERTICAL);
                namefile = archivesCitizen.getNameFile();
                TextView textView = new TextView(this);
                textView.setText(archivesCitizen.getNameFile());
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(16);
                textView.setGravity(Gravity.CENTER);
                textView.setPadding(0,20,0,20);




                String [] split = (archivesCitizen.getNameFile()).split("\\.");
                if(split[1].equals("png") || split[1].equals("jpg") ){
                    imageView = new ImageView(this);
                    String url = "http://10.0.2.2:8080/mmapi/fileAttCit?idAtt="+archivesCitizen.getAttaArchiveCID();
                    new Getimage(imageView).execute(url);
                    linearLayouth.addView(imageView);

                }

                Button button = (Button) new Button (this);
                button.setText(R.string.download);
                button.setTextSize(20);
                button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_file_download_black_24dp, 0, R.drawable.ic_file_download_black_24dp, 0);
                button.setTypeface(Typeface.DEFAULT_BOLD);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        downloadImageArch(imageView,namefile);
                    }
                });



                linearLayouth.setBackgroundResource(R.drawable.shape_button);
                linearLayouth.addView(textView);
                linearLayouth.addView(button);
                linearLayout.addView(linearLayouth,layoutParams);


            }
        }
        TextView T = (TextView) new TextView(this);
        T.setTextSize(60);
        linearLayout.addView(T,layoutParams);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_specific_archive);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_specific_archive);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public class Getimage extends AsyncTask<String, Void, Bitmap> {
        ImageView imv;

        public Getimage(ImageView imv) {
            this.imv = imv;
        }


        @Override
        protected Bitmap doInBackground(String... strings) {
            String urld = strings[0];
            bitmap = null;
            try {

                InputStream str = new java.net.URL(urld).openStream();
                bitmap = BitmapFactory.decodeStream(str);
//st


            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap){

            super.onPostExecute(bitmap);
            imv.setImageBitmap(bitmap);
            //sp

        }
    }


    public void downloadImageArch(ImageView imageViewn2, String filename) {

        String [] split = (filename).split("\\.");

        try {
            String path = "/sdcard/Download/"+filename;
            File newFile = new File(path);
            newFile.createNewFile();
            newFile.setWritable(true);

            Bitmap bm = ((BitmapDrawable)imageViewn2.getDrawable()).getBitmap();
            byte[] bytes = getBytesFromBitmap(bm,split[1]);

            FileOutputStream fOut = new FileOutputStream(newFile);
            fOut.write(bytes);
            fOut.close();
            Toast.makeText(this, getString(R.string.download) + "  " + filename, Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public byte[] getBytesFromBitmap(Bitmap bitmap, String type) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        if (type.equals("JPEG")){
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
         }else if (type.equals("PNG")) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 70, stream);
        }else{

        }

        return stream.toByteArray();
    }

}

