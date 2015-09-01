package com.shmup.hiscores.scores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Score {

    private Long value;

    public Score() {
    }

    public Score(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
