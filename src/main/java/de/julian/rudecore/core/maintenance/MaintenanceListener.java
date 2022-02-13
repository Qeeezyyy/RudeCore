package de.julian.rudecore.core.maintenance;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import de.julian.rudecore.core.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class MaintenanceListener implements Listener {
    @EventHandler
    public void onJoin(PlayerLoginEvent event) {

        Player player = event.getPlayer();
        if (Main.getInstance().isMaintenance()) {
            if (player.hasPermission("core.maintenance.join")) return;
            event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "§6Rude§cAttack.de§8 §7» §c Du hast keine Rechte während den Wartungen beizutreten.");
        }
    }

    @EventHandler
    public void onPing(PaperServerListPingEvent event) {
        if (Main.getInstance().isMaintenance()) {

            event.setMaxPlayers(0);
            event.setProtocolVersion(-1);
            event.setHidePlayers(true);
            event.setVersion("JuliianDE is krass");
            event.setVersion("§4Wartungsarbeiten");
            event.setMotd("§6Rude§cAttack.de §8» §7Projekt für ContentCreator§8[§c1.18+§8]" + "\n" +
                    "§8× §cStatus: §4Wartungsarbeiten");
            return;
        }

        event.setMotd("§6Rude§cAttack.de §8» §7Projekt für ContentCreator§8[§c1.18+§8]" + "\n" +
                "§8× §cStatus: §aOnline");
    }
}
