package com.example.michael.deliveryapp;

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
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Roben on 11/30/2015.
 */
public class ShoppingCartActivity extends AppCompatActivity {
    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayList<Item> cartItems = new ArrayList<>();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        /*Created By Michael*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        /*Created By Patrick Vu*/
        NavigationDrawerFragment fragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.shopping_cart_fragment_navigation_drawer);
        fragment.setUp(R.id.shopping_cart_fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        RecyclerView mDrawerRecycler = (RecyclerView) findViewById(R.id.navRecycler);
        DrawerRecyclerAdapter adapter = new DrawerRecyclerAdapter(getApplicationContext());

        mDrawerRecycler.setAdapter(adapter);
        mDrawerRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        /*Created By Michael*/
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
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

        //Item cartitem = (Item) getIntent().getSerializableExtra("cartitem");
        Item cartitem = new Item("Example", "Example", 0, R.drawable.example_item);
        this.addItem(cartitem);

        ArrayList<Item> itemstoshow = this.getItems();
        ListView cartView = (ListView) findViewById(R.id.cart_list);
        cartView.setAdapter(new ShoppingCartAdapter(this, itemstoshow));
        Button paybutton = (Button) findViewById(R.id.pay_now);
        String subTot = "Subtotal: " + getSubtotal();
        paybutton.setText(subTot);
    }

    //<<<<<<< HEAD
    // =======
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    //>>>>>>> origin/master
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addItem(Item item) {
        cartItems.add(item);
    }

    public void removeItem(Item item) {
        cartItems.remove(item);
    }

    public String getSubtotal() {
        double subtotal = 0;
        if (cartItems != null) {
            for (Item ca : cartItems) {
                subtotal += ca.getItemPrice();
            }
        }

        return "$" + String.valueOf(String.format("%.2f", subtotal));
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> cartitems = new ArrayList<>();
        double pizzaprice = 2.50;
        double iconid = 3.33;
        Item pizza = new Item("Pizza", "Cheesy cheesy cheesy", pizzaprice, (int) iconid);
        Item hamburger = new Item("Hamburger", "Life between two buns", pizzaprice, (int) iconid);
        Item salad = new Item("Salad", "Healthy Greens", pizzaprice, (int) iconid);
        Item donut = new Item("Donut", "Best Way to Start Your Breakfast", pizzaprice, (int) iconid);
        Item drink = new Item("Drink", "Something to wash down the greatness", pizzaprice, (int) iconid);
        cartitems.add(pizza);
        cartitems.add(hamburger);
        cartitems.add(salad);
        cartitems.add(donut);
        cartitems.add(drink);
        return cartitems;
    }


}