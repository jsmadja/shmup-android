package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Score implements Parcelable {

    private long value;

    public long getValue() {
        return value;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.value);
    }

    public Score() {
    }

    protected Score(Parcel in) {
        this.value = in.readLong();
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        public Score createFromParcel(Parcel source) {
            return new Score(source);
        }

        public Score[] newArray(int size) {
            return new Score[size];
        }
    };
}
