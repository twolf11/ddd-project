package com.twolf.domain.repository;

import com.twolf.domain.entity.PlayerEntity;
import com.twolf.domain.value.PlayerId;

/**
 * 仓储
 * @Author twolf
 * @Date 2024/3/17 14:13
 */
public interface PlayerEntityRepository {

    PlayerEntity load(PlayerId playerId);

    void save(PlayerEntity playerEntity);

}
