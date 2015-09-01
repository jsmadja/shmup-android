package com.shmup.hiscores.api;

import com.shmup.hiscores.scores.model.TimelineItem;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ShmupAPI {

    @GET("/timeline.json")
    void getTimeline(Callback<List<TimelineItem>> callback);
}
