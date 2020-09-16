package com.example.rhysj.wmad_assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.example.rhysj.wmad_assignment_2.DTO.ScreenDTO;
import com.example.rhysj.wmad_assignment_2.ListAdapter.ScreenListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>, AdapterView.OnItemClickListener
{
    private NavigationSlider navView;
    private ArrayList<ScreenDTO> cinemaScreens;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_main);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("View Cinemas");

        viewCinemas();
    }

    @Override
    public void onBackPressed()
    {
        if(!navView.backPressed())
        {
            super.onBackPressed();
        }
    }

    public void viewCinemas()
    {
        BaseConnectionHandler BCH = new BaseConnectionHandler();
        String urlPath = BCH.baseConnection + "/CustomerUI/screen";
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
        Gson gson = new Gson();
        cinemaScreens = gson.fromJson(response, new TypeToken<ArrayList<ScreenDTO>>(){}.getType());

        ListView list = findViewById(R.id.screens_listview);

        ScreenListAdapter adapter = new ScreenListAdapter(cinemaScreens, this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        ScreenDTO selectedScreen = cinemaScreens.get(position);
        Intent intent = new Intent(this, ViewShowingsActivity.class);
        intent.putExtra("selectedScreen", selectedScreen);
        startActivity(intent);
    }
}
