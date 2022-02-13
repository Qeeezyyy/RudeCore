package de.julian.rudecore.core.maintenance;

import de.julian.rudecore.core.Main;
import de.julian.rudecore.core.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MaintenanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.hasPermission("core.admin.maintenance.toggle")) {

            if (Main.getInstance().isMaintenance()) {
                Main.getInstance().setMaintenance(false);
                sender.sendMessage("§8[§6Rude§cAttack.de§8] §6Informationen zum RudeAttack-Netzwerk");
                sender.sendMessage("§4Die Wartungs-Arbeiten wurden Deaktiviert.");
            } else {
                Main.getInstance().setMaintenance(true);
                sender.sendMessage("§8[§6Rude§cAttack.de§8] §6Informationen zum RudeAttack-Netzwerk");
                sender.sendMessage("§4Die Wartungs-Arbeiten wurden Aktiviert.");
            }
        } else {
            sender.sendMessage(Utils.getNoPermPrefix());
        }

        return false;
    }
}
