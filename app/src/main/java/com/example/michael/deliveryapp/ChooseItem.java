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

import com.example.michael.deliveryapp.AdaptersForDifferentStores.AdapterFactory;
import com.example.michael.deliveryapp.tabs.SlidingTabLayout;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.InvocationTargetException;

public class ChooseItem extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_item);


        /*Created By Michael*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        /*Created By Patrick Vu*/
        NavigationDrawerFragment fragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.choose_item_fragment_navigation_drawer);
        fragment.setUp(R.id.choose_item_fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        /*Created By Michael*/
        SlidingTabLayout tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new StorePagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(pager);


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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
            return StoreFragment.getInstance(position);
        }

        @Override
        public int getCount() {
            return stores.length;
        }
    }

    /*Created By Michael*/
    public static class StoreFragment extends Fragment {
        private RecyclerView mRecyclerView;

        private AdapterFactory mAdapterFactory = new AdapterFactory();

        public static StoreFragment getInstance(int position) {
            {
                StoreFragment storeFragment = new StoreFragment();
                Bundle args = new Bundle();
                args.putInt("position", position);
                storeFragment.setArguments(args);

                return storeFragment;
            }


        }

        /**
         * Every time a new store tab is clicked or swiped, this method creates
         * a fragment and instantiates a recycler view of items inside of it.
         * An adapter with items unique to the specific store tab swiped to
         * is set to the Recycler View
         *
         * @param inflater           A view that gets the XML layout with the correct specifications to show
         *                           a recycler view that contains the elements of the store selected. The selected store
         * @param container          A View Group (which is a view that contains views inside of it
         *                           called "children") whose children are the rows of a recycler view.
         * @param savedInstanceState he saved data that the system uses to restore the previous
         *                           state is called the "instance state" and is a collection of key-value pairs stored
         *                           in a Bundle object.
         * @return A layout formatted as a Recycler View.
         */
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.store_fragment, container, false);
            Bundle bundle = getArguments();
            int position = bundle.getInt("position");
            mRecyclerView = (RecyclerView) layout.findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            try {
                mRecyclerView.setAdapter(mAdapterFactory.createAdapter(position, getContext()));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return layout;
        }
    }
}
