package com.github.vipulasri.timeline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.vipulasri.timeline.model.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public class ProfilesFragment extends Fragment {
    private List<ProfileModel> mDataList = new ArrayList<>();

    private void setDataListItems(){
        mDataList.add(new ProfileModel("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAx8AAAAJGM0MGVkNjI3LTBmNWItNGRkYS1hNDA5LWMyMDBhYmNlZjAxNw.jpg", "Nava Davuluri"));
        mDataList.add(new ProfileModel("https://media.licdn.com/mpr/mpr/shrinknp_400_400/AAEAAQAAAAAAAAanAAAAJDQ5NTdkMTFjLTMwODAtNDk0Ny04MzA3LTkyODUxNjdiOGVkYg.jpg", "Krishna Yarlagadda"));
        mDataList.add(new ProfileModel("https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/2/000/00b/1d0/32d7913.jpg", "Doug Makishima"));
        mDataList.add(new ProfileModel("http://www.thekindlechronicles.com/wp-content/uploads/2011/08/DaveLimp11.jpg", "Dave Limp"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setDataListItems();
        View rootView = inflater.inflate(R.layout.profile_view, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.profiles);
        listView.setAdapter(new ProfileAdapter(mDataList, getContext()));
        return rootView;
    }
}


