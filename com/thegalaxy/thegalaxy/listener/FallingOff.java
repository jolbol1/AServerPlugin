package com.thegalaxy.thegalaxy.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.thegalaxy.thegalaxy.SettingsManager;


public class FallingOff implements Listener {
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public void onPlayerFallEvent(EntityDamageEvent e){
		if(e.getCause() == EntityDamageEvent.DamageCause.VOID){
			Entity ent = e.getEntity();
			if(ent instanceof Player)
			e.setCancelled(true);
			World w = Bukkit.getServer().getWorld(settings.getData().getString("spawn.world"));
            double x = settings.getData().getDouble("spawn.x");
            double y = settings.getData().getDouble("spawn.y");
            double z = settings.getData().getDouble("spawn.z");
            ent.teleport(new Location(w, x, y, z));
			 
			
		}
		
	}

}
