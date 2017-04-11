package com.github.vipulasri.timeline;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileHolder {

    @BindView(R.id.profile_img)
    ImageView mProfilePicture;
    @BindView(R.id.profile_name)
    TextView mName;

    public ProfileHolder(View view) {
        ButterKnife.bind(this, view);
    }
}
