package com.shmup.hiscores.api;

import com.shmup.hiscores.games.model.Game;
import com.shmup.hiscores.scores.model.ScoreCardItem;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ShmupAPI {

    @GET("/api/timeline")
    void getTimeline(Callback<List<ScoreCardItem>> callback);

    @GET("/api/games")
    void getGameList(Callback<List<Game>> callback);

    @GET("/api/games/{id}")
    void getGame(@Path("id") Long id, Callback<Game> callback);
}
