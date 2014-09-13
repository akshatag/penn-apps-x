package com.pennapps.brady.smingle;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    private static final String TAG = "FragMainActivity";

    private ActionBar actionBar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                Log.e(TAG, "onPageScrolled at position " + i + " from " + v + " with number of pixels " + i2);
            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
                Log.e(TAG, "onPageSelection at position " + i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Log.e(TAG, "onPageScrollStateChanged at position " + i);
            }
        });

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab quizTab = actionBar.newTab();
        quizTab.setText("Quizzes");
        quizTab.setTabListener(this);

        ActionBar.Tab addContactTab = actionBar.newTab();
        addContactTab.setText("Add Contact");
        addContactTab.setTabListener(this);

        ActionBar.Tab profilesTab = actionBar.newTab();
        profilesTab.setText("Profiles");
        profilesTab.setTabListener(this);

        actionBar.addTab(quizTab);
        actionBar.addTab(addContactTab);
        actionBar.addTab(profilesTab);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
//        Log.e(TAG, "onTabSelected at position: " + tab.getPosition() + " name: " + tab.getText());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.e(TAG, "onTabUnselected at position: " + tab.getPosition() + " name: " + tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//        Log.e(TAG, "onTabReselected at position: " + tab.getPosition() + " name: " + tab.getText());
    }
}