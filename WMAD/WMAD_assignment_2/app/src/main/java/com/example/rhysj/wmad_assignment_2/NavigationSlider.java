package com.example.rhysj.wmad_assignment_2;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.rhysj.wmad_assignment_2.DTO.UserDTO;

/**
 * Created by Rhys Jones on 27/02/2018.
 */

public class NavigationSlider implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener
{
    private AppCompatActivity mActivity;

    public NavigationSlider(AppCompatActivity activity)
    {
        mActivity = activity;

        //Top bar object
        Toolbar toolbar = (Toolbar) mActivity.findViewById(R.id.toolbar);

        //AppCompat method
        mActivity.setSupportActionBar(toolbar);

        //Navigation View screen object
        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        //Sets toggle for navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(mActivity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        onDrawerOpened(drawer); //Call drawerOpened to make it appear smoother.

        //Adds toggle to the drawer listener
        drawer.addDrawerListener(toggle);

        drawer.addDrawerListener(this);

        //Checks the state of the drawer (open or closed) and sets "VerticalMirror" to true or false.
        toggle.syncState();

        //Creates navigation view
        NavigationView navigationView = (NavigationView) mActivity.findViewById(R.id.nav_view);
        //Listens for when a navigation button is pressed.
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String currentActivity = mActivity.getClass().getSimpleName();

        if (id == R.id.nav_login)
        {
            if(!currentActivity.equals("LoginActivity"))
            {
                Intent intent = new Intent(mActivity, LoginActivity.class);
                mActivity.startActivity(intent);
            }
        }
        else if (id == R.id.nav_register)
        {
            if (!currentActivity.equals("RegisterActivity"))
            {
                Intent intent = new Intent(mActivity, RegisterActivity.class);
                mActivity.startActivity(intent);
            }
        }
        else if (id == R.id.nav_logout)
        {
            SharedPreferencesHandler.getInstance(mActivity).logout();

            if (!currentActivity.equals("MainActivity"))
            {
                Intent intent = new Intent(mActivity, MainActivity.class);
                mActivity.startActivity(intent);
            }
        }
        else if (id == R.id.nav_view_cinemas)
        {
            if (!currentActivity.equals("MainActivity"))
            {
                Intent intent = new Intent(mActivity, MainActivity.class);
                mActivity.startActivity(intent);
            }
        }
        else if (id == R.id.nav_update_account)
        {
            if (!currentActivity.equals("UpdateAccountActivity"))
            {
                Intent intent = new Intent(mActivity, UpdateAccountActivity.class);
                mActivity.startActivity(intent);
            }
        }
        else if (id == R.id.nav_view_bookings)
        {
            if(!currentActivity.equals("ViewBookingsActivity"))
            {
                Intent intent = new Intent(mActivity, ViewBookingsActivity.class);
                mActivity.startActivity(intent);
            }
        }
        else if (id == R.id.nav_add_film)
        {

        }
        else if (id == R.id.nav_view_films)
        {

        }

        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean backPressed()
    {
        DrawerLayout drawer = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset)
    {
        //Not used
    }

    @Override
    public void onDrawerOpened(View drawerView)
    {
        NavigationView navView = mActivity.findViewById(R.id.nav_view);
        if(SharedPreferencesHandler.getInstance(drawerView.getContext()).isUserLoggedIn())
        {
            UserDTO loggedUser = SharedPreferencesHandler.getInstance(drawerView.getContext()).getLoggedInUser();

            //Check credentials to set visible for relevant nav menu items.
            if (!loggedUser.isIsAdmin())
            {
                navView.getMenu().findItem(R.id.nav_login).setVisible(false);
                navView.getMenu().findItem(R.id.nav_register).setVisible(false);
                navView.getMenu().findItem(R.id.nav_update_account).setVisible(true);
                navView.getMenu().findItem(R.id.nav_logout).setVisible(true);
                navView.getMenu().findItem(R.id.nav_add_film).setVisible(false);
                navView.getMenu().findItem(R.id.nav_view_films).setVisible(false);
                navView.getMenu().findItem(R.id.nav_view_bookings).setVisible(false);
                navView.getMenu().findItem(R.id.nav_view_cinemas).setVisible(true);
            }
            else if(loggedUser.isIsAdmin())
            {
                navView.getMenu().findItem(R.id.nav_login).setVisible(false);
                navView.getMenu().findItem(R.id.nav_register).setVisible(false);
                navView.getMenu().findItem(R.id.nav_update_account).setVisible(false);
                navView.getMenu().findItem(R.id.nav_logout).setVisible(true);
                navView.getMenu().findItem(R.id.nav_add_film).setVisible(true);
                navView.getMenu().findItem(R.id.nav_view_films).setVisible(true);
                navView.getMenu().findItem(R.id.nav_view_bookings).setVisible(true);
                navView.getMenu().findItem(R.id.nav_view_cinemas).setVisible(true);
            }
        }
        else
        {
            navView.getMenu().findItem(R.id.nav_login).setVisible(true);
            navView.getMenu().findItem(R.id.nav_register).setVisible(true);
            navView.getMenu().findItem(R.id.nav_update_account).setVisible(false);
            navView.getMenu().findItem(R.id.nav_logout).setVisible(false);
            navView.getMenu().findItem(R.id.nav_add_film).setVisible(false);
            navView.getMenu().findItem(R.id.nav_view_films).setVisible(false);
            navView.getMenu().findItem(R.id.nav_view_bookings).setVisible(false);
            navView.getMenu().findItem(R.id.nav_view_cinemas).setVisible(true);
        }
    }

    @Override
    public void onDrawerClosed(View drawerView)
    {
        //Not used
    }

    @Override
    public void onDrawerStateChanged(int newState)
    {
        //Not used
    }
}
