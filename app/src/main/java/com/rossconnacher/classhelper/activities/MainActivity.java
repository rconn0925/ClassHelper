package com.rossconnacher.classhelper.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rossconnacher.classhelper.R;
import com.rossconnacher.classhelper.fragments.DocumentCreatorFragment;
import com.rossconnacher.classhelper.fragments.FolderFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    DocumentCreatorFragment.OnFragmentInteractionListener,
                    FolderFragment.OnFragmentInteractionListener{


    FragmentManager mFragmentManager;

    @InjectView(R.id.nav_view)
    public NavigationView mNavigationView;
    @InjectView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;
    @InjectView(R.id.toolbar)
    public Toolbar mToolbar;
    @InjectView(R.id.bottom_navigation)
    public BottomNavigationView mBottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment currentFrag = null;
                if(id == R.id.bottom_nav_doc_creator){
                    currentFrag = DocumentCreatorFragment.newInstance();
                } else if (id == R.id.bottom_nav_folders){
                    currentFrag = FolderFragment.newInstance();
                }
                mFragmentManager.beginTransaction().replace(R.id.contentFrame, currentFrag).commit();
                return true;
            }
        });

        mFragmentManager = getSupportFragmentManager();
        Fragment currentFrag = DocumentCreatorFragment.newInstance();
        mFragmentManager.beginTransaction().replace(R.id.contentFrame, currentFrag).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment currentFrag = null;

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
