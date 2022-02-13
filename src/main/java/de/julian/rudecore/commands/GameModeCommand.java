package de.julian.rudecore.commands;

import de.julian.rudecore.core.Main;
import de.julian.rudecore.core.utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GameModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("core.admin.gamemode")){

                if (args.length > 0) {
                    switch (args[0]) {

                        case "0":
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(Utils.getPrefix() + "§7Dein Spielmodus wurde auf §aSURVIVAL §7gesetzt!");
                            break;
                        case "1":
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(Utils.getPrefix() + "§7Dein Spielmodus wurde auf §aCREATIVE §7gesetzt!");
                            break;
                        case "2":
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(Utils.getPrefix() + "§7Dein Spielmodus wurde auf §aADVENTURE §7gesetzt!");
                            break;
                        case "3":
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(Utils.getPrefix() + "§7Dein Spielmodus wurde auf §aSPECTATOR §7gesetzt!");
                            break;
                        default:
                            break;
                    }
                } else {
                    player.sendMessage(Utils.getSyntaxprefix() + "§7Fehlende Argumente.");
                }


            } player.sendMessage(Utils.getNoPermPrefix());
        } else {
            sender.sendMessage(Utils.getSyntaxprefix() + "§7Du bist kein Spieler.");
        }

        return false;
    }
}
