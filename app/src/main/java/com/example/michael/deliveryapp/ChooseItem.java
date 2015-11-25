package com.example.michael.deliveryapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.michael.deliveryapp.tabs.SlidingTabLayout;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class ChooseItem extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    RecyclerView mDrawerRecycler;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private SlidingTabLayout tabs;
    private ViewPager pager;
    ArrayList<NavigationItem> mNavItems = new ArrayList<NavigationItem>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_item);
        /*Created By Roben*/
        recyclerView = (RecyclerView) findViewById(R.id.choose_item_list);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        adapter = new ItemAdapter(getApplicationContext(), getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.notifyDataSetChanged();

        /*Created By Michael*/
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        /*Created By Patrick Vu*/
        NavigationDrawerFragment fragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.choose_item_fragment_navigation_drawer);
        fragment.setUp(R.id.choose_item_fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        /*Created By Michael*/
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new StorePagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(pager);

        mNavItems.add(new NavigationItem("Choose Store", "Select an item from a store", R.drawable.example_item));
        mNavItems.add(new NavigationItem("Shopping Cart", "View the items you want to buy", R.drawable.example_item));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerRecycler = (RecyclerView) findViewById(R.id.navRecycler);
        DrawerRecyclerAdapter adapter = new DrawerRecyclerAdapter(getApplicationContext(), mNavItems);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*Created By Michael*/
    public static List<Item> getData() {
        List<Item> data = new ArrayList<>();
        int[] iconId = {R.drawable.example_item, R.drawable.example_item, R.drawable.example_item, R.drawable.example_item, R.drawable.example_item};
        String[] itemNames = {"Fajita", "Cahones", "Burger", "Bald Eagles", "Communism"};
        String[] itemPrice = {"$10.43", "$1.43", "$10.43", "$10.43", "$666.66"};
        for (int i = 0; i < iconId.length && i < itemNames.length && i < itemPrice.length; i++) {
            Item current = new Item(itemNames[i], "description", itemPrice[i], iconId[i]);
            System.out.println(itemNames[i] + " added to the list");
            data.add(current);
        }
        return data;

    }

    /**
     * Created by Michael
     * Creates the Action Bar buttons
     *
     * @param menu the menu
     * @return true that the menu is visible
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_item, menu);

        return true;
    }

    /**
     * Created by Michael
     *
     * @param item
     * @return
     */
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
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ChooseItem Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.michael.deliveryapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ChooseItem Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.michael.deliveryapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    /*Created By Michael*/
    class StorePagerAdapter extends FragmentPagerAdapter {
        String[] stores;

        public StorePagerAdapter(FragmentManager fm) {
            super(fm);
            stores = getResources().getStringArray(R.array.stores);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return stores[position];
        }

        @Override
        public Fragment getItem(int position) {
            PagerFragment pagerFragment = PagerFragment.getInstance(position);
            return pagerFragment;
        }

        @Override
        public int getCount() {
            return stores.length;
        }
    }

    public static class PagerFragment extends Fragment {

        private TextView store;

        public static PagerFragment getInstance(int position) {
            {
                PagerFragment pagerFragment = new PagerFragment();
                Bundle args = new Bundle();
                args.putInt("position", position);
                pagerFragment.setArguments(args);

                return new PagerFragment();
            }


        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.store_fragment, container, false);
            //in slide nerd video it's called R.id.position
            store = (TextView) layout.findViewById(R.id.position);
            Bundle bundle = getArguments();
            if (bundle != null) {
                store.setText("The Store Selected is " + bundle.getInt("position"));
            }
            return layout;
        }
    }
}
