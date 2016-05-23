package com.travelsoft.lanka.travel_guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.travelsoft.lanka.travel_guide.fragments.HomeFragment;
import com.travelsoft.lanka.travel_guide.fragments.PlaceDetailsFragment;
import com.travelsoft.lanka.travel_guide.fragments.PlacesHomeFragment;
import com.travelsoft.lanka.travel_guide.interfaces.GridViewCell;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, PlacesHomeFragment.OnFragmentInteractionListener, PlaceDetailsFragment.OnFragmentInteractionListener {

    private GridViewCell clickedGridCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment homeFragment = HomeFragment.newInstance("HomeFrag", "Welcome");
        setFragment(savedInstanceState, homeFragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    protected void setFragment(Bundle savedInstanceState, Fragment nextFragment) {
        if (savedInstanceState == null) {

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_main, nextFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Fragment nextFragment) {
        setFragment(null, nextFragment);
    }
}
