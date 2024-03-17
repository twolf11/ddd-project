package com.twolf.domain.factory;

import com.twolf.domain.entity.PlayerEntity;
import com.twolf.domain.value.PlayerId;

/**
 * 工厂
 * @Author twolf
 * @Date 2024/3/17 14:13
 */
public interface PlayerEntityFactory {

    PlayerEntity newInstance(PlayerId playerId);
}
