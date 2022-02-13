package de.julian.rudecore.commands;

import de.julian.rudecore.core.Main;
import de.julian.rudecore.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatClearCommand  implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (player.hasPermission("core.admin.clearchat")) {
            for(int i=0; i<200; i++) {
                Bukkit.broadcastMessage("");
            }
            player.sendMessage(Utils.getPrefix() + "§aDer Server Chat wurde geleert.");
        } else {
            player.sendMessage(Utils.getNoPermPrefix());
        }
        return false;
    }
}
