package com.shmup.hiscores.api;

import com.shmup.hiscores.scores.model.Game;
import com.shmup.hiscores.scores.model.TimelineItem;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ShmupAPI {

    @GET("/api/timeline")
    void getTimeline(Callback<List<TimelineItem>> callback);

    @GET("/api/games")
    void getGameList(Callback<List<Game>> callback);
}
