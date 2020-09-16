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
import com.example.rhysj.wmad_assignment_2.DTO.ScreenDTO;
import com.example.rhysj.wmad_assignment_2.DTO.ShowingDTO;
import com.example.rhysj.wmad_assignment_2.ListAdapter.ShowingListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Rhys Jones on 05/04/2018.
 */

public class ViewShowingsActivity extends AppCompatActivity implements Response.Listener<String>, AdapterView.OnItemClickListener
{
    private NavigationSlider navView;
    private ArrayList<ShowingDTO> showings;
    private ScreenDTO selectedScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Sets which xml file to load
        setContentView(R.layout.activity_view_showings);

        navView = new NavigationSlider(this);

        getSupportActionBar().setTitle("View Showings");

        Intent intent = getIntent();
        selectedScreen = (ScreenDTO) intent.getSerializableExtra("selectedScreen");

        viewShowings();

        SharedPreferencesHandler SPH = SharedPreferencesHandler.getInstance(getApplicationContext());
        if(SPH.isUserLoggedIn())
        {
            if(SPH.getLoggedInUser().isIsAdmin())
            {
                findViewById(R.id.showing_add_showing).setVisibility(View.VISIBLE);
            }
            else
            {
                findViewById(R.id.showing_add_showing).setVisibility(View.INVISIBLE);
            }
        }
        else
        {
            findViewById(R.id.showing_add_showing).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBackPressed()
    {
        if(!navView.backPressed())
        {
            super.onBackPressed();
        }
    }

    public void viewShowings()
    {
        String encodedScreenName = "";
        BaseConnectionHandler BCH = new BaseConnectionHandler();
        try
        {
            encodedScreenName = URLEncoder.encode(selectedScreen.getScreenName(), "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        String urlPath = BCH.baseConnection + "/CustomerUI/showing/" + selectedScreen.getScreenID()
                + "/" + encodedScreenName
                + "/" + selectedScreen.getCinema().getCinemaID()
                + "/" + selectedScreen.getCinema().getName();
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
        showings = gson.fromJson(response, new TypeToken<ArrayList<ShowingDTO>>(){}.getType());

        ListView list = findViewById(R.id.showings_listview);

        ShowingListAdapter adapter = new ShowingListAdapter(showings, this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        ShowingDTO selectedShowing = showings.get(position);
        if(SharedPreferencesHandler.getInstance(this).isUserLoggedIn())
        {
            if(!SharedPreferencesHandler.getInstance(this).getLoggedInUser().isIsAdmin())
            {
                Intent intent = new Intent(this, BookTicketsActivity.class);
                intent.putExtra("selectedShowing", selectedShowing);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Admin can not book tickets.", Toast.LENGTH_LONG ).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Log in to book seats for: " + selectedShowing.getFilm().getTitle() + " " + selectedShowing.getTime(), Toast.LENGTH_LONG ).show();
        }
    }

    public void addShowing(View view)
    {
        if(SharedPreferencesHandler.getInstance(this).getLoggedInUser().isIsAdmin())
        {
            Intent intent = new Intent(this, AddShowingActivity.class);
            intent.putExtra("selectedScreen", selectedScreen);
            startActivity(intent);
        }
    }
}
