package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ship extends Option implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(this.getName());
    }

    public Ship() {
    }

    public Ship(Parcel in) {
        super(in);
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
