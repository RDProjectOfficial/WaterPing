package com.rdproject.waterping;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.config.*;
import java.io.*;
import java.nio.file.*;

@SuppressWarnings("ALL")
public final class WaterPing extends Plugin {

    public static Configuration cg;
    private static WaterPing plugin;
    public static final String DEV = "ArtemYTO";
    public static final String DEV_COMPANY = "RDProject";
    public static final String PLUGIN_NAME = "WaterPing";
    public static final String VERSION = "1.0";
    public static final String LIST = "§8§l----------------------------";
    public static final String STARTUP_MESSAGE = "\n" + " \\ \\        /       |                 _ \\  _)               \n" +
            "  \\ \\  \\   /  _` |  __|   _ \\   __|  |   |  |  __ \\    _` | \n" +
            "   \\ \\  \\ /  (   |  |     __/  |     ___/   |  |   |  (   | \n" +
            "    \\_/\\_/  \\__,_| \\__| \\___| _|    _|     _| _|  _| \\__, | \n" +
            "                                                     |___/ " + " Version " + VERSION;

    @Override
    public void onEnable() {
        new Metrics(this, 14225);
        plugin = this;

        LoadCommands();
        LoadListeners();
        getConfigs();
        LoadConfigs();
        getLogger().info(STARTUP_MESSAGE);

        UpdateChecker updateChecker = new UpdateChecker(this, 99826);
        try {
            if (updateChecker.checkForUpdates()) {
                getLogger().info(LIST);
                getLogger().info("    §8• §bWaterPing §8•");
                getLogger().info("");
                getLogger().info("§8× §7Update Available!");
                getLogger().info("§8× §7Download it from Spigot!");
                getLogger().info("");
                getLogger().info(LIST);
            } else  {
                getLogger().info(LIST);
                getLogger().info("    §8• §bWaterPing §8•");
                getLogger().info("");
                getLogger().info("§8× §7You are using the Latest Version!");
                getLogger().info("");
                getLogger().info(LIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConfigs() {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists())
            try {
                InputStream in = getResourceAsStream("config.yml");
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void LoadConfigs() {
        try {
            cg = ConfigurationProvider.getProvider(YamlConfiguration.class)
                    .load(new File(plugin.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LoadListeners() {
        ProxyServer.getInstance().getPluginManager().registerListener(this, new WaterListener());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new TabCompleteEvent());
    }

    public void LoadCommands() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new WaterPingCommand());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new PingReloadCommand());
    }

    public static WaterPing getInstance() {
        return plugin;
    }
}
