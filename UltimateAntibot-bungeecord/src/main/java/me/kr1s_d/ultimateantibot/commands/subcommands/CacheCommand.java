package me.kr1s_d.ultimateantibot.commands.subcommands;

import me.kr1s_d.ultimateantibot.commands.SubCommand;
import me.kr1s_d.ultimateantibot.common.service.CheckService;
import me.kr1s_d.ultimateantibot.common.utils.MessageManager;
import me.kr1s_d.ultimateantibot.utils.Utils;
import net.md_5.bungee.api.CommandSender;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheCommand implements SubCommand {
    @Override
    public String getSubCommandId() {
        return "cache";
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        switch (strings[1]) {
            case "status":
                for (String s : CheckService.getInformationAsMessage()) {
                    commandSender.sendMessage(Utils.colora(s));
                }
            case "clear":
                CheckService.clearCheckCache();
                commandSender.sendMessage(Utils.colora(MessageManager.prefix + "&fThe &c&lUAB &fcache has been cleared!"));
        }
    }

    @Override
    public String getPermission() {
        return "uab.command.cache";
    }

    @Override
    public int argsSize() {
        return 2;
    }

    @Override
    public Map<Integer, List<String>> getTabCompleter() {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, Arrays.asList("list", "info"));
        return map;
    }

    @Override
    public boolean allowedConsole() {
        return true;
    }
}
