package de.julian.rudecore.listeners;

import de.julian.rudecore.core.Main;
import de.julian.rudecore.core.utils.Utils;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        event.setJoinMessage(Utils.getPrefix() + "§a" + event.getPlayer().getDisplayName() + " §7ist dem Server beigetreten");

        if (!player.hasPlayedBefore()) {
            player.sendMessage(Utils.getPrefix() + "§7Willkommen auf unserem Server!");
            player.setFoodLevel(20);
            player.setHealth(20);
        } else {
            player.sendMessage(Utils.getPrefix() + "§7Willkommen zurück!");
        }

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5, 2);



    }

    @EventHandler
    public void setTablist(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        Main.getInstance().getTablistManager().setPlayerList(player);
        Main.getInstance().getTablistManager().setAllPlayerTeams();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(Utils.getPrefix() + "§a" + event.getPlayer().getName() + " §7hat den Server verlassen ");
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("core.player.move")) {
            event.setCancelled(false);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        event.setDeathMessage(Utils.getPrefix() +
               "§7Der Spieler" + player.getName() + " §7ist an " + ChatColor.YELLOW + player.getLastDamageCause().getCause().toString() + " §7gestorben.");


    }

}






