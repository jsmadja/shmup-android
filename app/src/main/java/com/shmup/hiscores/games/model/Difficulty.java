package com.shmup.hiscores.games.model;

import android.os.Parcel;

public class Difficulty extends Option {

    public Difficulty() {
    }

    public Difficulty(Parcel in) {
        super(in);
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
