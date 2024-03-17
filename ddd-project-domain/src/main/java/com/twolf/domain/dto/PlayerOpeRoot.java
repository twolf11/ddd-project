package com.twolf.domain.dto;

import java.util.Date;

import lombok.Data;

/**
 * 玩家运营数据-聚合根
 */
@Data
public class PlayerOpeRoot {

    /**
     * 数据库自增主键
     */
    private Long id;

    /**
     * 玩家ID
     */
    private CpPlayer player;

    /**
     * 首次获得MVP时间，默认是9999-12-31 23:59:59
     */
    private Date firstMvpTime;

    /**
     * 累计跟几个妹子组过CP
     */
    private Integer cpCount;

    /**
     * 上一个CP的玩家ID，相同的话不累加
     */
    private CpPlayer lastCpPlayer;

}
