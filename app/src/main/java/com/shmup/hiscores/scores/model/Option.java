package com.shmup.hiscores.scores.model;

import android.os.Parcel;

public abstract class Option {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected Option() {
    }

    protected Option(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
    }

}
