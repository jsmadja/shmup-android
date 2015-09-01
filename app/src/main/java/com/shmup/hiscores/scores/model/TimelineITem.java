package com.shmup.hiscores.scores.model;

public class TimelineItem {

    private Score score;
    private Player player;

    public TimelineItem(Score score, Player player) {
        this.score = score;
        this.player = player;
    }

    public Score getScore() {
        return score;
    }

    public Player getPlayer() {
        return player;
    }
}
