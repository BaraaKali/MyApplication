package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ShowImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        try {

            String s = "U0VMRUNUICogRlJPTSBvc3MuZGVjaXNpb25zX2RlcGFydG1lbnQgYXMgZGQgaW5uZXIgam9pbiAoU0VMRUNUIERlcF9JRCAsIG1pbihPcmRlcl9EZXBhcnRtYW50KSBhcyBtaW5kIEZST00gb3NzLmRlY2lzaW9uc19kZXBhcnRtZW50IHdoZXJlIFN0YXR1cyA9ICdub3Rkb25lJyBncm91cCBieSAgRGVwX0lEICkgYXMgbWRkIG9uIGRkLkRlcF9JRCA9IG1kZC5EZXBfSUQgYW5kIGRkLk9yZGVyX0RlcGFydG1hbnQgPSBtaW5kOw==";

            File newFile = new File("/sdcard/Download/quere.txt");
            newFile.createNewFile();

            FileOutputStream fOut = new FileOutputStream(newFile);
            OutputStreamWriter myOutWriter =new OutputStreamWriter(fOut);
            myOutWriter.write(s);
            myOutWriter.close();
            fOut.close();

            File imgFile = new File("/sdcard/Download/quere.txt");
            if (imgFile.exists()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                ImageView myImage = (ImageView) findViewById(R.id.imageviewTest);
                Log.i("tag3", "" + myImage.getId());
                myImage.setImageBitmap(myBitmap);
            }

        } catch (Exception e) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        }


    }

}
