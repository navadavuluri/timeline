package com.github.vipulasri.timeline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.vipulasri.timeline.model.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public class ProfilesFragment extends Fragment {

    private List<ProfileModel> initData(){
        List<ProfileModel> mDataList = new ArrayList<>();
        mDataList.add(new ProfileModel("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAx8AAAAJGM0MGVkNjI3LTBmNWItNGRkYS1hNDA5LWMyMDBhYmNlZjAxNw.jpg", "Nava Davuluri"));
        mDataList.add(new ProfileModel("https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAAanAAAAJDQ5NTdkMTFjLTMwODAtNDk0Ny04MzA3LTkyODUxNjdiOGVkYg.jpg", "Krishna Yarlagadda"));
        mDataList.add(new ProfileModel("https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/2/000/00b/1d0/32d7913.jpg", "Doug Makishima"));
        mDataList.add(new ProfileModel("http://www.thekindlechronicles.com/wp-content/uploads/2011/08/DaveLimp11.jpg", "Dave Limp"));
        return mDataList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_view, container, false);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.profiles);
        ProfileAdapter adapter = new ProfileAdapter(getContext(), initData());
        for( int i=0; i < adapter.getCount(); i++) {
            linearLayout.addView(adapter.getView(i, null, linearLayout), i);
        }
        return rootView;
    }
}


