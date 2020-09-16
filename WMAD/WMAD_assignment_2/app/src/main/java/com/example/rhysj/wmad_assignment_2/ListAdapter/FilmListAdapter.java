package com.example.rhysj.wmad_assignment_2.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rhysj.wmad_assignment_2.R;
import com.example.rhysj.wmad_assignment_2.DTO.FilmDTO;

import java.util.ArrayList;

/**
 * Created by Rhysj on 15/04/2018.
 */

public class FilmListAdapter extends BaseAdapter
{
    private ArrayList<FilmDTO> films;
    private Context context;

    public FilmListAdapter(ArrayList<FilmDTO> films, Context context)
    {
        this.films = films;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return films.size();
    }

    @Override
    public Object getItem(int position)
    {
        return films.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return films.indexOf(getItem(position));
    }

    private class ViewHolder
    {
        TextView film_info;
        TextView film_description;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (view == null)
        {
            FilmDTO film = films.get(position);

            view = inflater.inflate(R.layout.film_list_item, null);
            holder = new ViewHolder();

            holder.film_info = view.findViewById(R.id.film_list_item_film_info);
            holder.film_description = view.findViewById(R.id.film_list_item_film_description);

            holder.film_info.setText(film.getTitle() + " Age Rating: " + film.getAgeRating());
            holder.film_description.setText(film.getDescription());
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        return view;
    }
}
