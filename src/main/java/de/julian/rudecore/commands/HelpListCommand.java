package de.julian.rudecore.commands;

import de.julian.rudecore.core.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class HelpListCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.hasPermission("system.command.help")) {
            //< //>
            if (args.length > 0) {

                switch (args[0]) {

                    case "1":
                        sender.sendMessage(Utils.getHeaderPrefix() + " §7Seite [1]");

                        sender.sendMessage("§7Vielen Dank für das Verwenden des SystemCore Plugins von Juliian#0187 und Titusツ#0420");
                        sender.sendMessage("§7Um in der Helplist zu Navigieren setze hinter §e/help §7 eine Zahl.");
                        break;

                    case "2":
                        sender.sendMessage(Utils.getHeaderPrefix() + " §7Seite [2]");
                        sender.sendMessage("§e/info dev §7Lasse dir Informationen zum Entwickler ausgeben.");
                        sender.sendMessage("§e/info developer §7Lasse dir Informationen zum Entwickler ausgeben.");
                        sender.sendMessage("§e/pl §7Lasse dir die Server Plugins ausgeben");
                        sender.sendMessage("§e/info dc §7Lasse dir den Discord Server Link ausgeben");
                        break;
                    case "3":
                        sender.sendMessage("Hier gibts noch nichts zu sehen :o");
                        break;

                    case "4":
                        if (sender.hasPermission("core.admin.help")) {
                            sender.sendMessage(Utils.getHeaderPrefix() + " §7Seite [1]");
                            sender.sendMessage("§e/help Lasse dir alle Commands ausgeben.");
                            sender.sendMessage("§e/sudo SPIELER Nachricht §7Sende eine Nachricht oder einen Befehl als anderer Spieler.");
                            sender.sendMessage("§e/gm 0 - 3 §7Wechsel deinen Spielmodus.");
                            sender.sendMessage("§e/maintenance §7Toggelt die Wartungsarbeiten.");
                            sender.sendMessage("§e/vanish §7 Hide your ass");
                        } else {
                            sender.sendMessage(Utils.getNoPermPrefix());
                        }
                        break;
                    default:
                        break;

                }
            } else {
                sender.sendMessage(Utils.getSyntaxprefix() + "§4Um in der Helplist zu navigieren, gebe eine Seite an. §e/help 1, 2, 3");
            }

        } else {
            sender.sendMessage(Utils.getNoPermPrefix());
        }


        return false;
    }
}


