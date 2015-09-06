package com.shmup.hiscores.scores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Score {

    private long value;

    public long getValue() {
        return value;
    }
}
