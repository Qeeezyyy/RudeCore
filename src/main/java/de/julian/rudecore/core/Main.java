package de.julian.rudecore.core;

import de.julian.rudecore.commands.*;
import de.julian.rudecore.core.maintenance.MaintenanceCommand;
import de.julian.rudecore.core.maintenance.MaintenanceListener;
import de.julian.rudecore.core.tablist.TablistManager;
import de.julian.rudecore.listeners.CommandListener;
import de.julian.rudecore.listeners.ConnectionListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Main extends JavaPlugin {

    private TablistManager tablistManager;

    public TablistManager getTablistManager() {
        return tablistManager;
    }

    private static Main instance;

    private final Map<Player, Long> afkMap;

    public Main() {
        this.afkMap = new LinkedHashMap<Player, Long>();
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }


    @Override
    public void onEnable() {

        //TODO: Spawnschutz
        //TODO: InvSee
        //TODO:Fly
        //TODO: vanish
        //TODO: helplist
        //TODO: sudocommand
        //TODO: Kopf von getöteten Spieler



        Bukkit.getLogger().info("\n" +
                "\n" +
                "§a  ___           _       ___            _               \n" +
                "§a | _ \\ _  _  __| | ___ / __| _  _  ___| |_  ___  _ __  \n" +
                "§a |   /| || |/ _` |/ -_)\\__ \\| || |(_-<|  _|/ -_)| '  \\ \n" +
                "§a |_|_\\ \\_,_|\\__,_|\\___||___/ \\_, |/__/ \\__|\\___||_|_|_|\n" +
                "§a                             |__/          Plugin By Juliian#0187, Titusツ#0420                \n" +
                "§a                                           Version: V 2.0.1" + "\n"+
                "§4 DIESES SYSTEM BENÖTIGT LUCKPERMS! OHNE LUCKPERMS FUNKTIONIERT DAS SYSTEM NICHT! \n" +
                "§4 admin, developer, supporter sind die einzigen Ränge die in der TABLIST FUNKTIONIEREN!"
        );

        ListenerRegistration();
        CommandRegistration();

        tablistManager = new TablistManager();

        saveDefaultConfig();

    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("\n" +
                "\n" +
                "§4  ___           _       ___            _               \n" +
                "§4 | _ \\ _  _  __| | ___ / __| _  _  ___| |_  ___  _ __  \n" +
                "§4 |   /| || |/ _` |/ -_)\\__ \\| || |(_-<|  _|/ -_)| '  \\ \n" +
                "§4 |_|_\\ \\_,_|\\__,_|\\___||___/ \\_, |/__/ \\__|\\___||_|_|_|\n" +
                "§4                             |__/                      \n"
        );
    }

    public boolean isMaintenance() {
        return getConfig().getBoolean("maintenance");

    }

    public void setMaintenance(boolean maintenance) {
        getConfig().set("maintenance", maintenance);
        saveConfig();
    }


    private void ListenerRegistration() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new MaintenanceListener(), this);
        pm.registerEvents(new ConnectionListener(), this);
        pm.registerEvents(new CommandListener(), this);


    }

    private void CommandRegistration() {
        getCommand("clearchat").setExecutor(new ChatClearCommand());
        getCommand("gamemode").setExecutor(new GameModeCommand());
        getCommand("maintenance").setExecutor(new MaintenanceCommand());
        getCommand("info").setExecutor(new InformationCommand());
        getCommand("sudo").setExecutor(new SudoCommand());
        getCommand("help").setExecutor(new HelpListCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("vanish").setExecutor(new VanishCommand());


    }

    public Map<Player, Long> getAfkMap() {
        return afkMap;
    }



}
