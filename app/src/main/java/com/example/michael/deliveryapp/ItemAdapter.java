package com.example.michael.deliveryapp;

import android.content.Context;
import android.content.Intent;
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
    private Context context;
    private Item item;
    private boolean itemHasBeenSelected = false;
    private int position;

    /**
     * Created by michael on 11/9/2015.
     */
    public ItemAdapter(Context context) {
        super();
        inflater = LayoutInflater.from(context);
        this.data = inputData();
        this.context = context;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler_view_row, parent, false);
        System.out.println("View Holder Created");
        return new ItemViewHolder(view);
    }

    /**
     * This method merges the information (In this case the Item's name, price, and icon ID) passed
     * in from a given item with the specifications given from the ItemViewHolder's XML code so that
     * it can fit the format of a recycler view's layout.
     * <p/>
     * For example, The holder's Icon (Placed on the left of the recycler view row) will have it's
     * initialized icon (an android launcher icon) replaced with some item icon like a pizza to
     * represent food or a mustache to represent an item accessory.
     *
     * @param holder   The ItemViewHolder, which retrieves the XML layouts of TextViews or ImageViews
     *                 when constructed.
     * @param position The index of an Item inside of a subclass's list of items
     */
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        setPosition(position);

        Item anItem = data.get(position);
        holder.title.setText(anItem.getName());
        String a = "$" + String.valueOf(String.format("%.2f", anItem.getItemPrice()));
        holder.price.setText(a);
        holder.icon.setImageResource(anItem.getIconId());
    }

    public void setPosition(int num) {
        position = num;
    }


    @Override
    public int getItemCount() {

        return data.size();
    }

    public ItemIterator getIterator() {
        return new BaseItemIterator();
    }
    public abstract List<Item> inputData();
    /**
     * Created by michael on 11/9/2015.
     */
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView price;
        ImageView icon;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.item_name);
            icon = (ImageView) itemView.findViewById(R.id.item_icon);
            price = (TextView) itemView.findViewById(R.id.item_price);
        }


        public void onClick(View v) {
            Intent i;


            //gets the item selected
            item = data.get(getPosition());


            //targets the next activity to go to
            i = new Intent(context, SelectedItemViewer.class);
            //sends the given item
            i.putExtra("selected_item", item);
            //goes to the next activity
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    class BaseItemIterator implements ItemIterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public Item next() {
            if (this.hasNext()) {
                return data.get(index++);
            }
            return null;
        }
    }
}
