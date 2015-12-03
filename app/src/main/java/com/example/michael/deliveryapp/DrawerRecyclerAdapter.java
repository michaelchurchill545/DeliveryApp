package com.example.michael.deliveryapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michael.deliveryapp.Login.Login;
import com.example.michael.deliveryapp.Login.Register;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Patrick on 11/12/2015.
 */
public class DrawerRecyclerAdapter extends RecyclerView.Adapter<DrawerRecyclerAdapter.NavItemViewHolder> {
    protected LayoutInflater inflater;
    protected Context context;
    private List<NavigationItem> mNavItems = Collections.EMPTY_LIST;

    public DrawerRecyclerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        mNavItems = inputData();
        this.context = context;
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


    public ArrayList<NavigationItem> inputData() {
        ArrayList<NavigationItem> a = new ArrayList<>();

        a.add(new NavigationItem("Home", "No place like it", R.drawable.ic_action_home));
        a.add(new NavigationItem("Choose Store", "Select an item from a store", R.drawable.ic_store));
        a.add(new NavigationItem("Shopping Cart", "View the items you want to buy", R.drawable.ic_action_cart));
        a.add(new NavigationItem("Set Preferences", "Manage your location and payment", R.drawable.ic_settings));
        a.add(new NavigationItem("Log Out", "Something You Don't Want To Ever Do", R.drawable.ic_exit_to_app));

        return a;
    }

    class NavItemViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener {
        TextView title;
        TextView description;
        ImageView icon;

        public NavItemViewHolder(View navItemView) {
            super(navItemView);
            navItemView.setOnClickListener(this);
            title = (TextView) navItemView.findViewById(R.id.title);
            description = (TextView) navItemView.findViewById(R.id.description);
            icon = (ImageView) navItemView.findViewById(R.id.icon);
        }

        @Override
        public void onClick(View v) {
            Intent i;

            int position = getAdapterPosition();
            switch (position) {
                case 0:
                    i = new Intent(context, Home.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    break;
                case 1:
                    i = new Intent(context, ChooseItem.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    break;
                case 2:
                    i = new Intent(context, ShoppingCartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    break;
                case 3:
                    i = new Intent(context, Register.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    break;
                case 4:
                    i = new Intent(context, Login.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                    break;

            }
        }


    }
}
