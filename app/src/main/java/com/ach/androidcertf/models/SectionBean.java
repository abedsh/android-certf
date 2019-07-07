package com.ach.androidcertf.models;

import java.util.ArrayList;
import java.util.List;

public class SectionBean {

    public String title;
    public String activityName;
    public ArrayList<SectionBean> subList = new ArrayList<>();

    public SectionBean(String title, String activityName) {
        this.title = title;
        this.activityName = activityName;
    }

    public SectionBean(String title, ArrayList<SectionBean> subList) {
        this.title = title;
        this.subList = subList;
    }





}
