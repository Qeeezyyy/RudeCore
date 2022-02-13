package de.julian.rudecore.core.utils;

import de.julian.rudecore.core.Main;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class Utils {

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    //"§6Rude§cCore §8» "

    private static String prefix = Main.getInstance().getConfig().getString("prefix");

    private static String noPermPrefix = Main.getInstance().getConfig().getString("noperm");

    private static String syntaxPrefix = Main.getInstance().getConfig().getString("syntaxname");

    private static String headerPrefix = Main.getInstance().getConfig().getString("helplistheader");

    private static String listPrefix = Main.getInstance().getConfig().getString("listheader");

    private static String discordLink = Main.getInstance().getConfig().getString("discord");


    public static String getPrefix() {
        return prefix;
    }

    public static String getSyntaxprefix() {
        return syntaxPrefix;
    }

    public static String getNoPermPrefix() {
        return noPermPrefix;
    }

    public static String getHeaderPrefix() {
        return headerPrefix;
    }

    public static String getListPrefix() {
        return listPrefix;
    }

    public static String getDiscordLink() {
        return discordLink;
    }

}
