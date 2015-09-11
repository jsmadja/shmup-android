package com.shmup.hiscores.games.model;

import android.os.Parcel;

public class Stage extends Option {

    public Stage() {
    }

    public Stage(Parcel in) {
        super(in);
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
