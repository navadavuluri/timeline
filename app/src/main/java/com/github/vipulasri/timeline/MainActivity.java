package com.github.vipulasri.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HP-HP on 07-06-2016.
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.verticalTimeLineButton)
    Button mVerticalTimeLineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        mVerticalTimeLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });

    }

    private void onButtonClick() {
        Intent intent = new Intent(this, TimeLineActivity.class);
        startActivity(intent);
    }

}
