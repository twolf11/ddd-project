package com.twolf.domain.entity;

import java.util.Date;
import java.util.Objects;

import com.twolf.domain.value.MvpTime;
import com.twolf.domain.value.PlayerId;
import lombok.Data;

/**
 * 聚合根
 * @Author twolf
 * @Date 2024/3/17 18:47
 */
@Data
public class PlayerEntity {

    /**
     * 数据库自增主键
     */
    private Long id;

    /**
     * 玩家ID
     */
    private PlayerId playerId;

    /**
     * 首次获得MVP时间，默认是9999-12-31 23:59:59
     */
    private MvpTime firstMvpTime;

    /**
     * 累计跟几个妹子组过CP
     */
    private Integer cpCount;

    /**
     * 上一个CP的玩家ID，相同的话不累加
     */
    private PlayerId lastCpPlayerId;

    /**
     * 添加cp
     * @param cpPlayerId
     * @author twolf
     * @date 2024/3/17 19:12
     **/
    public void addCpPlayer(PlayerId cpPlayerId){
        if (cpPlayerId.equals(lastCpPlayerId)) {
            return;
        }
        this.lastCpPlayerId = cpPlayerId;
        this.cpCount++;
    }

    /**
     * 第一次mvp时间
     * @param mvpTime
     * @author twolf
     * @date 2024/3/17 19:16
     **/
    public void firstMvp(MvpTime mvpTime){
        //判断时间是否在默认时间之前
        if (Objects.isNull(firstMvpTime) || mvpTime.getMvpTime().before(firstMvpTime.getMvpTime())) {
            this.firstMvpTime = mvpTime;
        }
    }

}
