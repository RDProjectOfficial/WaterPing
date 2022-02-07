package com.rdproject.waterping;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.waterping.WaterPing.*;

@SuppressWarnings("ALL")
public class PingReloadCommand extends Command {
    public PingReloadCommand() {
        super("pingreload", "WaterPing.PingReload");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (sender != null) {
            player.sendMessage(cg.getString("Prefix") + "§bConfiguration successfully reloaded!");
            LoadConfigs();
        }
    }
}

