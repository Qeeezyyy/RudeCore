package de.julian.rudecore.listeners;

import de.julian.rudecore.core.Main;
import de.julian.rudecore.core.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {


    @EventHandler
    public void onPreProcess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (event.getMessage().contains("plugins")) {
            player.sendMessage(Utils.getSyntaxprefix() + "§7Dein TV Gerät wurde Erfolgreich mit Viren Infiziert.");
            event.setCancelled(true);
        }
        if (event.getMessage().contains("pl")) {
            player.sendMessage(Utils.getSyntaxprefix() + "§7Dein TV Gerät wurde Erfolgreich mit Viren Infiziert.");
            event.setCancelled(true);
        }
        if (event.getMessage().contains("ver")) {
            player.sendMessage(Utils.getSyntaxprefix() + "§7Dein TV Gerät wurde Erfolgreich mit Viren Infiziert.");
            event.setCancelled(true);
        }

    }

}
