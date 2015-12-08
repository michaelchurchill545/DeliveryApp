package com.example.michael.deliveryapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created By Patrick Vu
 * The navigation drawer fragment is used to be a directory for the user, so they can jump to any of the
 * main parts of the page without having to continuously press the 'back' button. It is a staple of
 * convinience in our app.
 *
 */
public class NavigationDrawerFragment extends Fragment {
    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View containerView;
    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    /**
     * Creates the navigation drawer and checks if the user has opened or closed it for the first time.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext().getClass() == Home.class) {
            mUserLearnedDrawer = Boolean.valueOf(readFromPreference(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        } else {
            mUserLearnedDrawer = Boolean.valueOf(readFromPreference(getActivity(), KEY_USER_LEARNED_DRAWER, "true"));
        }
if(savedInstanceState!=null){
    mFromSavedInstanceState=true;
}

    }

    /**
     * creates the view with the list of items inside of it.
     *
     * @param inflater           grabs the correct XML layout file
     * @param container          the frame that will hold all of the Navigation item rows
     * @param savedInstanceState the saved data that the system uses to restore the previous
     *                           state is called the "instance state" and is a collection of key-value pairs stored
     *                           in a Bundle object.
     * @return the correct XML layout file
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    /**
     * This creates an actionbar drawer toggle(the little hamburger on the upper left screen)
     * as well as instantiates a recycler view inside of the fragment and adds change listeners
     * to the ABDT.
     * <p/>
     * Creates and runs a thread when the drawer is opened
     *
     * @param fragmentId
     * @param drawerLayout
     * @param toolbar
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        containerView=getActivity().findViewById(fragmentId);
        mDrawerLayout=drawerLayout;

        mDrawerToggle= new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
               if(!mUserLearnedDrawer){
                   mUserLearnedDrawer=true;
                   saveToPreference(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer+"");
                   getActivity().invalidateOptionsMenu();
               }
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
               getActivity().invalidateOptionsMenu();
            }
        };
        if(!mUserLearnedDrawer&& !mFromSavedInstanceState){
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    /**
     * When the user closes the navigation drawer for the first time, it lets the program know not to
     * immediately open the nav drawer when the activity is created anymore.
     * @param context
     * @param preferenceName
     * @param preferenceValue
     */
    public void saveToPreference(Context context, String preferenceName, String preferenceValue){
        SharedPreferences sharedPreferences= context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.commit();
    }

    /**
     * This checks if the user has closed the navigation drawer yet in the activity at any point in time.
     * If they have, the navigation drawer will not immediately open when the activity is visited.
     * @param context
     * @param preferenceName
     * @param defaultValue
     * @return
     */
    public static String readFromPreference(Context context, String preferenceName, String defaultValue){
        SharedPreferences sharedPreferences= context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
       return sharedPreferences.getString(preferenceName, defaultValue);

    }

}
