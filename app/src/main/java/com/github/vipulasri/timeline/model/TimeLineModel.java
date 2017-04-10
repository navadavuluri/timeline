package com.github.vipulasri.timeline.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TimeLineModel implements Parcelable {

    private String mMessage;
    private String mDate;
    private int mLeftImg;
    private int mRightImg;
    private MESSAGE_TYPE mStatus;

    public TimeLineModel() {
    }

    public TimeLineModel(String mMessage, String mDate, MESSAGE_TYPE mStatus, int mLeftImg, int mRightImg) {
        this.mMessage = mMessage;
        this.mDate = mDate;
        this.mStatus = mStatus;
        this.mLeftImg = mLeftImg;
        this.mRightImg = mRightImg;
    }

    public String getMessage() {
        return mMessage;
    }

    public void semMessage(String message) {
        this.mMessage = message;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public MESSAGE_TYPE getStatus() {
        return mStatus;
    }

    public void setStatus(MESSAGE_TYPE mStatus) {
        this.mStatus = mStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mMessage);
        dest.writeString(this.mDate);
        dest.writeInt(this.mStatus == null ? -1 : this.mStatus.ordinal());
    }

    protected TimeLineModel(Parcel in) {
        this.mMessage = in.readString();
        this.mDate = in.readString();
        int tmpMStatus = in.readInt();
        this.mStatus = tmpMStatus == -1 ? null : MESSAGE_TYPE.values()[tmpMStatus];
    }

    public static final Parcelable.Creator<TimeLineModel> CREATOR = new Parcelable.Creator<TimeLineModel>() {
        @Override
        public TimeLineModel createFromParcel(Parcel source) {
            return new TimeLineModel(source);
        }

        @Override
        public TimeLineModel[] newArray(int size) {
            return new TimeLineModel[size];
        }
    };
}
