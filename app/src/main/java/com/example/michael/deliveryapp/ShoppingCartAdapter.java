
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
 * This adapter allows Item information to be successfully displayed in the shopping cart with
 * the appropriate XML layout information specified in the resource files
 */
public class ShoppingCartAdapter extends BaseAdapter {

    private ArrayList<Item> cartItems;
    private LayoutInflater layoutInflater;

    public ShoppingCartAdapter(Context aContext, ArrayList<Item> cartItems) {
        this.cartItems = cartItems;
        layoutInflater = LayoutInflater.from(aContext);
    }

    /**
     * Getter
     *
     * @return the size of the list
     */
    public int getCount() {
        return cartItems.size();
    }

    /**
     * Getter
     *
     * @param position the index of the item in a list of items
     * @return an item in a list at a given position
     */
    public Item getItem(int position) {
        return cartItems.get(position);
    }

    /**
     * Getter
     * @param position the specific index
     * @return gets an item's position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * getView grabs the correct XML layout file in charge of supplying the design for a single Item
     * row, then creates a view holder and merges the Item's information with the View's attributes.
     * @param position the position of the Item in a list of items
     * @param convertView A view (in this case a single row) that will be filled with an item's information
     * @param parent The frame that contains several convertViews (The actual list part of a ListView)
     * @return the row of a shopping cart with a given item's information
     */
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

    /**
     * Created By Roben
     * This ViewHolder initializes the attributes of a shopping cart row by creating three text views.
     *  objects of ViewHolder are used in the getView() method above.
     */
    static class ViewHolder {
        TextView itemname;
        TextView description;
        TextView price;

        public ViewHolder() {

        }
    }
}