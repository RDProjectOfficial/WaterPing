package com.rdproject.waterping;

import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.event.*;

@SuppressWarnings("ALL")
public class TabCompleteEvent implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)

    public void onTabComplete(net.md_5.bungee.api.event.TabCompleteEvent ev) {
        String partialPlayerName = ev.getCursor().toLowerCase();

        int lastSpaceIndex = partialPlayerName.lastIndexOf(' ');
        if (lastSpaceIndex >= 0)
        {
            partialPlayerName = partialPlayerName.substring(lastSpaceIndex + 1);
        }

        for (ProxiedPlayer p : WaterPing.getInstance().getProxy().getPlayers())
        {
            if (p.getName().toLowerCase().startsWith(partialPlayerName))
            {
                ev.getSuggestions().add(p.getName());
            }
        }
    }
}