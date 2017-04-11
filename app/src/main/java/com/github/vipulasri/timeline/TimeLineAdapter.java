package com.github.vipulasri.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;

import com.github.vipulasri.timeline.model.MESSAGE_TYPE;
import com.github.vipulasri.timeline.model.TimeLineModel;
import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import static android.view.KeyEvent.KEYCODE_BUTTON_SELECT;
import static android.view.View.GONE;


public class TimeLineAdapter extends ArrayAdapter<TimeLineModel> {
    private final String TAG = "Huddl";
    private final List<TimeLineModel> items;
    MediaPlayer mPlayer = new MediaPlayer();
    String url = "http://programmerguru.com/android-tutorial/wp-content/uploads/2013/04/hosannatelugu.mp3";
    Resources res;

    public TimeLineAdapter(List<TimeLineModel> data, Context context) {
        super(context, -1, data);
        this.mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        res = context.getResources();
        items = data;
    }

    private int lastPosition = -1;

    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position, getCount());
    }

    private void voiceMemoPlayToggle(KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == KEYCODE_BUTTON_SELECT) {
            Log.d(TAG, "Remote button");
        } else {
            Log.d(TAG, "Tap");
        }
        if (!mPlayer.isPlaying()) {
            Log.d(TAG, "Starting");
            mPlayer.start();
        } else {
            Log.d(TAG, "Stopped");
            mPlayer.pause();
        }
    }

    private void setUpVoiceMemoClick(View view, String url) {
        try {
            //TODO: url needs to be set dynamically
            mPlayer.setDataSource(url);
            mPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voiceMemoPlayToggle(null);
            }
        });
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
            if (timeLineModel.getStatus() == MESSAGE_TYPE.VOICE_MEMO) {
                setUpVoiceMemoClick(convertView, url);
            }
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

        Animation animation = AnimationUtils.loadAnimation(parent.getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        // Return the completed view to render on screen
        return convertView;
    }
}
