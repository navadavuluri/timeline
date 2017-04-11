package com.github.vipulasri.timeline;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fm = getSupportFragmentManager();
//        // if savedInstanceState is null we do some cleanup
//        if (savedInstanceState != null) {
//            // cleanup any existing fragments in case we are in detailed mode
//            fm.executePendingTransactions();
//            Fragment fragment = (Fragment) getFragmentManager().findFragmentById(R.id.timeline);
//            if (fragment != null) {
//                getFragmentManager().beginTransaction().remove(fragment).commit();
//            }
//        }
//
//        //fm.beginTransaction().add(R.id.timeline, new TimeLineFragment()).commit();
//        fm.beginTransaction().add(R.id.webviewfrag, new TimeLineFragment()).commit();
    }

}
