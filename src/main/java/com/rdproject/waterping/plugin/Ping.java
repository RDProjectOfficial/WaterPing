package com.rdproject.waterping.plugin;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;

import static com.rdproject.waterping.utils.ConstantsUtil.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.rdproject.waterping.utils.StringUtil;

public class Ping extends Command implements TabExecutor {

    private static final String PINGPERM = "WaterPing.Ping";
    private static final String PINGOTHERPERM = "WaterPing.Ping.Others";

    public Ping() {
        super("ping");
    }

    public void execute(CommandSender sender, String[] args) {
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

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        if (args.length == 1 && sender.hasPermission(PINGOTHERPERM)) {
            List<String> players = ProxyServer.getInstance().getPlayers().stream()
                    .map(ProxiedPlayer::getName)
                    .collect(Collectors.toList());
            return StringUtil.copyPartialMatches(args[0], players, new ArrayList<>());
        }
        return Collections.emptyList();
    }
}
