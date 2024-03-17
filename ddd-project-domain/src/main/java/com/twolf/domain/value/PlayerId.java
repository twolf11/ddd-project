package com.twolf.domain.value;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * 值对象
 * @Author twolf
 * @Date 2024/3/17 18:49
 */
@Data
public class PlayerId {
    private String playerId;

    public PlayerId(String playerId){
        if (StringUtils.isBlank(playerId)) {
            throw new IllegalArgumentException();
        }
        this.playerId = playerId;
    }
}
