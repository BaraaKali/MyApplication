package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MyJavaClass.GetFromDB;
import com.example.myapplication.models.Citizen;
import com.example.myapplication.network.APIInterface;
import com.example.myapplication.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText editText_user_name,editText_password;

    Vibrator vib;
    Animation animShake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          editText_user_name  = (EditText)findViewById(R.id.editText_user_name);
          editText_password  = (EditText)findViewById(R.id.editText_password);

        animShake = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
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
            editText_user_name.setAnimation(animShake);
            editText_user_name.startAnimation(animShake);
            vib.vibrate(120);
            editText_password.setAnimation(animShake);
            editText_password.startAnimation(animShake);
            vib.vibrate(120);
            Toast.makeText(getApplicationContext(), R.string.wrong_sign_in,Toast.LENGTH_SHORT).show();
        }
    }

    public  boolean checkUsers(String username, String password) {
        Log.d("MyApppppp", password);
        if ((password.equals(editText_user_name.getText().toString())) && username.equals(editText_password.getText().toString())) {
            return true;
        }
        return false;

    }

    private void R_loadCitizen() {
        APIInterface apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<Citizen> call = apiInterface.getProfileCall(GetFromDB.getUsername(),GetFromDB.getPassWord());
        call.enqueue(new Callback<Citizen>() {

            @Override
            public void onResponse(Call<Citizen> call, Response<Citizen> response) {
                Citizen citizen = response.body();
                if(citizen != null)
                checkUsers(citizen.getAccount().getUserName(),citizen.getAccount().getPassword());
            }

            @Override
            public void onFailure(Call<Citizen> call, Throwable t) {
                Log.i("Error Message", t.getMessage());

            }
        });


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
