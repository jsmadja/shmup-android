package com.shmup.hiscores.games.model;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Option implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.getId());
        dest.writeString(this.getName());
    }

}
