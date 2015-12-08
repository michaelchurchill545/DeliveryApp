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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Roben on 11/30/2015.
 * This activity displays the a list of items that the user wants to buy, as well as a button at the bottom
 * that displays the subtotal cost of the items
 */
public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener {
    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayList<Item> cartItems = new ArrayList<>();

    /**
     * The onCreate method connects the activity to the proper XML files, as well as inflate the
     * application bar and Navigation Drawer fragment and attaches the appropriate change listeners
     * to any buttons that are instantiated.
     * In the case of the shopping cart activity,
     *
     * @param savedInstanceState is used to store data only for application lifetime (i.e. temporarily).
     */
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


        if (savedInstanceState == null || !savedInstanceState.containsKey("itemlist")) {
            Intent getIntent = getIntent();
            if (getIntent.getExtras() != null) {
                Item additem = getIntent().getParcelableExtra("cartitem");
                cartItems.add(additem);
            }
        } else {
            cartItems = savedInstanceState.getParcelableArrayList("itemlist");
            Intent getIntent = getIntent();
            if (getIntent.getExtras() != null) {
                Item additem = getIntent().getParcelableExtra("cartitem");
                cartItems.add(additem);
            }
        }
        ListView cartView = (ListView) findViewById(R.id.cart_list);
        cartView.setAdapter(new ShoppingCartAdapter(this, cartItems));
        Button paybutton = (Button) findViewById(R.id.pay_now);
        String subTot = "" + this.getSubtotal();
        paybutton.setText(subTot);
        paybutton.setOnClickListener(this);
    }

    //<<<<<<< HEAD
    // =======
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    protected void onSaveInstanceState(Bundle outState) {

        outState.putParcelableArrayList("itemlist", cartItems);
        super.onSaveInstanceState(outState);
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

    public String getSubtotal() {
        double subtotal = 0;
        if (cartItems.size() > 0) {
            for (int i = 0; i < cartItems.size(); i++) {
                subtotal += cartItems.get(i).getItemPrice();
            }
        }

        return "Pay Now: $" + String.valueOf(String.format("%.2f", subtotal));
    }


    @Override
    public void onClick(View v) {
        //Toast.makeText(getApplicationContext(), "Order Sent!",
                //Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, PaymentPayPal.class));
    }
}