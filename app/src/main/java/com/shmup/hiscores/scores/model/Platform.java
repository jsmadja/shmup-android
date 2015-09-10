package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Platform implements Parcelable {

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

    public Platform() {
    }

    protected Platform(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
    }

    public static final Creator<Platform> CREATOR = new Creator<Platform>() {
        public Platform createFromParcel(Parcel source) {
            return new Platform(source);
        }

        public Platform[] newArray(int size) {
            return new Platform[size];
        }
    };
}
