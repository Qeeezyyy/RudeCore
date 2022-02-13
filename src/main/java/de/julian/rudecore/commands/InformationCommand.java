package de.julian.rudecore.commands;

import de.julian.rudecore.core.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class InformationCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.hasPermission("core.command.information")) {

            if (args.length > 0) {

                switch (args[0]) {

                    case "developer":
                        sender.sendMessage(Utils.getListPrefix() + "§7 Informationen zum Entwickler");
                        sender.sendMessage("§aVersion: §7Das SystemPlugin ist derzeit in der §eV 2.0.1");
                        sender.sendMessage("§bEntwickler: §7Der Entwickler ist JuliianDE");
                        sender.sendMessage("§cBugs: §7Alle Bugs des Systems bitte an JuliianDE auf Discord senden!");
                        break;
                    case "dev":
                        sender.sendMessage(Utils.getListPrefix() + "§7 Informationen zum Entwickler");
                        sender.sendMessage("§aVersion: §7Das SystemPlugin ist derzeit in der §eV 2.0.1");
                        sender.sendMessage("§bEntwickler: §7Der Entwickler ist JuliianDE");
                        sender.sendMessage("§cBugs: §7Alle Bugs des Systems bitte an JuliianDE auf Discord senden!");
                        break;
                    case "discord":
                        if (sender.hasPermission("core.command.informations.discord")) {
                            sender.sendMessage(Utils.getListPrefix() +  "§7 Informationen zum Discord");
                            sender.sendMessage("§9Unser Discord:" + ChatColor.GRAY + Utils.getDiscordLink());
                        }
                        break;

                    default:
                        break;
                }
            }
        }
        return false;
    }
}