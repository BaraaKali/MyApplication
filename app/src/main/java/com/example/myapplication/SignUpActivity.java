package com.example.myapplication;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import android.support.design.widget.TextInputLayout;

import com.example.myapplication.MyJavaClass.MyCitizen;


public class SignUpActivity extends AppCompatActivity {

    TextInputLayout TextInputLayoutEmail, TextInputLayoutFirstName,
                    TextInputLayoutFatherName, TextInputLayoutGrandFatherName,
                    TextInputLayoutFamilyName, TextInputLayoutIdNumber,
                    TextInputLayoutUserName, TextInputLayoutPassword;

    EditText EditTextEmail, EditTextFirstName,
             EditTextFatherName, EditTextGrandFatherName,
             EditTextFamilyName, EditTextIdNumber,
             EditTextUserName, EditTextPassword;

    Button ButtonSubmit;


    Vibrator vib;
    Animation animShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        TextInputLayoutEmail = (TextInputLayout) findViewById(R.id.text_input_layout_email);
        TextInputLayoutFirstName = (TextInputLayout) findViewById(R.id.text_input_layout_first_name);
        TextInputLayoutFatherName = (TextInputLayout) findViewById(R.id.text_input_layout_father_name);
        TextInputLayoutGrandFatherName = (TextInputLayout) findViewById(R.id.text_input_layout_grand_father_name);
        TextInputLayoutFamilyName = (TextInputLayout) findViewById(R.id.text_input_layout_family_name);
        TextInputLayoutIdNumber = (TextInputLayout) findViewById(R.id.text_input_layout_id_number);
        TextInputLayoutUserName = (TextInputLayout) findViewById(R.id.text_input_layout_username);
        TextInputLayoutPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);

        EditTextEmail = (EditText) findViewById(R.id.editText_email);
        EditTextFirstName = (EditText) findViewById(R.id.editText_first_name);
        EditTextFatherName = (EditText) findViewById(R.id.editText_father_name);
        EditTextGrandFatherName = (EditText) findViewById(R.id.editText_grand_father_name);
        EditTextFamilyName = (EditText) findViewById(R.id.editText_family_name);
        EditTextIdNumber = (EditText) findViewById(R.id.editText_id_number);
        EditTextUserName = (EditText) findViewById(R.id.editText_New_username);
        EditTextPassword = (EditText) findViewById(R.id.editText_New_password);

        ButtonSubmit = (Button) findViewById(R.id.button_submit);
        if (ButtonSubmit != null) {
            ButtonSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    submitForm();
                }
            });
        }

        animShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
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

    private void submitForm() {
        if (!checkFirstName()) {
            TextInputLayoutFirstName.setAnimation(animShake);
            TextInputLayoutFirstName.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkFatherName()) {
            TextInputLayoutFatherName.setAnimation(animShake);
            TextInputLayoutFatherName.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkGrandFatherName()) {
            TextInputLayoutGrandFatherName.setAnimation(animShake);
            TextInputLayoutGrandFatherName.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkFamilyName()) {
            TextInputLayoutFamilyName.setAnimation(animShake);
            TextInputLayoutFamilyName.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkIdNumber()) {
            TextInputLayoutIdNumber.setAnimation(animShake);
            TextInputLayoutIdNumber.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkEmail()) {
            EditTextEmail.setAnimation(animShake);
            EditTextEmail.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkUserName()) {
            EditTextUserName.setAnimation(animShake);
            EditTextUserName.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkPassword()) {
            EditTextPassword.setAnimation(animShake);
            EditTextPassword.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        TextInputLayoutEmail.setErrorEnabled(false);
        addNewUser();
        Toast.makeText(getApplicationContext(), getString(R.string.success_meg), Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(this, MyInformation.class);
        startActivity(myIntent);
    }

    public void addNewUser() {
        MyCitizen newcitizen = new MyCitizen();

        newcitizen.setFirstName(EditTextFirstName.getText().toString());
        newcitizen.setFatherName(EditTextFatherName.getText().toString());
        newcitizen.setGrandFatherName(EditTextGrandFatherName.getText().toString());
        newcitizen.setFamilyName(EditTextFamilyName.getText().toString());
        newcitizen.setNumberOfFamilyNumber((int) (Integer.parseInt(((EditText) findViewById(R.id.editText_number_family_member)).getText().toString())));
        newcitizen.setIdentificationNumber((int) (Integer.parseInt(((EditText) findViewById(R.id.editText_id_number)).getText().toString())));
        newcitizen.setPlaceOfBirth(((EditText) findViewById(R.id.editText_place_birth)).getText().toString());
        newcitizen.setPassportNumber((int) (Integer.parseInt(((EditText) findViewById(R.id.editText_passport_number)).getText().toString())));
        newcitizen.setTelephoneNumber((int) (Integer.parseInt(((EditText) findViewById(R.id.editText_telephone_number)).getText().toString())));
        newcitizen.setMobileNumber((int) (Integer.parseInt(((EditText) findViewById(R.id.editText_mobile_number)).getText().toString())));
        newcitizen.setEmail(EditTextEmail.getText().toString());
        newcitizen.setFax((int) (Integer.parseInt(((EditText) findViewById(R.id.editText_fax)).getText().toString())));
        newcitizen.setWork(((EditText) findViewById(R.id.editText_work)).getText().toString());
        newcitizen.setAddress(((EditText) findViewById(R.id.editText_address)).getText().toString());
        newcitizen.setStreet(((EditText) findViewById(R.id.editText_street)).getText().toString());
        newcitizen.setRegion(((EditText) findViewById(R.id.editText_region)).getText().toString());
        newcitizen.setZone(((EditText) findViewById(R.id.editText_zone)).getText().toString());
        newcitizen.setUsername(EditTextUserName.getText().toString());
        newcitizen.setPassword(EditTextPassword.getText().toString());
        RadioGroup radioGroup_gender = ((RadioGroup) findViewById(R.id.radioGroup_gender));
        RadioButton radiobutton_gender = (RadioButton) findViewById(radioGroup_gender.getCheckedRadioButtonId());
        newcitizen.setGender(radiobutton_gender.getText().toString());
        newcitizen.addToDB();

    }

    private boolean checkEmail() {
        String email = EditTextEmail.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {

            TextInputLayoutEmail.setErrorEnabled(true);
            TextInputLayoutEmail.setError(getString(R.string.err_msg_email));
            EditTextEmail.setError(getString(R.string.err_msg_required));
            requestFocus(EditTextEmail);
            return false;
        }
        TextInputLayoutEmail.setErrorEnabled(false);
        return true;
    }

    private boolean checkFirstName() {
        if (EditTextFirstName.getText().toString().trim().isEmpty()) {

            TextInputLayoutFirstName.setError(getString(R.string.err_msg_required));
            requestFocus(TextInputLayoutFirstName);
            return false;
        }
        TextInputLayoutFirstName.setErrorEnabled(false);
        return true;
    }

    private boolean checkFatherName() {
        if (EditTextFatherName.getText().toString().trim().isEmpty()) {

            TextInputLayoutFatherName.setError(getString(R.string.err_msg_required));
            requestFocus(TextInputLayoutFatherName);
            return false;
        }
        TextInputLayoutFatherName.setErrorEnabled(false);
        return true;
    }

    private boolean checkGrandFatherName() {
        if (EditTextGrandFatherName.getText().toString().trim().isEmpty()) {

            TextInputLayoutGrandFatherName.setError(getString(R.string.err_msg_required));
            requestFocus(TextInputLayoutGrandFatherName);
            return false;
        }
        TextInputLayoutGrandFatherName.setErrorEnabled(false);
        return true;
    }

    private boolean checkFamilyName() {
        if (EditTextFamilyName.getText().toString().trim().isEmpty()) {

            TextInputLayoutFamilyName.setError(getString(R.string.err_msg_required));
            requestFocus(TextInputLayoutFamilyName);
            return false;
        }
        TextInputLayoutFamilyName.setErrorEnabled(false);
        return true;
    }

    private boolean checkUserName() {
        if (EditTextUserName.getText().toString().trim().isEmpty()) {

            TextInputLayoutUserName.setError(getString(R.string.err_msg_required));
            requestFocus(TextInputLayoutUserName);
            return false;
        }
        TextInputLayoutUserName.setErrorEnabled(false);
        return true;
    }

    private boolean checkPassword() {
        if (EditTextPassword.getText().toString().trim().isEmpty()) {

            TextInputLayoutPassword.setError(getString(R.string.err_msg_required));
            requestFocus(TextInputLayoutPassword);
            return false;
        }
        TextInputLayoutPassword.setErrorEnabled(false);
        return true;
    }

    private boolean checkIdNumber() {
        if (EditTextIdNumber.getText().toString().trim().isEmpty()) {

            TextInputLayoutIdNumber.setError(getString(R.string.err_msg_required));
            requestFocus(TextInputLayoutIdNumber);
            return false;
        }
        TextInputLayoutIdNumber.setErrorEnabled(false);
        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
