package com.twolf.domain.value;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * 值对象
 * @Author twolf
 * @Date 2024/3/17 18:49
 */
@Data
public class MvpTime {

    private Date mvpTime;

    public MvpTime(Date mvpTime){
        this.mvpTime = mvpTime;
    }
}
