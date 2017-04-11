package com.github.vipulasri.timeline;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vipulasri.timelineview.LineType;
import com.github.vipulasri.timelineview.TimelineView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeLineViewHolder {

    @BindView(R.id.text_timeline_date)
    TextView mDate;
    @BindView(R.id.text_timeline_title)
    TextView mMessage;
    @BindView(R.id.time_marker)
    TimelineView mTimelineView;
    @BindView(R.id.left_img)
    ImageView mLeftImage;
    @BindView(R.id.right_img)
    ImageView mRightImage;

    public TimeLineViewHolder(View view, int viewType) {
        ButterKnife.bind(this, view);
        mTimelineView.initLine(LineType.NORMAL);
        mTimelineView.setMarkerColor(R.color.colorPrimary);
    }
}
