package me.kr1s_d.ultimateantibot.event;


import me.kr1s_d.ultimateantibot.common.ModeType;
import me.kr1s_d.ultimateantibot.common.IAntiBotManager;
import me.kr1s_d.ultimateantibot.common.IAntiBotPlugin;
import me.kr1s_d.ultimateantibot.common.service.UserDataService;
import me.kr1s_d.ultimateantibot.common.utils.MessageManager;
import me.kr1s_d.ultimateantibot.utils.Utils;
import net.md_5.bungee.api.plugin.Event;

import java.util.ArrayList;
import java.util.List;

public class ModeEnableEvent extends Event {
    private final IAntiBotManager antiBotManager;
    private final ModeType enabledMode;
    private final UserDataService userDataService;

    public ModeEnableEvent(IAntiBotPlugin antiBotPlugin, ModeType modeType){
        this.antiBotManager = antiBotPlugin.getAntiBotManager();
        this.enabledMode = modeType;
        this.userDataService = antiBotPlugin.getUserDataService();
    }

    public ModeType getEnabledMode() {
        return enabledMode;
    }

    public void disconnectBots(){
        List<String> profileList = new ArrayList<>(antiBotManager.getJoinCache().getJoined(6));
        profileList.forEach(userDataService::resetFirstJoin);
        Utils.disconnectAll(profileList, MessageManager.getSafeModeMessage());
        antiBotManager.getJoinCache().clear();
    }
}
