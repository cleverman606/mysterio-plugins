package com.example.armorelytra;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class ArmorElytra extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new listeners.AnvilCombineListener(this), this);
        getLogger().info("ArmorElytra has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("ArmorElytra has been disabled!");
    }
}