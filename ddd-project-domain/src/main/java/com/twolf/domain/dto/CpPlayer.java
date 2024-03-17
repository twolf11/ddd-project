package com.twolf.domain.dto;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class CpPlayer {

    private String playerId;

    public CpPlayer(String playerId){
        if (StringUtils.isBlank(playerId)) {
            throw new IllegalArgumentException();
        }
        this.playerId = playerId;
    }
}
