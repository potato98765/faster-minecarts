package com.mrpotato.fasterminecarts;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FasterMinecarts extends JavaPlugin implements Listener {

    private double maxSpeed;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadSettings();
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("FasterMinecarts enabled! Max speed = " + maxSpeed);
    }

    private void loadSettings() {
        maxSpeed = getConfig().getDouble("max-speed", 1.2);
    }

    @EventHandler
    public void onMinecartSpawn(VehicleCreateEvent event) {
        if (event.getVehicle() instanceof Minecart cart) {
            cart.setMaxSpeed(maxSpeed);
        }
    }

    @EventHandler
    public void onMinecartEnter(VehicleEnterEvent event) {
        if (event.getVehicle() instanceof Minecart cart) {
            cart.setMaxSpeed(maxSpeed);
        }
    }
}
