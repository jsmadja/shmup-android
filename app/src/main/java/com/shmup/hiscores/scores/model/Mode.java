package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Mode implements Parcelable {

    private long id;
    private String name;

    public long getId() {
        return id;
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
        dest.writeLong(this.id);
        dest.writeString(this.name);
    }

    public Mode() {
    }

    protected Mode(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
    }

    public static final Creator<Mode> CREATOR = new Creator<Mode>() {
        public Mode createFromParcel(Parcel source) {
            return new Mode(source);
        }

        public Mode[] newArray(int size) {
            return new Mode[size];
        }
    };
}
