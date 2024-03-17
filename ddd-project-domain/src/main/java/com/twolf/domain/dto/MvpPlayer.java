package com.twolf.domain.dto;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class MvpPlayer {

    private String playerId;

    private Date mvpTime;

    public MvpPlayer(String playerId,Date mvpTime){
        if (StringUtils.isBlank(playerId)) {
            throw new IllegalArgumentException();
        }
        this.playerId = playerId;
        if (Objects.isNull(mvpTime)) {
            throw new IllegalArgumentException();
        }
        this.mvpTime = mvpTime;
    }
}
