
package com.example.michael.deliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Roben on 11/30/2015.
 */
public class ShoppingCartAdapter extends BaseAdapter {

    private ArrayList<Item> cartItems;
    private LayoutInflater layoutInflater;

    public ShoppingCartAdapter(Context aContext, ArrayList<Item> cartItems) {
        this.cartItems = cartItems;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public int getCount() {
        return cartItems.size();
    }

    public Item getItem(int position) {
        return cartItems.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.cart_row, null);
            holder = new ViewHolder();
            holder.itemname = (TextView) convertView.findViewById(R.id.itemname);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.itemname.setText(cartItems.get(position).getName());
        holder.description.setText(cartItems.get(position).getDescription());
        String pricestring = "$" + String.format("%.2f", cartItems.get(position).getItemPrice());
        holder.price.setText(pricestring);
        return convertView;
    }

    static class ViewHolder {
        TextView itemname;
        TextView description;
        TextView price;

        public ViewHolder() {

        }
    }
}