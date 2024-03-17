package com.twolf.ui.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twolf.application.service.PlayerOpeService;
import com.twolf.application.service.command.CpCommand;
import com.twolf.application.service.command.MvpCommand;

/**
 * TODO
 * @Author twolf
 * @Date 2024/3/17 14:57
 */
@RequestMapping("/api/player")
@RestController
public class PlayerController {

    @Resource
    private PlayerOpeService playerOpeService;

    @PostMapping("handleCpCount")
    public void handleCpCount(@RequestBody CpCommand cpCommand){
        playerOpeService.handleCpCount(cpCommand);
    }

    @PostMapping("handleMvp")
    public void handleMvp(@RequestBody MvpCommand mvpCommand){
        playerOpeService.handleMvp(mvpCommand);
    }

}
