package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ShowImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        Bundle bundle = getIntent().getExtras();
        String path = bundle.getString("path");



        try {


//            Service service = GetFromDB.getSelectedService(12);
//            Log.i("tag3", "" + service.getAttwhithFile().get(1).getNameFile());
//            String s = service.getAttwhithFile().get(1).getOutputfinal();
//            byte[] bytes = s.getBytes();
//
//
//
//            File newFile = new File("/sdcard/Download/profile_icon.png");
//            newFile.createNewFile();
//
//            FileOutputStream fOut = new FileOutputStream("profile_icon.png");
//            fOut.write(bytes);
//            fOut.close();
//            fOut.close();

           // File imgFile = new File("/sdcard/Download/profile_icon.png");

            File imgFile = new File(path);

            if (imgFile.exists()) {

                Log.i("tag3", "" + "in if exists");
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);
                Log.i("tag4", "" + myImage.getId());
                myImage.setImageBitmap(myBitmap);

            }

        } catch (Exception e) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        }


    }

}
