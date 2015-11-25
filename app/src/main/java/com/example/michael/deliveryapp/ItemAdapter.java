package com.example.michael.deliveryapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by michael on 11/9/2015.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private LayoutInflater inflater;
    List<Item> data;

    /**
     * Created by michael on 11/9/2015.
     */
    public ItemAdapter(Context context, List<Item> list) {
        inflater = LayoutInflater.from(context);
        data = list;
        setHasStableIds(true);

    }

    /**
     * Created by michael on 11/9/2015.
     */
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_view_row, parent, false);
        System.out.println("View Holder Created");
        return new ItemViewHolder(view);
    }

    /**
     * Created by michael on 11/9/2015.
     */
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        Item item = data.get(position);

        holder.title.setText(item.getName());
        System.out.println(item.getName() + " was bound");
        holder.price.setText(item.getItemPrice());
        System.out.println(item.getItemPrice() + " was bound");
        holder.icon.setImageResource(item.getIconId());
        System.out.println(item.getIconId() + " was bound");
    }

    public int getItemCount() {
        System.out.println("Item count:" + data.size());

        return data.size();

    }

    /**
     * Created by michael on 11/9/2015.
     */
    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;
        ImageView icon;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_name);
            icon = (ImageView) itemView.findViewById(R.id.item_icon);
            price = (TextView) itemView.findViewById(R.id.item_price);
        }
    }
}
