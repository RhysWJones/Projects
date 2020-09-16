package com.example.rhysj.wmad_assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rhysj.wmad_assignment_2.DTO.UserDTO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rhys Jones on 12/04/2018.
 */

public class UpdateAccountActivity extends AppCompatActivity implements Response.Listener<String>
{
    private NavigationSlider navView;
    UserDTO loggedUser;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_update_account);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("Update Account Details");

        displayLoggedUserDetails();
    }

    @Override
    public void onResponse(String response)
    {
        if(Boolean.parseBoolean(response))
        {
            Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_LONG ).show();
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Update Failure", Toast.LENGTH_LONG ).show();
        }
    }

    public void update(View view)
    {
        final String forename = ((EditText) findViewById(R.id.update_forename)).getText().toString();
        final String surname = ((EditText) findViewById(R.id.update_surname)).getText().toString();
        final String addressLine1 = ((EditText) findViewById(R.id.update_address_line_1)).getText().toString();
        final String addressLine2 = ((EditText) findViewById(R.id.update_address_line_2)).getText().toString();
        final String postcode = ((EditText) findViewById(R.id.update_postcode)).getText().toString();
        final String password;
        final String inputPassword = ((EditText) findViewById(R.id.update_password)).getText().toString();

        if(inputPassword.isEmpty())
        {
            BaseConnectionHandler BCH = new BaseConnectionHandler();
            String urlPath = BCH.baseConnection + "/CustomerUI/account/";
            StringRequest stringRequest = new StringRequest(Request.Method.PUT, urlPath, this,
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

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String DOB = sdf.format(loggedUser.getDOB().getTime());
                    String username = loggedUser.getUsername();
                    String userID = Integer.toString(loggedUser.getUserID());

                    params.put("userID", userID);
                    params.put("forename", forename);
                    params.put("surname", surname);
                    params.put("DOB", DOB);
                    params.put("addressLine1", addressLine1);
                    params.put("addressLine2", addressLine2);
                    params.put("postcode", postcode);
                    params.put("username", username);
                    params.put("password", loggedUser.getPassword());
                    return params;
                }
            };
            Volley.newRequestQueue(this).add(stringRequest);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String DOB = sdf.format(loggedUser.getDOB().getTime());
            String username = loggedUser.getUsername();
            int userID = loggedUser.getUserID();

            SharedPreferencesHandler SPH = SharedPreferencesHandler.getInstance(this);
            SPH.logout();
            SPH.setLoggedInUser(new UserDTO(userID, forename, surname, DOB, addressLine1, addressLine2, postcode, username, loggedUser.getPassword(), loggedUser.isIsAdmin()));
        }

        else if(!inputPassword.isEmpty())
        {
            String tempPass = inputPassword;

            try
            {
                byte[] hash = MessageDigest.getInstance("SHA-256")
                        .digest(tempPass.getBytes(StandardCharsets.UTF_8));

                tempPass = Base64.encodeToString(hash, Base64.DEFAULT);
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(), "Error serialising password", Toast.LENGTH_LONG ).show();
            }

            password = tempPass;

            BaseConnectionHandler BCH = new BaseConnectionHandler();
            String urlPath = BCH.baseConnection + "/CustomerUI/account/";
            StringRequest stringRequest = new StringRequest(Request.Method.PUT, urlPath, this,
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

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String DOB = sdf.format(loggedUser.getDOB().getTime());
                    String username = loggedUser.getUsername();
                    String userID = Integer.toString(loggedUser.getUserID());

                    params.put("userID", userID);
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

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String DOB = sdf.format(loggedUser.getDOB().getTime());
            String username = loggedUser.getUsername();
            int userID = loggedUser.getUserID();

            SharedPreferencesHandler SPH = SharedPreferencesHandler.getInstance(this);
            SPH.logout();
            SPH.setLoggedInUser(new UserDTO(userID, forename, surname, DOB, addressLine1, addressLine2, postcode, username, password.substring(0, password.length() - 1), loggedUser.isIsAdmin()));
        }
    }

    public void displayLoggedUserDetails()
    {
        loggedUser = SharedPreferencesHandler.getInstance(this).getLoggedInUser();

        //Set the forename.
        EditText forenameInput = findViewById(R.id.update_forename);
        forenameInput.setText(loggedUser.getForename());

        //Set the surname.
        EditText surnameInput = findViewById(R.id.update_surname);
        surnameInput.setText(loggedUser.getSurname());

        //Set the DOB.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        EditText DOBDisplay = findViewById(R.id.update_DOB);
        DOBDisplay.setText(sdf.format(loggedUser.getDOB().getTime()));

        //Set the address line 1.
        EditText addressLine1Input = findViewById(R.id.update_address_line_1);
        addressLine1Input.setText(loggedUser.getAddressLine1());

        //Set the address line 2.
        EditText addressLine2Input = findViewById(R.id.update_address_line_2);
        addressLine2Input.setText(loggedUser.getAddressLine2());

        //Set the postcode.
        EditText postcodeInput = findViewById(R.id.update_postcode);
        postcodeInput.setText(loggedUser.getPostcode());

        //Set the username.
        EditText usernameDisplay = findViewById(R.id.update_username);
        usernameDisplay.setText(loggedUser.getUsername());
    }
}
