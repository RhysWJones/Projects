package com.example.rhysj.wmad_assignment_2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Rhys Jones on 05/04/2018.
 */

public class RegisterActivity extends AppCompatActivity implements Response.Listener<String>
{
    private NavigationSlider navView;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_register);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("Register");
    }

    @Override
    public void onResponse(String response)
    {
        if(Boolean.parseBoolean(response))
        {
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Registered Successfully", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Registered Successfully.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
        }
        else
        {
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Registration Failure", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Registration failed.", Toast.LENGTH_LONG).show();
        }
    }

    public void register(View view)
    {
        final int userID = 0;
        final String forename;
        final String surname;
        final String DOB;
        final String addressLine1;
        final String addressLine2;
        final String postcode;
        final String username;
        final String password;
        final boolean isAdmin = false;

        //Check forename
        EditText forenameInput = findViewById(R.id.register_forename);
        if(forenameInput.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Forename Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Forename required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            forename = forenameInput.getText().toString();
        }

        //Check surname
        EditText surnameInput = findViewById(R.id.register_surname);
        if(surnameInput.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Surname Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Surname required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            surname = surnameInput.getText().toString();
        }

        //Check DOB
        EditText DOBInput = findViewById(R.id.register_DOB);
        if(DOBInput.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Date of Birth Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Date of birth required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            DOB = DOBInput.getText().toString();
        }

        //Check Address Line 1
        EditText addressLine1Input = findViewById(R.id.register_address_line_1);
        if(addressLine1Input.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Address Line 1 Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Address line 1 required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            addressLine1 = addressLine1Input.getText().toString();
        }

        //Check Address Line 2
        EditText addressLine2Input = findViewById(R.id.register_address_line_2);
        if(addressLine2Input.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Address Line 2 Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Address line 2 required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            addressLine2 = addressLine2Input.getText().toString();
        }

        //Check Postcode
        EditText postcodeInput = findViewById(R.id.register_postcode);
        if(postcodeInput.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Postcode Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Postcode required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            postcode = postcodeInput.getText().toString();
        }

        //Check Username
        EditText usernameInput = findViewById(R.id.register_username);
        if(usernameInput.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Username Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Username required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            username = usernameInput.getText().toString();
        }

        //Check Password 1
        EditText password1Input = findViewById(R.id.register_password_1);
        if(password1Input.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Password 1 Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Password 1 required.", Toast.LENGTH_LONG).show();
            return;
        }

        //Check Password 2
        EditText password2Input = findViewById(R.id.register_password_2);
        if(password2Input.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Re-Enter password Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Re-Enter password required.", Toast.LENGTH_LONG).show();
            return;
        }

        //Check Passwords Match
        if(!password1Input.getText().toString().equals(password2Input.getText().toString()))
        {
            //Snackbar.make(view, "Passwords don't match", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Passwords don't match.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            String tempPass = password1Input.getText().toString();

            try
            {
                byte[] hash = MessageDigest.getInstance("SHA-256")
                        .digest(tempPass.getBytes(StandardCharsets.UTF_8));

                tempPass = Base64.encodeToString(hash, Base64.DEFAULT);
            }
            catch (Exception e)
            {
                //Snackbar.make(view, "Error serialising password", Snackbar.LENGTH_LONG ).show();
                Toast.makeText(getApplicationContext(), "Error serialising password.", Toast.LENGTH_LONG).show();
            }

            password = tempPass;
        }

        BaseConnectionHandler BCH = new BaseConnectionHandler();
        String urlPath = BCH.baseConnection + "/CustomerUI/register/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlPath, this,
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<>();

                params.put("forename", forename);
                params.put("surname", surname);
                params.put("DOB", DOB);
                params.put("addressLine1", addressLine1);
                params.put("addressLine2", addressLine2);
                params.put("postcode", postcode);
                params.put("username", username);
                params.put("password", password.substring(0, password.length() - 1));
                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void openDatePicker(final View view)
    {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth)
            {
                ((EditText)view).setText(String.format(Locale.ENGLISH,"%02d/%02d/%04d", dayOfMonth, month+1, year));
            }
        }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
}
