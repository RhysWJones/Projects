package com.example.rhysj.wmad_assignment_2.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rhysj.wmad_assignment_2.DTO.ScreenDTO;
import com.example.rhysj.wmad_assignment_2.R;

import java.util.ArrayList;

/**
 * Created by Rhys Jones on 04/04/2018.
 */

public class ScreenListAdapter extends BaseAdapter
{
    private ArrayList<ScreenDTO> cinemaScreens;
    private Context context;

    public ScreenListAdapter(ArrayList<ScreenDTO> cinemaScreens, Context context)
    {
        this.cinemaScreens = cinemaScreens;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return cinemaScreens.size();
    }

    @Override
    public Object getItem(int position)
    {
        return cinemaScreens.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return cinemaScreens.indexOf(getItem(position));
    }

    private class ViewHolder
    {
        TextView cinema_name;
        TextView screen_name;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (view == null)
        {
            ScreenDTO screen = cinemaScreens.get(position);

            view = inflater.inflate(R.layout.screen_list_item, null);
            holder = new ViewHolder();

            holder.cinema_name = view.findViewById(R.id.screen_list_item_cinema_name);
            holder.screen_name = view.findViewById(R.id.screen_list_item_screen_name);

            holder.cinema_name.setText(screen.getCinema().getName());
            holder.screen_name.setText(screen.getScreenName());
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        return view;
    }
}
