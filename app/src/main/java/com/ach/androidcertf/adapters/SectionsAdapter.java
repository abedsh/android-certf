package com.ach.androidcertf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ach.androidcertf.R;
import com.ach.androidcertf.models.SectionBean;

import java.util.ArrayList;

public class SectionsAdapter extends ArrayAdapter<SectionBean> {


    public SectionsAdapter(Context context, ArrayList<SectionBean> sections) {
        super(context, 0, sections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SectionBean sectionBean = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_section, parent, false);
        }
        // Lookup view for data population
        TextView tvName =  convertView.findViewById(R.id.item_section_title);
        // Populate the data into the template view using the data object
        tvName.setText(sectionBean.title);
        // Return the completed view to render on screen
        return convertView;
    }
}
