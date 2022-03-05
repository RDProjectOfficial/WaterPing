package com.rdproject.waterping.plugin;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.waterping.utils.ConstantsUtil.*;

public class Ping extends Command {
    public Ping() {
        super("ping");
    }

    public void execute(CommandSender sender, String[] args) {
        String PINGPERM = "WaterPing.Ping";
        String PINGOTHERPERM = "WaterPing.Ping.Others";
        String POTHER = cg.getString("ping-other-message");
        String PMSG = cg.getString("ping-message");
        String PNFOUND = cg.getString("player-not-found");
        if (!(sender instanceof ProxiedPlayer)) {
            return;
        }
        ProxiedPlayer p = (ProxiedPlayer) sender;
        if (args.length == 0) {
            if (!p.hasPermission(PINGPERM)) {
                p.sendMessage(formatComponent(NOPERM));
                return;
            }
            p.sendMessage(formatComponent(PREFIX + PMSG.replace("%ping%", "" + p.getPing())));
        } else {
            if (!p.hasPermission(PINGOTHERPERM))  {
                p.sendMessage(formatComponent(NOPERM));
                return;
            }
            String target = args[0];
            ProxiedPlayer targetP = plugin.getProxy().getPlayer(target);
            if (targetP == null) {
                p.sendMessage(formatComponent(PREFIX + PNFOUND));
                return;
            }
            p.sendMessage(formatComponent(PREFIX + POTHER
                    .replace("%ping%", "" + targetP.getPing())
                    .replace("%target%", targetP.getName())));
        }
    }
}
