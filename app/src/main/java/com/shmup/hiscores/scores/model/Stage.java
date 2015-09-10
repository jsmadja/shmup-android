package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Stage implements Parcelable {

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

    public Stage() {
    }

    protected Stage(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
    }

    public static final Creator<Stage> CREATOR = new Creator<Stage>() {
        public Stage createFromParcel(Parcel source) {
            return new Stage(source);
        }

        public Stage[] newArray(int size) {
            return new Stage[size];
        }
    };
}
