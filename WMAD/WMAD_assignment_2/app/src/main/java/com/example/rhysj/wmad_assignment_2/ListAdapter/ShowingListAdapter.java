package com.example.rhysj.wmad_assignment_2.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rhysj.wmad_assignment_2.R;
import com.example.rhysj.wmad_assignment_2.DTO.ShowingDTO;

import java.util.ArrayList;

/**
 * Created by Rhys Jones on 04/04/2018.
 */

public class ShowingListAdapter extends BaseAdapter
{
    private ArrayList<ShowingDTO> showings;
    private Context context;

    public ShowingListAdapter(ArrayList<ShowingDTO> showings, Context context)
    {
        this.showings = showings;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return showings.size();
    }

    @Override
    public Object getItem(int position)
    {
        return showings.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return showings.indexOf(getItem(position));
    }

    private class ViewHolder
    {
        TextView film_info;
        TextView film_description;
        TextView showing_time;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //REMOVED BECAUSE OF ISSUES WITH THE FINAL LIST ITEM BEING WRONG AND PERFORMANCE FOR MY APP WILL NOT BE IMPACTED GREATLY.
        //if (view == null)
        //{
            ShowingDTO showing = showings.get(position);

            view = inflater.inflate(R.layout.showing_list_item, null);
            holder = new ViewHolder();

            holder.film_info = view.findViewById(R.id.showing_list_item_film_info);
            holder.film_description = view.findViewById(R.id.showing_list_item_film_description);
            holder.showing_time = view.findViewById(R.id.showing_list_item_showing_time);

            holder.film_info.setText(showing.getFilm().getTitle() + " Age Rating: " + showing.getFilm().getAgeRating());
            holder.film_description.setText(showing.getFilm().getDescription());
            holder.showing_time.setText(showing.getTime());
        //}
        //else
        //{
            //holder = (ViewHolder) view.getTag();
        //}

        return view;
    }
}
