package com.example.rhysj.wmad_assignment_2.JsonConverter;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by J016984c on 11/04/2018.
 */

public class StringToDateConverter implements JsonDeserializer<Date>
{

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        String json_date = json.getAsString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
        try
        {
            Date date = sdf.parse(json_date);
            return date;
        }
        catch(ParseException pe)
        {
            Log.e("JSON_TO_DATE_ERROR: ", "Parse failed" + pe);
            return new Date();
        }
    }
}
