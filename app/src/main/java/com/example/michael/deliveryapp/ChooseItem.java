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

/**
 * Created by Michael
 * The choose item activity is the magnum opus of the application, as it provides the user several stores
 * to choose from as well as a list of items that will show up every time a user clicks a specific store
 */
public class ChooseItem extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    /**
     * The onCreate method connects the activity to the proper XML files, as well as inflate the
     * application bar and Navigation Drawer fragment and attaches the appropriate change listeners
     * to any buttons that are instantiated.
     * In the case of the choose item activity,
     *
     * @param savedInstanceState is used to store data only for application lifetime (i.e. temporarily).
     */
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
     *  This method handles any "back" buttons or settings button clicks.
     * @param item the menu item clicked
     * @return a call to the super method with the proper menu item
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
                "Choose An Item", // TODO: Define a title for the content shown.
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


    /**
     * This Class is different from the other item adapters because, instead of merging the XML
     * content of items into Recycler (list) views, this pager item adapter merges the XML content
     * of items into swipeable tabs.
     */
    class StorePagerAdapter extends FragmentPagerAdapter {
        String[] stores;

        /**
         * Constructer that initializes the String[] stores with the XML string array of stores
         * in the XML string layout file
         *
         * @param fm
         */
        public StorePagerAdapter(FragmentManager fm) {
            super(fm);
            stores = getResources().getStringArray(R.array.stores);
        }

        /**
         * Getter of store titles at a given store
         *
         * @param position the index at stores[position]
         * @return the title of a store at a given position
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return stores[position];
        }

        /**
         * Getter that returns the tab at a given tab position
         * @param position the position
         * @return an instance of a fragment opened once a specific tab is clicked
         */
        @Override
        public Fragment getItem(int position) {
            return StoreFragment.getInstance(position);
        }

        /**
         * Getter that returns the length of the String[] stores list
         * @return the length of the String[] stores list
         */
        @Override
        public int getCount() {
            return stores.length;
        }
    }

    /*Created By Michael*/

    /**
     * This class creates a new fragment which includes a recycler view in it every time a tab is clicked.
     */
    public static class StoreFragment extends Fragment {
        private RecyclerView mRecyclerView;

        private AdapterFactory mAdapterFactory = new AdapterFactory();

        /**
         * Returns the correct fragment at the right position.
         * @param position the index where every store belongs to
         * @return a store fragment object
         */
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
         * @param savedInstanceState the saved data that the system uses to restore the previous
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
