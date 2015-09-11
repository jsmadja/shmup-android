package com.shmup.hiscores.games.model;

import android.os.Parcel;

public class Platform extends Option {

    public Platform() {
    }

    public Platform(Parcel in) {
        super(in);
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
