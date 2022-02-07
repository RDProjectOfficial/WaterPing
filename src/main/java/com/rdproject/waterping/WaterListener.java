package com.rdproject.waterping;

import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.event.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.event.*;

import static com.rdproject.waterping.WaterPing.*;

@SuppressWarnings("ALL")
public class WaterListener implements Listener {
    @EventHandler
    public void onJoin(PostLoginEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if (p.getName().equals(DEV)) {
            p.sendMessage("§8§l----------------------------");
            p.sendMessage(" §8• §bWaterPing §8•");
            p.sendMessage("");
            p.sendMessage("§8× §7This server using " + PLUGIN_NAME);
            p.sendMessage("§8× §7Version: §b" + VERSION);
            p.sendMessage("§8× §7Author: §b " + DEV_COMPANY);
            p.sendMessage("");
            p.sendMessage("§8§l----------------------------");
        }
    }
}