package com.github.vipulasri.timeline.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by navadavuluri on 4/11/17.
 */

public class ProfileModel implements Parcelable {
    private String profileUrl;
    private String name;

    public ProfileModel(String profileUrl, String name) {
        this.profileUrl = profileUrl;
        this.name = name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.profileUrl);
        dest.writeString(this.name);
    }

    protected ProfileModel(Parcel in) {
        this.profileUrl = in.readString();
        this.name = in.readString();
    }


    public static final Parcelable.Creator<com.github.vipulasri.timeline.model.ProfileModel> CREATOR = new Parcelable.Creator<com.github.vipulasri.timeline.model.ProfileModel>() {
        @Override
        public ProfileModel createFromParcel(Parcel source) {
            return new ProfileModel(source);
        }

        @Override
        public ProfileModel[] newArray(int size) {
            return new ProfileModel[size];
        }
    };
}

