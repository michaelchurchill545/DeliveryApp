package com.example.michael.deliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created By not-Roben
 */
public class SelectedItemViewer extends AppCompatActivity {
    Item item = new Item("test", "description", 20.00, R.drawable.ic_action_mustache);

    public SelectedItemViewer(Item item) {
        this.item = item;
    }

    public SelectedItemViewer() {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_item_fragment);
        TextView title = (TextView) findViewById(R.id.item_name);
        TextView price = (TextView) findViewById(R.id.item_price);
        ImageView icon = (ImageView) findViewById(R.id.item_icon);
        String textValuePrice = "$" + String.valueOf(item.getItemPrice());
        title.setText(item.getName());
        price.setText(textValuePrice);
        icon.setImageResource(item.getIconId());
        

          /*Created By Michael*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        /*Created By Patrick Vu*/
        NavigationDrawerFragment fragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.selected_item_viewer_fragment_navigation_drawer);
        fragment.setUp(R.id.selected_item_viewer_fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        RecyclerView mDrawerRecycler = (RecyclerView) findViewById(R.id.navRecycler);
        DrawerRecyclerAdapter adapter = new DrawerRecyclerAdapter(getApplicationContext());

        mDrawerRecycler.setAdapter(adapter);
        mDrawerRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        /*Created By Michael*/
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }


    /**
     * Reacts when user presses "Add to Cart" button
     * Passes item to Shopping Cart activity
     */
    public void addToCart(View view) {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        intent.putExtra("cartitem", (Serializable) item);
        startActivity(intent);
    }
}
