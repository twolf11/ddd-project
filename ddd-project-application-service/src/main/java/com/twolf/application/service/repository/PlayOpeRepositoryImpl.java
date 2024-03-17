package com.twolf.application.service.repository;

import javax.annotation.Resource;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.twolf.domain.dto.CpPlayer;
import com.twolf.domain.dto.MvpPlayer;
import com.twolf.infrastructure.persistence.entity.PlayerOpe;
import com.twolf.infrastructure.persistence.mapper.PlayOpeMapper;
import com.twolf.infrastructure.persistence.repository.PlayOpeRepository;

/**
 * TODO
 * @Author twolf
 * @Date 2024/3/17 14:14
 */
@Service
public class PlayOpeRepositoryImpl implements PlayOpeRepository {

    @Resource
    private PlayOpeMapper playOpeMapper;

    @Override public PlayerOpe load(String id){
        return playOpeMapper.getByPlayId(id);
    }

    @Override public void saveCp(CpPlayer player,CpPlayer cpPlayer){
        PlayerOpe playerOpe = new PlayerOpe();
        playerOpe.setPlayerId(player.getPlayerId());
        playerOpe.setLastCpPlayerId(cpPlayer.getPlayerId());
        playerOpe.setCpCount(1);
        playOpeMapper.insert(playerOpe);
    }

    @Override public void saveMvp(MvpPlayer mvpPlayer){
        PlayerOpe playerOpe = new PlayerOpe();
        playerOpe.setPlayerId(mvpPlayer.getPlayerId());
        playerOpe.setFirstMvpTime(mvpPlayer.getMvpTime());
        playOpeMapper.insert(playerOpe);
    }

    @Override public void updateCpIdAndCount(PlayerOpe playerOpe,CpPlayer cpPlayer){
        Integer cpCount = playerOpe.getCpCount();
        //没组过CP，要初始化
        if (cpCount == null || cpCount == 0) {
            playerOpe.setCpCount(1);
            playerOpe.setLastCpPlayerId(cpPlayer.getPlayerId());
        } else {
            //组过CP的话，需要这次新CP的玩家ID跟上次的不一样才会统计
            //小两口闹矛盾又复合的就别记录进去了
            if (!cpPlayer.getPlayerId().equals(playerOpe.getLastCpPlayerId())) {
                playerOpe.setCpCount(playerOpe.getCpCount() + 1);
                playerOpe.setLastCpPlayerId(cpPlayer.getPlayerId());
            }
        }
        playOpeMapper.updateCpIdAndCount(playerOpe);
    }

    @Override public void updateFirstMvpTime(PlayerOpe playerOpe,MvpPlayer mvpPlayer){
        Date firstMvpTime = playerOpe.getFirstMvpTime();
        //判断时间是否在默认时间之前
        if (mvpPlayer.getMvpTime().before(firstMvpTime)) {
            playerOpe.setFirstMvpTime(mvpPlayer.getMvpTime());
        }
        playOpeMapper.updateFirstMvpTime(playerOpe);
    }


}
