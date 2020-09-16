package com.example.rhysj.wmad_assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rhysj.wmad_assignment_2.DTO.BookingDTO;
import com.example.rhysj.wmad_assignment_2.DTO.FilmDTO;
import com.example.rhysj.wmad_assignment_2.ListAdapter.BookingListAdapter;
import com.example.rhysj.wmad_assignment_2.ListAdapter.FilmListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ViewBookingsActivity extends AppCompatActivity implements Response.Listener<String>, AdapterView.OnItemClickListener
{
    private NavigationSlider navView;
    private ArrayList<BookingDTO> bookings;
    private BookingDTO selectedBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_view_bookings);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("View Bookings");

        displayBookings();
    }

    private void displayBookings()
    {
        BaseConnectionHandler BCH = new BaseConnectionHandler();
        String urlPath = BCH.baseConnection + "/AdminUI/booking";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlPath, this,
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        selectedBooking = bookings.get(position);
    }

    @Override
    public void onResponse(String response)
    {
        if(!response.toString().equals("true") && !response.toString().equals("false"))
        {
            Gson gson = new Gson();
            bookings = gson.fromJson(response, new TypeToken<ArrayList<BookingDTO>>() {
            }.getType());

            ListView list = findViewById(R.id.bookings_listview);

            BookingListAdapter adapter = new BookingListAdapter(bookings, this);
            list.setAdapter(adapter);
            list.setOnItemClickListener(this);
        }
        else if(response.toString().equals("true"))
        {
            Toast.makeText(getApplicationContext(), "Booking deleted successfully.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ViewBookingsActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Failed to delete booking.", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteShowing(View view)
    {
        BaseConnectionHandler BCH = new BaseConnectionHandler();
        String urlPath = BCH.baseConnection + "/AdminUI/booking"
                + "/" + selectedBooking.getBookingID()
                + "/" + selectedBooking.getShowing().getShowingID()
                + "/" + selectedBooking.getQuantity();
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, urlPath, this,
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
