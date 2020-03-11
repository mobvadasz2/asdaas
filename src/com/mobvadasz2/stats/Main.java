package com.mobvadasz2.stats;

import com.mobvadasz2.stats.commands.StatsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.registerCommands();
    }

    public void onDisable() {

    }

    public void registerCommands() {
        getCommand("stats").setExecutor(new StatsCommand());
    }
}
