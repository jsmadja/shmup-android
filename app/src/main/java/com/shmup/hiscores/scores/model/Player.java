package com.shmup.hiscores.scores.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    private String name;

    public String getName() {
        return name;
    }
}
