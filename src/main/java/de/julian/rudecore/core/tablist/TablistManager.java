package de.julian.rudecore.core.tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

//§6Rude§cAttack.de

public class TablistManager {

    public void setPlayerList(Player player) {
        player.setPlayerListHeaderFooter(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "           [" +
                        "§cSurvival §bProjekt" + ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "]           " + "\n" +
                        "\n§cSurvial Projekt" + "\n "
                , "\n " + "§bViel Spaß auf dem §cSurvival §bProjekt!" + "\n " + "§eHilfe: /help\n" + "\n§6Plugin coded by Juliian#0187" + "\n" +
                        ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "           [" +
                        "§cSurvival §bProjekt" + ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "]           ");
    }

    public void setAllPlayerTeams() {
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeams);
    }

    public void setPlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        Team operators = scoreboard.getTeam("00001operators");
        if(operators == null) {
            operators = scoreboard.registerNewTeam("00001operators");
        }

        Team developers = scoreboard.getTeam("00010developers");
        if(developers == null) {
            developers = scoreboard.registerNewTeam("00010developers");
        }

        Team supporters = scoreboard.getTeam("01000supporters");
        if(supporters == null) {
            supporters = scoreboard.registerNewTeam("01000supporters");
        }

        Team players = scoreboard.getTeam("01000players");
        if(players == null) {
            players = scoreboard.registerNewTeam("01000players");
        }

        operators.setPrefix(ChatColor.DARK_RED + "Admin " + ChatColor.DARK_GRAY + "» ");
        operators.setColor(ChatColor.DARK_RED);

        developers.setPrefix(ChatColor.AQUA + "Dev " + ChatColor.DARK_GRAY + "» ");
        developers.setColor(ChatColor.AQUA);

        supporters.setPrefix(ChatColor.YELLOW + "Sup " + ChatColor.DARK_GRAY + "» ");
        supporters.setColor(ChatColor.YELLOW);

        players.setPrefix(ChatColor.GREEN + "Player " + ChatColor.DARK_GRAY + "» ");
        players.setColor(ChatColor.GREEN);

        for (Player target: Bukkit.getOnlinePlayers()) {
            if(target.hasPermission("core.tablist.admin")) {
                operators.addEntry(target.getName());
                continue;
            } else if(target.hasPermission("core.tablist.developers")) {
                developers.addEntry(target.getName());
                continue;
            } else if(target.hasPermission("core.tablist.supporters")) {
                supporters.addEntry(target.getName());
                continue;
            }

            players.addEntry(target.getName());
        }

    }

}
