package com.github.vipulasri.timeline;


import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.github.vipulasri.timeline.model.MESSAGE_TYPE;
import com.github.vipulasri.timeline.model.TimeLineModel;

import java.util.ArrayList;
import java.util.List;

public class TimeLineFragment extends ListFragment {
    private List<TimeLineModel> mDataList = new ArrayList<>();

    private void setDataListItems(){
        mDataList.add(new TimeLineModel("Profile Image", "2017-02-12 08:00", MESSAGE_TYPE.PROFILE_ITEM, R.mipmap.profile_icon, -1));
        mDataList.add(new TimeLineModel("Voice Memo", "2017-02-12 08:00", MESSAGE_TYPE.VOICE_MEMO, R.drawable.voice_memo_icon, -1));
        mDataList.add(new TimeLineModel("Screen Shot", "2017-02-11 21:00", MESSAGE_TYPE.SCREEN_SHOT, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Presentation Info", "2017-02-11 18:00", MESSAGE_TYPE.PRESENTATION_INFO, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Action Item", "2017-02-11 09:30", MESSAGE_TYPE.ACTION_ITEM, -1, R.mipmap.action_item_icon));
        mDataList.add(new TimeLineModel("Profile Image", "2017-02-12 08:00", MESSAGE_TYPE.PROFILE_ITEM, R.mipmap.profile_icon, -1));
        mDataList.add(new TimeLineModel("Voice Memo", "2017-02-12 08:00", MESSAGE_TYPE.VOICE_MEMO, R.drawable.voice_memo_icon, -1));
        mDataList.add(new TimeLineModel("Screen Shot", "2017-02-11 21:00", MESSAGE_TYPE.SCREEN_SHOT, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Presentation Info", "2017-02-11 18:00", MESSAGE_TYPE.PRESENTATION_INFO, -1, R.mipmap.screenshot_icon));
        mDataList.add(new TimeLineModel("Action Item", "2017-02-11 09:30", MESSAGE_TYPE.ACTION_ITEM, -1, R.mipmap.action_item_icon));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDataListItems();
        TimeLineAdapter adapter = new TimeLineAdapter(mDataList, getContext());
        setListAdapter(adapter);
    }
}
