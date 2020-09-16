package com.example.rhysj.wmad_assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rhysj.wmad_assignment_2.DTO.ShowingDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rhysj on 14/04/2018.
 */

public class BookTicketsActivity extends AppCompatActivity implements Response.Listener<String>
{
    private NavigationSlider navView;
    private ShowingDTO selectedShowing;
    String numberOfSeats = "";

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_book_tickets);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("Book Tickets");

        Intent intent = getIntent();
        selectedShowing = (ShowingDTO) intent.getSerializableExtra("selectedShowing");
    }

    @Override
    public void onResponse(String response)
    {
        if (Boolean.parseBoolean(response))
        {
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Seats successfully booked.", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Seats successfully booked.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Failed to book seats.", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Failed to book seats.", Toast.LENGTH_LONG).show();
    }

    public void bookTickets(View view)
    {
        final EditText numberOfSeatsInput = findViewById(R.id.book_tickets_seats);
        if (!numberOfSeatsInput.getText().toString().isEmpty() && !numberOfSeatsInput.getText().toString().equals("0"))
        {
            numberOfSeats = numberOfSeatsInput.getText().toString();
            BaseConnectionHandler BCH = new BaseConnectionHandler();
            String urlPath = BCH.baseConnection + "/CustomerUI/booking/";
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

                    String showingID = Integer.toString(selectedShowing.getShowingID());
                    String userID = Integer.toString(SharedPreferencesHandler.getInstance(getApplicationContext()).getLoggedInUser().getUserID());

                    params.put("showingID", showingID);
                    params.put("userID", userID);
                    params.put("seats", numberOfSeats);
                    return params;
                }
            };
            Volley.newRequestQueue(this).add(stringRequest);
        }
        else if (numberOfSeatsInput.getText().toString().isEmpty() || numberOfSeatsInput.getText().toString().equals("0"))
        {
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Must enter a number above 0.", Snackbar.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Must enter a number above 0.", Toast.LENGTH_LONG).show();
        }
    }
}
