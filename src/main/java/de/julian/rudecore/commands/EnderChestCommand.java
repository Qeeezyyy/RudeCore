package de.julian.rudecore.commands;

import de.julian.rudecore.core.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("core.enderchest")) {
               player.openInventory(player.getEnderChest());
                player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 6, 2);
            } else {
                player.sendMessage(Utils.getNoPermPrefix());
            }
        } else {
            sender.sendMessage(Utils.getSyntaxprefix() + "§7Du bist kein Spieler");
        }

        return false;
    }
}
