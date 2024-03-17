package com.twolf.infrastructure.persistence.repository;

import com.twolf.domain.dto.CpPlayer;
import com.twolf.domain.dto.MvpPlayer;
import com.twolf.infrastructure.persistence.entity.PlayerOpe;

/**
 * TODO
 * @Author twolf
 * @Date 2024/3/17 14:13
 */
public interface PlayOpeRepository {

    PlayerOpe load(String id);

    void saveCp(CpPlayer player,CpPlayer cpPlayer);

    void saveMvp(MvpPlayer mvpPlayer);

    void updateCpIdAndCount(PlayerOpe playerOpe,CpPlayer cpPlayer);

    void updateFirstMvpTime(PlayerOpe playerOpe,MvpPlayer mvpPlayer);

}
