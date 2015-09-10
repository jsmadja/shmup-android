package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Difficulty implements Parcelable {

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

    public Difficulty() {
    }

    protected Difficulty(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
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
