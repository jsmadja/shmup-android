package com.shmup.hiscores.games.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.shmup.hiscores.scores.model.ScoreCardItem;

import java.util.List;

public class Ranking implements Parcelable {

    private Mode mode;
    private Difficulty difficulty;
    private List<ScoreCardItem> scores;

    public Mode getMode() {
        return mode;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<ScoreCardItem> getScores() {
        return scores;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mode, 0);
        dest.writeParcelable(this.difficulty, 0);
        dest.writeTypedList(scores);
    }

    public Ranking() {
    }

    protected Ranking(Parcel in) {
        this.mode = in.readParcelable(Mode.class.getClassLoader());
        this.difficulty = in.readParcelable(Difficulty.class.getClassLoader());
        this.scores = in.createTypedArrayList(ScoreCardItem.CREATOR);
    }

    public static final Creator<Ranking> CREATOR = new Creator<Ranking>() {
        public Ranking createFromParcel(Parcel source) {
            return new Ranking(source);
        }

        public Ranking[] newArray(int size) {
            return new Ranking[size];
        }
    };

    public String getName() {
        String name = "Ranking";
        if (mode != null) {
            name += " " + mode.getName();
        }
        if (difficulty != null) {
            name += " " + difficulty.getName();
        }
        return name;
    }
}
