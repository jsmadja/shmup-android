package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ship implements Parcelable {

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

    public Ship() {
    }

    protected Ship(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
    }

    public static final Creator<Ship> CREATOR = new Creator<Ship>() {
        public Ship createFromParcel(Parcel source) {
            return new Ship(source);
        }

        public Ship[] newArray(int size) {
            return new Ship[size];
        }
    };
}
