package com.twolf.infrastructure.persistence.mapper;

import org.springframework.stereotype.Repository;

import com.twolf.infrastructure.persistence.data.Player;

/**
 * 假设它是一个Mapper，完成数据库持久化
 * 就是MyBatis那套东西
 */
@Repository
public class PlayOpeMapper {
    //从数据库里面查询，Mybatis那套东西

    /**
     * 根据玩家ID获得玩家运营数据
     * @param playerId
     * @return
     */
    public Player getByPlayId(String playerId){
        return null;
    }

    public void insert(Player player){
    }

    /**
     * 更新CP玩家ID和已组成过CP的总数量
     * @param player
     */
    public void updateCpIdAndCount(Player player){

    }

    /**
     * 更新首次获得MVP的时间
     * @param player
     */
    public void updateFirstMvpTime(Player player){

    }
}
