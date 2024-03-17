package com.twolf.application.service.command;

import java.util.Date;

import lombok.Data;

@Data
public class MvpCommand {

    private String playerId;

    private Date mvpTime;
}
