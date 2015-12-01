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
public abstract class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    protected LayoutInflater inflater;
    private List<Item> data;

    /**
     * Created by michael on 11/9/2015.
     */
    public ItemAdapter(Context context) {
        super();
        inflater = LayoutInflater.from(context);
        this.data = inputData();

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_view_row, parent, false);
        System.out.println("View Holder Created");
        return new ItemViewHolder(view);
    }

    public void onBindViewHolder(ItemViewHolder holder, int position) {

        Item item = data.get(position);

        holder.title.setText(item.getName());
        holder.price.setText("$" + String.valueOf(item.getItemPrice()));
        holder.icon.setImageResource(item.getIconId());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public abstract List<Item> inputData();
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
