package com.github.vipulasri.timeline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewGroupCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.vipulasri.timeline.model.MESSAGE_TYPE;
import com.github.vipulasri.timeline.model.TimeLineModel;

import java.util.ArrayList;
import java.util.List;

public class TimeLineFragment extends Fragment {
    private List<TimeLineModel> mDataList = new ArrayList<>();

    private void setDataListItems(){
        mDataList.add(new TimeLineModel("Profile Image 1", "2017-02-12 08:00", MESSAGE_TYPE.PROFILE_ITEM, R.mipmap.profile_icon, -1));
        mDataList.add(new TimeLineModel("Voice Memo 2", "2017-02-12 08:00", MESSAGE_TYPE.VOICE_MEMO, R.drawable.voice_memo_icon, -1));
        mDataList.add(new TimeLineModel("Screen Shot 3", "2017-02-11 21:00", MESSAGE_TYPE.SCREEN_SHOT, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Presentation Info 4", "2017-02-11 18:00", MESSAGE_TYPE.PRESENTATION_INFO, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Action Item 5", "2017-02-11 09:30", MESSAGE_TYPE.ACTION_ITEM, -1, R.mipmap.action_item_icon));
        mDataList.add(new TimeLineModel("Profile Image 6", "2017-02-12 08:00", MESSAGE_TYPE.PROFILE_ITEM, R.mipmap.profile_icon, -1));
        mDataList.add(new TimeLineModel("Voice Memo 7", "2017-02-12 08:00", MESSAGE_TYPE.VOICE_MEMO, R.drawable.voice_memo_icon, -1));
        mDataList.add(new TimeLineModel("Screen Shot 8", "2017-02-11 21:00", MESSAGE_TYPE.SCREEN_SHOT, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Presentation Info 9", "2017-02-11 18:00", MESSAGE_TYPE.PRESENTATION_INFO, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Action Item 10", "2017-02-11 09:30", MESSAGE_TYPE.ACTION_ITEM, -1, R.mipmap.action_item_icon));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setDataListItems();
        View rootView = inflater.inflate(R.layout.activity_timeline, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(new TimeLineAdapter(mDataList, getContext()));
        return rootView;
    }
}
