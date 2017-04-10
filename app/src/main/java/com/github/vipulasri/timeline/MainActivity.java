package com.github.vipulasri.timeline;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        // to give support on lower android version, we are not calling getFragmentManager()
        FragmentManager fm = getSupportFragmentManager();

        // Create the list fragment and add it as our sole content.
        if (fm.findFragmentById(android.R.id.content) == null) {
            TimeLineFragment list = new TimeLineFragment();
            fm.beginTransaction().add(android.R.id.content, list).commit();
        }
    }

}
