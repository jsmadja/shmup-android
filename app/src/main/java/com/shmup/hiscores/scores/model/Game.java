package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {

    private long id;
    private String title;
    private String cover;

    public Game() {
    }

    public Game(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeString(this.cover);
    }

    protected Game(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.cover = in.readString();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}

