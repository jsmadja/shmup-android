package com.shmup.hiscores.games.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game implements Parcelable {

    private long id;
    private String title;
    private String cover;
    private List<Platform> platforms;
    private List<Mode> modes;
    private List<Difficulty> difficulties;
    private List<Ship> ships;
    private List<Stage> stages;

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

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public List<Mode> getModes() {
        return modes;
    }

    public List<Difficulty> getDifficulties() {
        return difficulties;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public boolean hasModes() {
        return modes != null && !modes.isEmpty();
    }

    public boolean hasDifficulties() {
        return difficulties != null && !difficulties.isEmpty();
    }

    public boolean hasShips() {
        return ships != null && !ships.isEmpty();
    }

    public List<Stage> getStages() {
        return stages;
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
        dest.writeTypedList(platforms);
        dest.writeTypedList(modes);
        dest.writeTypedList(difficulties);
        dest.writeTypedList(ships);
        dest.writeTypedList(stages);
    }

    protected Game(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.cover = in.readString();
        this.platforms = in.createTypedArrayList(Platform.CREATOR);
        this.modes = in.createTypedArrayList(Mode.CREATOR);
        this.difficulties = in.createTypedArrayList(Difficulty.CREATOR);
        this.ships = in.createTypedArrayList(Ship.CREATOR);
        this.stages = in.createTypedArrayList(Stage.CREATOR);
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public boolean hasStages() {
        return stages != null && !stages.isEmpty();
    }
}

