package de.julian.rudecore.commands;

import de.julian.rudecore.core.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("core.admin.vanish")) {

                if (args.length > 0) {

                    switch (args[0]) {

                        case "true":
                            if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 9999999, 9999999, true));
                            } else {
                                player.sendMessage(Utils.getSyntaxprefix() + "§4 Du bist bereits im Vanish!");
                            }
                            break;
                        case "false":
                            if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                            } else {
                                player.sendMessage(Utils.getSyntaxprefix() + "§4Du bist nicht im Vanish!");
                            }
                            break;

                        default:
                            break;
                    }
                } else {
                    player.sendMessage(Utils.getSyntaxprefix() + "§4gebe /vanish true oder /vanish false an!");
                }
            } else {
                player.sendMessage(Utils.getNoPermPrefix());
            }
        } else {
            sender.sendMessage(Utils.getSyntaxprefix() + "§7Du bist kein Spieler!");
        }
        return false;
    }
}