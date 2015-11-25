package com.example.michael.deliveryapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Patrick on 11/12/2015.
 */
public class DrawerRecyclerAdapter extends RecyclerView.Adapter<DrawerRecyclerAdapter.NavItemViewHolder> {
    private LayoutInflater inflater;
    List<NavigationItem> mNavItems = Collections.EMPTY_LIST;

    public DrawerRecyclerAdapter(Context context, List<NavigationItem> navItems) {
        inflater = LayoutInflater.from(context);
        mNavItems = navItems;
    }

    @Override
    public NavItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.drawer_item, parent, false);
        NavItemViewHolder holder = new NavItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NavItemViewHolder holder, int position) {
        TextView title = holder.title;
        TextView description = holder.description;
        ImageView icon = holder.icon;

        title.setText(mNavItems.get(position).getName());
        description.setText(mNavItems.get(position).getDescription());
        icon.setImageResource(mNavItems.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return mNavItems.size();
    }

    class NavItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView description;
        ImageView icon;

        public NavItemViewHolder(View navItemView) {
            super(navItemView);
            title = (TextView) navItemView.findViewById(R.id.title);
            description = (TextView) navItemView.findViewById(R.id.description);
            icon = (ImageView) navItemView.findViewById(R.id.icon);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
