package com.github.vipulasri.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vipulasri.timeline.model.ProfileModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileAdapter extends ArrayAdapter<ProfileModel> {
    private final String TAG = "Huddl";
    private final List<ProfileModel> items;
    Resources res;
    Context context;

    public ProfileAdapter(List<ProfileModel> data, Context context) {
        super(context, -1, data);
        this.context = getContext();
        res = context.getResources();
        items = data;
    }

    @Override
    public int getCount(){
        return items != null ? items.size() : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProfileModel profileModel = getItem(position);
        ProfileHolder holder; // view lookup cache stored in tag

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.profile_item, parent, false);
            holder = new ProfileHolder(convertView);
            convertView.setTag(holder);
        }
        holder = (ProfileHolder) convertView.getTag();
        holder.mProfilePicture = (ImageView) convertView.findViewById(R.id.profile_img);
        holder.mName = (TextView) convertView.findViewById(R.id.profile_name);
        holder.mProfilePicture.setTag(profileModel.getProfileUrl());
        Picasso.with(context).load(profileModel.getProfileUrl()).into(holder.mProfilePicture);
        holder.mName.setText(profileModel.getName());
        return convertView;
    }
}
