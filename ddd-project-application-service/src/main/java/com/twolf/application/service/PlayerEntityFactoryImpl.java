package com.twolf.application.service;

import java.util.UUID;

import com.twolf.domain.entity.PlayerEntity;
import com.twolf.domain.factory.PlayerEntityFactory;
import com.twolf.domain.value.PlayerId;

/**
 * 工厂实现
 * @Author twolf
 * @Date 2024/3/17 14:13
 */
public class PlayerEntityFactoryImpl implements PlayerEntityFactory {

    @Override public PlayerEntity newInstance(PlayerId playerId){
        PlayerEntity playerEntity = new PlayerEntity();
        //可以通过第三方生成
        //playerEntity.setId(1L);
        playerEntity.setPlayerId(playerId);
        return playerEntity;
    }
}
