package com.example.rhysj.wmad_assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rhysj.wmad_assignment_2.DTO.UserDTO;
import com.example.rhysj.wmad_assignment_2.JsonConverter.StringToDateConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

/**
 * Created by Rhys Jones on 11/04/2018.
 */

public class LoginActivity extends AppCompatActivity implements Response.Listener<String>
{
    private NavigationSlider navView;
    private UserDTO loggedInUser;
    private CheckBox loginAsAdmin;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_login);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("Login");
    }

    @Override
    public void onResponse(String response)
    {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new StringToDateConverter()).create();
        loggedInUser = gson.fromJson(response, UserDTO.class);

        SharedPreferencesHandler.getInstance(this).setLoggedInUser(loggedInUser);

        if(loggedInUser.isIsAdmin() && !loginAsAdmin.isChecked())
        {
            SharedPreferencesHandler.getInstance(this).logout();
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Check log in as admin checkbox to log in as an admin.", Snackbar.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Check log in as admin checkbox to log in as an admin.", Toast.LENGTH_LONG).show();
        }
        else if(!loggedInUser.isIsAdmin() && loginAsAdmin.isChecked())
        {
            SharedPreferencesHandler.getInstance(this).logout();
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Customers can not log in as admin.", Snackbar.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Customers can not log in as admin.", Toast.LENGTH_LONG).show();
        }

        if(SharedPreferencesHandler.getInstance(this).isUserLoggedIn())
        {
            Toast.makeText(getApplicationContext(), "Login successful.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
    }

    public void login(View view)
    {
        final String username;
        final String password;
        this.loginAsAdmin = findViewById(R.id.admin_checkbox);

        //Check Username
        EditText usernameInput = findViewById(R.id.login_username);
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
        EditText passwordInput = findViewById(R.id.login_password);
        if(passwordInput.getText().toString().isEmpty())
        {
            //Snackbar.make(view, "Password Required", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Password required.", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            String tempPass = passwordInput.getText().toString();

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

        //Handle login for customers
        if(!loginAsAdmin.isChecked())
        {
            String urlPath = BCH.baseConnection + "/CustomerUI/login/" + username
                    + "/" + password;
            StringRequest stringRequest = new StringRequest(Request.Method.GET, urlPath, this,
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            Toast.makeText(getApplicationContext(), "Incorrect login details", Toast.LENGTH_LONG).show();
                        }
                    });
            Volley.newRequestQueue(this).add(stringRequest);
        }

        //Handle login for admins
        if(loginAsAdmin.isChecked())
        {
            String urlPath = BCH.baseConnection + "/AdminUI/login/" + username
                    + "/" + password;
            StringRequest stringRequest = new StringRequest(Request.Method.GET, urlPath, this,
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {
                            Toast.makeText(getApplicationContext(), "Incorrect login details", Toast.LENGTH_LONG).show();
                        }
                    });
            Volley.newRequestQueue(this).add(stringRequest);
        }
    }
}
