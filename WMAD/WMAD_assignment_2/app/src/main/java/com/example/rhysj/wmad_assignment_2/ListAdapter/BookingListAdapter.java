package com.example.rhysj.wmad_assignment_2.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rhysj.wmad_assignment_2.DTO.BookingDTO;
import com.example.rhysj.wmad_assignment_2.R;

import java.util.ArrayList;

/**
 * Created by Rhysj on 15/04/2018.
 */

public class BookingListAdapter extends BaseAdapter
{
    private ArrayList<BookingDTO> bookings;
    private Context context;

    public BookingListAdapter(ArrayList<BookingDTO> bookings, Context context)
    {
        this.bookings = bookings;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return bookings.size();
    }

    @Override
    public Object getItem(int position)
    {
        return bookings.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return bookings.indexOf(getItem(position));
    }

    private class ViewHolder
    {
        TextView customer_info;
        TextView booked_showing;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //if (view == null)
        //{
            BookingDTO booking = bookings.get(position);

            view = inflater.inflate(R.layout.booking_list_item, null);
            holder = new ViewHolder();

            holder.customer_info = view.findViewById(R.id.booking_list_item_customer_info);
            holder.booked_showing = view.findViewById(R.id.booking_list_item_booked_showing);

            holder.customer_info.setText(booking.getCustomer().getForename() + " " + booking.getCustomer().getSurname());
            holder.booked_showing.setText(booking.getShowing().getScreen().getCinema().getName() + ": " + booking.getShowing().getScreen().getScreenName()
                    + " " + booking.getShowing().getFilm().getTitle()
                    + " " + booking.getShowing().getTime());
        //}
        //else
        //{
            //holder = (ViewHolder) view.getTag();
        //}

        return view;
    }
}
