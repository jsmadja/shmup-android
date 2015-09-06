package com.shmup.hiscores.scores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineItem {

    private String value;
    private Player player;
    private Game game;
    private Stage stage;
    private Ship ship;
    private Difficulty difficulty;
    private Mode mode;
    private String date;
    private boolean onecc;
    private String photo;
    private String replay;
    private Platform platform;
    private String rank;

    public String getValue() {
        return value;
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
            cover = "http://hiscores.shmup.com" + cover;
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
}
