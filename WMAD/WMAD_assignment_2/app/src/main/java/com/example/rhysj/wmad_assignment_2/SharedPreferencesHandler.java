package com.example.rhysj.wmad_assignment_2;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.rhysj.wmad_assignment_2.DTO.UserDTO;

import java.util.Date;

/**
 * Created by Rhys Jones on 05/04/2018.
 */

public class SharedPreferencesHandler
{
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static SharedPreferencesHandler instance;

    private String preferencesName = "CINEMA_SYSTEM_PREFS";

    private String KEY_LOGGED_IN = "LOGGED_IN";
    private String KEY_USER_ID = "USER_ID";
    private String KEY_USER_FORENAME = "USER_FORENAME";
    private String KEY_USER_SURNAME = "USER_SURNAME";
    private String KEY_USER_DOB = "USER_DOB";
    private String KEY_USER_ADDRESSLINE1 = "USER_ADDRESSLINE1";
    private String KEY_USER_ADDRESSLINE2 = "USER_ADDRESSLINE2";
    private String KEY_USER_POSTCODE = "USER_POSTCODE";
    private String KEY_USER_USERNAME = "USER_USERNAME";
    private String KEY_USER_PASSWORD = "USER_PASSWORD";
    private String KEY_USER_ISADMIN = "USER_ISADMIN";

    private SharedPreferencesHandler(Context context)
    {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(preferencesName, 0);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferencesHandler getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new SharedPreferencesHandler(context);
        }

        return instance;
    }

    public void setLoggedInUser(UserDTO loggedInUser)
    {
        editor.putBoolean(KEY_LOGGED_IN, true);

        editor.putInt(KEY_USER_ID, loggedInUser.getUserID());
        editor.putString(KEY_USER_FORENAME, loggedInUser.getForename());
        editor.putString(KEY_USER_SURNAME, loggedInUser.getSurname());
        editor.putLong(KEY_USER_DOB, loggedInUser.getDOB().getTime());
        editor.putString(KEY_USER_ADDRESSLINE1, loggedInUser.getAddressLine1());
        editor.putString(KEY_USER_ADDRESSLINE2, loggedInUser.getAddressLine2());
        editor.putString(KEY_USER_POSTCODE, loggedInUser.getPostcode());
        editor.putString(KEY_USER_USERNAME, loggedInUser.getUsername());
        editor.putString(KEY_USER_PASSWORD, loggedInUser.getPassword());
        editor.putBoolean(KEY_USER_ISADMIN, loggedInUser.isIsAdmin());

        editor.commit();
    }

    public UserDTO getLoggedInUser()
    {
        if(sharedPreferences.getInt(KEY_USER_ID, 0) > 0 && (sharedPreferences.getBoolean(KEY_LOGGED_IN, false)))
        {
            Date DOB = new Date(sharedPreferences.getLong(KEY_USER_DOB, 0));
            return new UserDTO(sharedPreferences.getInt(KEY_USER_ID, 0),
                    sharedPreferences.getString(KEY_USER_FORENAME, ""),
                    sharedPreferences.getString(KEY_USER_SURNAME, ""),
                    DOB,
                    sharedPreferences.getString(KEY_USER_ADDRESSLINE1, ""),
                    sharedPreferences.getString(KEY_USER_ADDRESSLINE2, ""),
                    sharedPreferences.getString(KEY_USER_POSTCODE, ""),
                    sharedPreferences.getString(KEY_USER_USERNAME, ""),
                    sharedPreferences.getString(KEY_USER_PASSWORD, ""),
                    sharedPreferences.getBoolean(KEY_USER_ISADMIN, false));
        }
        else
        {
            return null;
        }
    }

    public boolean isUserLoggedIn()
    {
        return sharedPreferences.getBoolean(KEY_LOGGED_IN, false);
    }

    public void logout()
    {
        editor.putBoolean(KEY_LOGGED_IN, false);
        editor.commit();
    }
}
