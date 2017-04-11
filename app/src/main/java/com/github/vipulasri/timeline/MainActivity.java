package com.github.vipulasri.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends FragmentActivity {
    private FragmentManager fm;

    private void intentResolve(Intent intent) {
        String jsonObject = intent.getStringExtra("jsonObject");
        try {
            JSONObject obj = new JSONObject(jsonObject);
            String type = obj.optString("type");
            if (type.equals("voice")) {
                String memoUrl = obj.getString("memo");
                String memoText = obj.getString("text");
            } else if (type.equals("sales")) {
                String query = obj.getString("query");
            } else if (type.equals("presentation")) {
                String presentationUrl = obj.getString("url");
            } else if (type.equals("participant")) {
                String img = obj.getString("img");
                String name = obj.getString("name");
            } else if (type.equals("query")) {
                String query = obj.getString("query");
                String resp = obj.getString("resp");
            } else {

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void addVoiceMemo(String memoUrl, String memoText) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Get the Intent that started this activity and extract the string
//        intentResolve(getIntent());
//        fm = getSupportFragmentManager();
//        fm.beginTransaction()
//                .add(R.id.timeline, new TimeLineFragment())
//                .
//                .commit();
//        fm.beginTransaction().add(R.id.webviewfrag, new TimeLineFragment()).commit();
    }

    private TimeLineFragment getTimelineFragment() {
        return (TimeLineFragment) fm.findFragmentById(R.id.timeline);
    }

}
