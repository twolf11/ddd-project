package com.twolf.infrastructure.persistence.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.twolf.domain.entity.PlayerEntity;
import com.twolf.domain.repository.PlayerEntityRepository;
import com.twolf.domain.value.MvpTime;
import com.twolf.domain.value.PlayerId;
import com.twolf.infrastructure.persistence.data.Player;
import com.twolf.infrastructure.persistence.mapper.PlayOpeMapper;

/**
 * 仓储实现
 * @Author twolf
 * @Date 2024/3/17 14:14
 */
@Service
public class PlayerEntityRepositoryImpl implements PlayerEntityRepository {

    @Resource
    private PlayOpeMapper playOpeMapper;

    @Override public PlayerEntity load(PlayerId playerId){
        Player byPlayId = playOpeMapper.getByPlayId(playerId.getPlayerId());
        if (byPlayId == null) {
            return null;
        }
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(byPlayId.getId());
        playerEntity.setCpCount(byPlayId.getCpCount());
        playerEntity.setFirstMvpTime(byPlayId.getFirstMvpTime() == null ? null : new MvpTime(byPlayId.getFirstMvpTime()));
        playerEntity.setPlayerId(new PlayerId(byPlayId.getPlayerId()));
        playerEntity.setLastCpPlayerId(new PlayerId(byPlayId.getLastCpPlayerId()));
        return playerEntity;
    }

    @Override public void save(PlayerEntity playerEntity){
        Player player = new Player();
        player.setId(playerEntity.getId());
        player.setCpCount(playerEntity.getCpCount());
        player.setFirstMvpTime(playerEntity.getFirstMvpTime().getMvpTime());
        player.setPlayerId(playerEntity.getPlayerId().getPlayerId());
        player.setLastCpPlayerId(playerEntity.getLastCpPlayerId().getPlayerId());
        if (player.getId() == null) {
            playOpeMapper.insert(player);
        } else {
            playOpeMapper.updateCpIdAndCount(player);
        }
    }
}
