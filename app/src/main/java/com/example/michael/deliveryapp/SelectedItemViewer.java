package com.example.michael.deliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created By not-Roben
 */
public class SelectedItemViewer extends AppCompatActivity {
    Item item = new Item("test", "description", 20.00, 1);
    public SelectedItemViewer(Item item){
        this.item=item;
    }

    public SelectedItemViewer(){

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_item_fragment);
        TextView title =(TextView) findViewById(R.id.item_name);
        TextView description = (TextView)findViewById(R.id.item_description);
        TextView price = (TextView) findViewById(R.id.item_price);
        ImageView icon = (ImageView) findViewById(R.id.item_icon);

        title.setText(item.getName());
        description.setText(item.getDescription());
        price.setText("$"+item.getItemPrice());
        icon.setImageResource(item.getIconId());
    }

//
//    /**
//     * Reacts when user presses "Add to Cart" button
//     * Passes item to Shopping Cart activity
//     */
//    public void addToCart(View view) {
//        Intent intent = new Intent(this, ShoppingCartActivity.class);
//        intent.putExtra("cartitem", (Serializable)item);
//        startActivity(intent);
//    }
}
