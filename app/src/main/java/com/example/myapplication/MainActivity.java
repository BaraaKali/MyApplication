package com.example.myapplication;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;

public class MainActivity extends AppCompatActivity {
    EditText editText_user_name,editText_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          editText_user_name  = (EditText)findViewById(R.id.editText_user_name);
          editText_password  = (EditText)findViewById(R.id.editText_password);
    }

    public void singUp(View view) {

          Intent myIntent = new Intent(this, SignUpActivity.class);
            startActivity(myIntent);

    }

    public void singIn(View view) {
        if(GetFromDB.checkUsers(editText_user_name.getText().toString(),editText_password.getText().toString())) {
            Intent myIntent = new Intent(this, HomeActivity.class);
            startActivity(myIntent);
        }else{
            Toast.makeText(getApplicationContext(), R.string.wrong_sign_in,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }
}
