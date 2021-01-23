package com.ach.androidcertf.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ach.androidcertf.R;
import com.ach.androidcertf.activities.MainActivity;
import com.ach.androidcertf.adapters.SectionsAdapter;
import com.ach.androidcertf.models.SectionBean;
import com.ach.androidcertf.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {


    public static final String KEY_SECTION_BEANS = "sectionBeans";

    public static FragmentList newInstance(List<SectionBean> sectionBeans) {

        Bundle args = new Bundle();
        args.putParcelableArrayList("sectionBeans", (ArrayList<? extends Parcelable>) sectionBeans);
        FragmentList fragment = new FragmentList();
        fragment.setArguments(args);
        return fragment;
    }

    ListView sectionsList;

    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        sectionsList = view.findViewById(R.id.fragment_list_lv);

        setupSections();
        return view;
    }


    private void setupSections() {
        if (getArguments() != null && getArguments().containsKey(KEY_SECTION_BEANS)) {
            final ArrayList<SectionBean> sectionBeans = getArguments().getParcelableArrayList(KEY_SECTION_BEANS);

            final SectionsAdapter sectionsAdapter = new SectionsAdapter(getContext(), sectionBeans);

            sectionsList.setAdapter(sectionsAdapter);

            sectionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    SectionBean sectionBean = sectionsAdapter.getItem(position);

                    if (sectionBean == null)
                        return;



                    if (!AppUtils.isEmpty(sectionBean.childList)) {
                        mainActivity.toNextFragmentList(sectionBean.childList);
                    } else if(!AppUtils.isEmpty(sectionBean.activityName)){
                        mainActivity.toNextActivity(sectionBean.activityName);
                    }


                }
            });
        }


    }


}
