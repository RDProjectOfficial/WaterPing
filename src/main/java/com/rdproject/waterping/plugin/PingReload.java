package com.rdproject.waterping.plugin;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.waterping.plugin.LoaderUtil.*;
import static com.rdproject.waterping.utils.ConstantsUtil.*;

public class PingReload extends Command {

    public PingReload() {
        super("pingreload");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        String CFG = cg.getString("Config-Reloaded");
        if (sender.hasPermission("WaterPing.PingReload")) {
            sender.sendMessage(formatComponent(PREFIX + CFG));
            LoadConfig();
        } else {
            sender.sendMessage(formatComponent(NOPERM));
        }
    }
}

