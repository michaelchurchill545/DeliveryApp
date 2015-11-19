package com.example.michael.deliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Patrick on 11/12/2015.
 */
public class DrawerRecyclerAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<NavigationItem> mNavItems;

    public DrawerRecyclerAdapter(Context context, ArrayList<NavigationItem> navItems) {
        mContext = context;
        mNavItems = navItems;
    }

    @Override
    public int getCount() {
        return mNavItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item, null);
        }
        else {
            view = convertView;
        }

        TextView nameView = (TextView) view.findViewById(R.id.title);
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);

        nameView.setText( mNavItems.get(position).mName );
        iconView.setImageResource(mNavItems.get(position).mIcon);

        return view;
    }
}
