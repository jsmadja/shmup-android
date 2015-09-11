package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Mode extends Option implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(this.getName());
    }

    public Mode() {
    }

    protected Mode(Parcel in) {
        super(in);
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
