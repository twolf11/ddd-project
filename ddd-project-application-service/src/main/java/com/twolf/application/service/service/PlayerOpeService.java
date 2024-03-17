package com.twolf.application.service.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.twolf.domain.command.CpCommand;
import com.twolf.domain.command.MvpCommand;
import com.twolf.domain.dto.CpPlayer;
import com.twolf.domain.dto.MvpPlayer;
import com.twolf.infrastructure.persistence.entity.PlayerOpe;
import com.twolf.infrastructure.persistence.repository.PlayOpeRepository;

@Service
public class PlayerOpeService {

    @Resource
    PlayOpeRepository playOpeRepository;

    public void handleCpCount(CpCommand cpCommand){
        CpPlayer player = new CpPlayer(cpCommand.getPlayerId());
        CpPlayer cpPlayer = new CpPlayer(cpCommand.getCpPlayerId());

        PlayerOpe playerOpe = playOpeRepository.load(cpCommand.getCpPlayerId());
        if (playerOpe == null) {
            playOpeRepository.saveCp(player,cpPlayer);
        } else {
            playOpeRepository.updateCpIdAndCount(playerOpe,cpPlayer);
        }
    }

    public void handleMvp(MvpCommand mvpCommand){
        MvpPlayer mvpPlayer = new MvpPlayer(mvpCommand.getPlayerId(),mvpCommand.getMvpTime());

        PlayerOpe playerOpe = playOpeRepository.load(mvpCommand.getPlayerId());
        //没有就创建并插入
        if (playerOpe == null) {
            playOpeRepository.saveMvp(mvpPlayer);
        } else {
            playOpeRepository.updateFirstMvpTime(playerOpe,mvpPlayer);
        }
    }
}
