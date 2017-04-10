package com.github.vipulasri.timeline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import com.github.vipulasri.timeline.model.TimeLineModel;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import static android.view.View.GONE;


public class TimeLineAdapter extends ArrayAdapter<TimeLineModel> {

    private List<TimeLineModel> dataSet;
    Context mContext;

    public TimeLineAdapter(List<TimeLineModel> data, Context context) {
        super(context, R.layout.activity_timeline, data);
        this.dataSet  = data;
        this.mContext = context;

    }

    private int lastPosition = -1;

    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getCount());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TimeLineModel timeLineModel = getItem(position);
        TimeLineViewHolder holder; // view lookup cache stored in tag
        final View result;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_timeline, parent, false);
            holder = new TimeLineViewHolder(convertView, getItemViewType(position));
            holder.mDate.setText(timeLineModel.getDate());
            holder.mMessage.setText(timeLineModel.getMessage());
            result = convertView;
            convertView.setTag(holder);
        } else {
            holder = (TimeLineViewHolder) convertView.getTag();
            holder.mDate.setText(timeLineModel.getDate());
            holder.mMessage.setText(timeLineModel.getMessage());
            result = convertView;
        }

        switch (timeLineModel.getStatus()) {
            case PROFILE_ITEM:
                holder.mLeftImage.setImageResource(R.mipmap.profile_icon);
                holder.mLeftImage.requestLayout();
                holder.mLeftImage.getLayoutParams().height = 48;
                holder.mRightImage.setVisibility(GONE);
                break;
            case ACTION_ITEM:
                holder.mRightImage.setImageResource(R.mipmap.action_item_icon);
                holder.mRightImage.requestLayout();
                holder.mRightImage.getLayoutParams().height = 48;
                holder.mLeftImage.setVisibility(GONE);
                break;
            case VOICE_MEMO:
                holder.mLeftImage.setImageResource(R.drawable.voice_memo_icon);
                holder.mLeftImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                holder.mLeftImage.requestLayout();
                holder.mLeftImage.getLayoutParams().height = 48;
                holder.mRightImage.setVisibility(GONE);
                break;
            case SCREEN_SHOT:
                holder.mRightImage.setImageResource(R.mipmap.screenshot_icon);
                holder.mRightImage.requestLayout();
                holder.mRightImage.getLayoutParams().width = 200;
                holder.mLeftImage.setVisibility(GONE);
                break;
            case PRESENTATION_INFO:
                holder.mRightImage.setImageResource(R.mipmap.presentation_icon);
                holder.mRightImage.requestLayout();
                holder.mRightImage.getLayoutParams().width = 200;
                holder.mLeftImage.setVisibility(GONE);
                break;
            default: break;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        // Return the completed view to render on screen
        return convertView;
    }
}
