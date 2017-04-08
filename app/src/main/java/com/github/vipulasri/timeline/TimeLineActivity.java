package com.github.vipulasri.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.github.vipulasri.timeline.model.MESSAGE_TYPE;
import com.github.vipulasri.timeline.model.TimeLineModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP-HP on 05-12-2015.
 */
public class TimeLineActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(getString(R.string.vertical_timeline));

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(false);

        initView();
    }

    private void initView() {
        setDataListItems();
        mTimeLineAdapter = new TimeLineAdapter(mDataList);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    private void setDataListItems(){
        mDataList.add(new TimeLineModel("Profile Image", "2017-02-12 08:00", MESSAGE_TYPE.PROFILE_ITEM, R.mipmap.profile_icon, -1));
        mDataList.add(new TimeLineModel("Voice Memo", "2017-02-12 08:00", MESSAGE_TYPE.VOICE_MEMO, R.drawable.voice_memo_icon, -1));
        mDataList.add(new TimeLineModel("Screen Shot", "2017-02-11 21:00", MESSAGE_TYPE.SCREEN_SHOT, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Presentation Info", "2017-02-11 18:00", MESSAGE_TYPE.PRESENTATION_INFO, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Action Item", "2017-02-11 09:30", MESSAGE_TYPE.ACTION_ITEM, -1, R.mipmap.action_item_icon));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Menu
        switch (item.getItemId()) {
            //When home is clicked
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
