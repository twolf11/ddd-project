package com.twolf.application.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.twolf.application.service.command.CpCommand;
import com.twolf.application.service.command.MvpCommand;
import com.twolf.domain.entity.PlayerEntity;
import com.twolf.domain.factory.PlayerEntityFactory;
import com.twolf.domain.repository.PlayerEntityRepository;
import com.twolf.domain.value.MvpTime;
import com.twolf.domain.value.PlayerId;

@Service
public class PlayerOpeService {

    @Resource
    PlayerEntityRepository playerEntityRepository;

    PlayerEntityFactory playerEntityFactory;

    public void handleCpCount(CpCommand cpCommand){
        PlayerId playerId = new PlayerId(cpCommand.getPlayerId());
        PlayerId cpPlayerId = new PlayerId(cpCommand.getPlayerId());

        PlayerEntity playerEntity = playerEntityRepository.load(playerId);
        if (playerEntity == null) {
            playerEntity = playerEntityFactory.newInstance(playerId);
        }
        playerEntity.addCpPlayer(cpPlayerId);
        playerEntityRepository.save(playerEntity);
    }

    public void handleMvp(MvpCommand mvpCommand){
        PlayerId playerId = new PlayerId(mvpCommand.getPlayerId());
        MvpTime mvpTime = new MvpTime(mvpCommand.getMvpTime());

        PlayerEntity playerEntity = playerEntityRepository.load(playerId);
        if (playerEntity == null) {
            playerEntity = playerEntityFactory.newInstance(playerId);
        }
        playerEntity.firstMvp(mvpTime);
        playerEntityRepository.save(playerEntity);
    }
}
