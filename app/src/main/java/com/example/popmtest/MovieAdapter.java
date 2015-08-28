package com.example.popmtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by Victor Cordero.
 * Extend BaseAdapter Instead of ArrayAdapter for Custom List Items
 */
public class MovieAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Movie> mData;

    public MovieAdapter(Context context, ArrayList<Movie> movie) {
        mContext = context;
        mData = movie;
    }

    public void setData(ArrayList<Movie> data) {
        for(Movie movie : data){
            mData.add(movie);
        }
    }

    @Override
    public int getCount() {
        if (mData != null){
            return mData.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.item_movie, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.item_image);
            holder.titleView = (TextView) view.findViewById(R.id.item_title);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final Movie movie = (Movie) getItem(position);

        String imageUrl = "http://image.tmdb.org/t/p/w185" + movie.getPoster();
        Picasso.with(mContext).load(imageUrl).into(holder.imageView);
        holder.titleView.setText(movie.getTitle());

        return view;
    }

    private class ViewHolder {
        public ImageView imageView;
        public TextView titleView;
    }
}