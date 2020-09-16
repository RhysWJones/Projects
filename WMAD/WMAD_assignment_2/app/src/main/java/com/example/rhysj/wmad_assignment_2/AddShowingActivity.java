package com.example.rhysj.wmad_assignment_2;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rhysj.wmad_assignment_2.DTO.FilmDTO;
import com.example.rhysj.wmad_assignment_2.DTO.ScreenDTO;
import com.example.rhysj.wmad_assignment_2.ListAdapter.FilmListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rhysj on 15/04/2018.
 */

public class AddShowingActivity extends AppCompatActivity implements Response.Listener<String>,  AdapterView.OnItemClickListener
{
    private NavigationSlider navView;
    private ArrayList<FilmDTO> films;
    private FilmDTO selectedFilm;
    private String timeOfShowing;
    private ScreenDTO selectedScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_add_showing);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("Add Showing");

        Intent intent = getIntent();
        selectedScreen = (ScreenDTO) intent.getSerializableExtra("selectedScreen");

        displayFilms();
    }

    private void displayFilms()
    {
        BaseConnectionHandler BCH = new BaseConnectionHandler();
        String urlPath = BCH.baseConnection + "/AdminUI/film";
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
    public void onResponse(String response)
    {
        if(!response.toString().equals("true") && !response.toString().equals("false"))
        {
            Gson gson = new Gson();
            films = gson.fromJson(response, new TypeToken<ArrayList<FilmDTO>>() {
            }.getType());

            ListView list = findViewById(R.id.films_listview);

            FilmListAdapter adapter = new FilmListAdapter(films, this);
            list.setAdapter(adapter);
            list.setOnItemClickListener(this);
        }
        else if(response.toString().equals("true"))
        {
            Toast.makeText(getApplicationContext(), "Showing added successfully.", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Failed to add showing.", Toast.LENGTH_LONG).show();
        }
    }

    public void addShowing(View view)
    {
        EditText timeOfShowingInput = findViewById(R.id.add_showing_time);
        timeOfShowing = timeOfShowingInput.getText().toString();

        if(!timeOfShowing.isEmpty() && !selectedFilm.equals(null))
        {
            BaseConnectionHandler BCH = new BaseConnectionHandler();
            String urlPath = BCH.baseConnection + "/AdminUI/showing/";
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

                    String filmID = Integer.toString(selectedFilm.getFilmID());
                    String screenID = Integer.toString(selectedScreen.getScreenID());
                    String time = timeOfShowing;

                    params.put("filmID", filmID);
                    params.put("screenID", screenID);
                    params.put("time", time);
                    return params;
                }
            };
            Volley.newRequestQueue(this).add(stringRequest);
        }
        else if(timeOfShowing.isEmpty() || selectedFilm.equals(null))
        {
            //Snackbar.make(getWindow().getDecorView().getRootView(), "Must select a film, and enter a time for the showing.", Snackbar.LENGTH_LONG ).show();
            Toast.makeText(getApplicationContext(), "Must select a film, and enter a time for the showing.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
    {
        selectedFilm = films.get(position);
    }

    public void openTimePicker(final View view)
    {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                EditText timeOfShowingInput = findViewById(R.id.add_showing_time);
                timeOfShowingInput.setText( selectedHour + ":" + selectedMinute + ":00");
            }
        }, hour, minute, true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}
