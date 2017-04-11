package com.github.vipulasri.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vipulasri.timeline.model.ProfileModel;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class ProfileAdapter extends BaseAdapter {
    private final String TAG = "Huddl";
    private final List<ProfileModel> items;
    Resources res;
    Context context;

    public ProfileAdapter(Context context, List<ProfileModel> data) {
        this.context = context;
        res = context.getResources();
        items = data;
    }

    @Override
    public int getCount(){
        return items != null ? items.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProfileModel profileModel = (ProfileModel) getItem(position);
        ProfileHolder holder; // view lookup cache stored in tag

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
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
