package com.eaglerfix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EaglerHorseFix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("EaglerHorseFix plugin has been enabled!");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("EaglerHorseFix plugin has been disabled!");
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Horse) {
            Horse horse = (Horse) event.getRightClicked();
            if (!horse.isTamed()) {
                event.getPlayer().sendMessage("This horse is not tamed. You need to tame it before riding!");
            } else {
                event.getPlayer().sendMessage("This horse is already tamed and ready to ride!");
            }
        }
    }
}