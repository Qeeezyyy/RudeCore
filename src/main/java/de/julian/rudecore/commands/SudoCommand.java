package de.julian.rudecore.commands;

import de.julian.rudecore.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SudoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (player.hasPermission("core.admin.sudo")) {


            if (args.length < 1) {
                player.sendMessage(Utils.getSyntaxprefix() + "§4Dieser Befehl Existiert nicht. Mache §c/sudo Spieler Nachricht");
                return false;
            }

            Player target = Bukkit.getPlayer(args[0]);
            StringBuilder b = new StringBuilder();

            for (int i = 1; i < args.length; i++) {
                b.append(args[i] + " ");
            }

            target.chat(b.toString());
            return true;
        } else {
            player.sendMessage(Utils.getNoPermPrefix());
        }
        return false;
    }
}
