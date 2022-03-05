package com.rdproject.waterping.utils;

import com.rdproject.waterping.*;
import lombok.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.config.*;

public class ConstantsUtil {

    public static Configuration cg;
    public static @Getter WaterPing plugin;
    public static final String VERSION = "1.1-STABLE";
    public static final String LIST = "§8§l----------------------------";
    public static final String STARTUP_MESSAGE = "\n" + " \\ \\        /       |                 _ \\  _)               \n" +
            "  \\ \\  \\   /  _` |  __|   _ \\   __|  |   |  |  __ \\    _` | \n" +
            "   \\ \\  \\ /  (   |  |     __/  |     ___/   |  |   |  (   | \n" +
            "    \\_/\\_/  \\__,_| \\__| \\___| _|    _|     _| _|  _| \\__, | \n" +
            "                                                     |___/ " + " Version " + VERSION;

    public static String PREFIX;
    public static String NOPERM;

    public static TextComponent formatComponent(String message) {
        return new TextComponent(ChatColor.translateAlternateColorCodes('&', message));
    }

}

