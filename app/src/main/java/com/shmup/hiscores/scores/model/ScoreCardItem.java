package com.shmup.hiscores.scores.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shmup.hiscores.BuildConfig;
import com.shmup.hiscores.games.model.Difficulty;
import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.games.model.Mode;
import com.shmup.hiscores.games.model.Platform;
import com.shmup.hiscores.games.model.Ship;
import com.shmup.hiscores.games.model.Stage;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreCardItem implements Parcelable {

    private String value;
    private Player player;
    private Game game;
    private Stage stage;
    private Ship ship;
    private Difficulty difficulty;
    private Mode mode;
    private String date;

    @JsonProperty("1cc")
    private boolean onecc;

    private String photo;
    private String replay;
    private Platform platform;
    private String rank;
    private Long score;
    private String comment;

    public String getValue() {
        if (value != null) {
            return value;
        }
        if (score != null) {
            return score.toString();
        }
        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public Stage getStage() {
        return stage;
    }

    public Ship getShip() {
        return ship;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Mode getMode() {
        return mode;
    }

    public String getDate() {
        return date;
    }

    public boolean isOnecc() {
        return onecc;
    }

    public String getPhoto() {
        return photo;
    }

    public String getReplay() {
        return replay;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getRank() {
        return rank;
    }

    public String getCover() {
        String cover = game.getCover();
        if (cover.startsWith("/")) {
            cover = BuildConfig.BASE_URL + "/" + cover;
        }
        return cover;
    }

    public boolean hasPhoto() {
        return photo != null && !photo.trim().isEmpty();
    }

    public boolean hasReplay() {
        return replay != null && !replay.trim().isEmpty();
    }

    public boolean hasStage() {
        return stage != null && !stage.getName().trim().isEmpty();
    }

    public String getStageName() {
        return stage.getName();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
        dest.writeParcelable(this.player, 0);
        dest.writeParcelable(this.game, 0);
        dest.writeParcelable(this.stage, 0);
        dest.writeParcelable(this.ship, 0);
        dest.writeParcelable(this.difficulty, 0);
        dest.writeParcelable(this.mode, 0);
        dest.writeString(this.date);
        dest.writeByte(onecc ? (byte) 1 : (byte) 0);
        dest.writeString(this.photo);
        dest.writeString(this.replay);
        dest.writeParcelable(this.platform, 0);
        dest.writeString(this.rank);
        dest.writeValue(this.score);
        dest.writeString(this.comment);
    }

    public ScoreCardItem() {
    }

    protected ScoreCardItem(Parcel in) {
        this.value = in.readString();
        this.player = in.readParcelable(Player.class.getClassLoader());
        this.game = in.readParcelable(Game.class.getClassLoader());
        this.stage = in.readParcelable(Stage.class.getClassLoader());
        this.ship = in.readParcelable(Ship.class.getClassLoader());
        this.difficulty = in.readParcelable(Difficulty.class.getClassLoader());
        this.mode = in.readParcelable(Mode.class.getClassLoader());
        this.date = in.readString();
        this.onecc = in.readByte() != 0;
        this.photo = in.readString();
        this.replay = in.readString();
        this.platform = in.readParcelable(Platform.class.getClassLoader());
        this.rank = in.readString();
        this.score = (Long) in.readValue(Long.class.getClassLoader());
        this.comment = in.readString();
    }

    public static final Creator<ScoreCardItem> CREATOR = new Creator<ScoreCardItem>() {
        public ScoreCardItem createFromParcel(Parcel source) {
            return new ScoreCardItem(source);
        }

        public ScoreCardItem[] newArray(int size) {
            return new ScoreCardItem[size];
        }
    };
}
