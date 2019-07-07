package com.ach.androidcertf.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class SectionBean implements Parcelable {

    public String title; // title of list item
    public String activityName; // activity name to start
    public ArrayList<SectionBean> childList = new ArrayList<>();  // sub list to be displayed if available

    public SectionBean(String title, String activityName) {
        this.title = title;
        this.activityName = activityName;
    }

    public SectionBean(String title, ArrayList<SectionBean> subList) {
        this.title = title;
        this.childList = subList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.activityName);
        dest.writeTypedList(this.childList);
    }

    protected SectionBean(Parcel in) {
        this.title = in.readString();
        this.activityName = in.readString();
        this.childList = in.createTypedArrayList(SectionBean.CREATOR);
    }

    public static final Creator<SectionBean> CREATOR = new Creator<SectionBean>() {
        @Override
        public SectionBean createFromParcel(Parcel source) {
            return new SectionBean(source);
        }

        @Override
        public SectionBean[] newArray(int size) {
            return new SectionBean[size];
        }
    };
}
