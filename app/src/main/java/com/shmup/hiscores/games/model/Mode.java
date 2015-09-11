package com.shmup.hiscores.games.model;

import android.os.Parcel;

public class Mode extends Option {

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
