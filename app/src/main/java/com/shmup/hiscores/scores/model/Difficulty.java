package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Difficulty extends Option implements Parcelable {

    public Difficulty() {
    }

    public Difficulty(Parcel in) {
        super(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(this.getName());
    }

    public static final Creator<Difficulty> CREATOR = new Creator<Difficulty>() {
        public Difficulty createFromParcel(Parcel source) {
            return new Difficulty(source);
        }

        public Difficulty[] newArray(int size) {
            return new Difficulty[size];
        }
    };
}
