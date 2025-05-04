package com.example.eaglerboatfix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EaglerBoatFixPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BoatEventListener(), this);
        getLogger().info("EaglerBoatFix plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("EaglerBoatFix plugin has been disabled.");
    }

    public static class BoatEventListener implements Listener {

        @EventHandler
        public void onVehicleEnter(VehicleEnterEvent event) {
            if (event.getVehicle() instanceof Boat && event.getEntered() instanceof Player) {
                Boat boat = (Boat) event.getVehicle();
                Player player = (Player) event.getEntered();
                boat.setVelocity(boat.getVelocity().setY(0));
                player.sendMessage("You have entered a boat. If it was glitched, it should now be fixed.");
            }
        }

        @EventHandler
        public void onVehicleMove(VehicleMoveEvent event) {
            if (event.getVehicle() instanceof Boat) {
                Boat boat = (Boat) event.getVehicle();
                if (boat.getVelocity().length() < 0.01) {
                    boat.setVelocity(boat.getVelocity().add(boat.getLocation().getDirection().multiply(0.1)));
                }
            }
        }
    }
}