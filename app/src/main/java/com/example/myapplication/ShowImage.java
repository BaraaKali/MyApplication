package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;

public class ShowImage extends AppCompatActivity {

    Bitmap bitmap;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        Bundle bundle = getIntent().getExtras();
        int idfile = bundle.getInt("idfile");
        String name = bundle.getString("name");
        setTitle(name);
        imageView = (ImageView) findViewById(R.id.imageviewTest);
        String url = "http://10.0.2.2:8080/mmapi/fileAtt?idAtt="+idfile;
        new Getimage(imageView).execute(url);


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


    public void downloadImage(View view) {

    }


}


