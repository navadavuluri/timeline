package com.github.vipulasri.timeline;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.vipulasri.timeline.model.TimeLineModel;
import com.github.vipulasri.timeline.utils.DateTimeUtils;
import com.github.vipulasri.timeline.utils.VectorDrawableUtils;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import static android.view.View.GONE;

/**
 * Created by HP-HP on 05-12-2015.
 */
public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private List<TimeLineModel> mFeedList;
    private Context mContext;

    public TimeLineAdapter(List<TimeLineModel> feedList) {
        mFeedList = feedList;
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_timeline, parent, false);
        return new TimeLineViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        holder.mTimelineView.setMarker(VectorDrawableUtils.getDrawable(mContext, R.drawable.ic_marker_active, R.color.colorPrimary));
        TimeLineModel timeLineModel = mFeedList.get(position);
        switch (timeLineModel.getStatus()) {
            case PROFILE_ITEM:
                holder.mLeftImage.setImageResource(R.mipmap.profile_icon);
                holder.mLeftImage.requestLayout();
                holder.mLeftImage.getLayoutParams().height = 30;
                holder.mLeftImage.getLayoutParams().width = 30;
                holder.mRightImage.setVisibility(GONE);
                break;
            case ACTION_ITEM:
                holder.mRightImage.setImageResource(R.mipmap.action_item_icon);
                holder.mRightImage.requestLayout();
                holder.mRightImage.getLayoutParams().height = 30;
                holder.mRightImage.getLayoutParams().width = 30;
                holder.mLeftImage.setVisibility(GONE);
                break;
            case VOICE_MEMO:
                holder.mLeftImage.setImageResource(R.drawable.voice_memo_icon);
                holder.mLeftImage.requestLayout();
                holder.mLeftImage.getLayoutParams().height = 30;
                holder.mLeftImage.getLayoutParams().width = 30;
                holder.mRightImage.setVisibility(GONE);
                break;
            case SCREEN_SHOT:
                holder.mRightImage.setImageResource(R.mipmap.screenshot_icon);
                holder.mRightImage.requestLayout();
                holder.mRightImage.getLayoutParams().height = 60;
                holder.mRightImage.getLayoutParams().width = 60;
                holder.mLeftImage.setVisibility(GONE);
                break;
            case PRESENTATION_INFO:
                holder.mRightImage.setImageResource(R.mipmap.presentation_icon);
                holder.mRightImage.requestLayout();
                holder.mRightImage.getLayoutParams().height = 60;
                holder.mRightImage.getLayoutParams().width = 60;
                holder.mLeftImage.setVisibility(GONE);
                break;
            default: break;
        }

        holder.mDate.setVisibility(View.VISIBLE);
        holder.mDate.setText(DateTimeUtils.parseDateTime(timeLineModel.getDate(), "yyyy-MM-dd HH:mm", "hh:mm a, dd-MMM-yyyy"));
        holder.mMessage.setText(timeLineModel.getMessage());
    }

    @Override
    public int getItemCount() {
        return (mFeedList!=null? mFeedList.size():0);
    }

}
