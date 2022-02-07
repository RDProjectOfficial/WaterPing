package com.rdproject.waterping;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.waterping.WaterPing.*;

@SuppressWarnings("ALL")
public class WaterPingCommand extends Command {
    public WaterPingCommand() {
        super("ping");
    }

    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            return;
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 0) {
            if (!p.hasPermission("WaterPing.Ping")) {
                p.sendMessage(cg.getString("Prefix") + cg.getString("NoPermission"));
                return;
            }
            p.sendMessage(cg.getString("Prefix") + cg.getString("ping-message").replace("%ping%", "" + p.getPing()));
        } else {
            if (!p.hasPermission("WaterPing.Ping.Others"))  {
                p.sendMessage(cg.getString("Prefix") + cg.getString("NoPermission"));
                return;
            }
            String target = args[0];
            ProxiedPlayer targetP = WaterPing.getInstance().getProxy().getPlayer(target);
            if (targetP == null) {
                p.sendMessage(cg.getString("Prefix") + cg.getString("player-not-found"));
                return;
            }
            p.sendMessage(cg.getString("Prefix") + cg.getString("ping-other-message")
                    .replace("%ping%", "" + targetP.getPing())
                    .replace("%target%", targetP.getName()));
        }
    }
}