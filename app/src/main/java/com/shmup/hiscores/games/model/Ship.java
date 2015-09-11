package com.shmup.hiscores.games.model;

import android.os.Parcel;

public class Ship extends Option {

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
