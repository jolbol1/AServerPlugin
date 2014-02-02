package com.thegalaxy.thegalaxy.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.thegalaxy.thegalaxy.SettingsManager;

public class OnSignClick implements Listener {
	SettingsManager settings = SettingsManager.getInstance();
	
	@EventHandler
	public boolean signClick(PlayerInteractEvent e) {
		
		 Block block = e.getClickedBlock();
		 Player p = e.getPlayer();
		if (block.getType() == Material.WALL_SIGN || block.getType() == Material.SIGN_POST) {
			  Sign sign = (Sign) block.getState();
			  if(sign.getLine(0).contains("[TheGalaxy]")) {
				  World w = Bukkit.getServer().getWorld(settings.getData().getString("spawn.world"));
		            double x = settings.getData().getDouble("spawn.x");
		            double y = settings.getData().getDouble("spawn.y");
		            double z = settings.getData().getDouble("spawn.z");
		            p.teleport(new Location(w, x, y, z));
			} else {
			  return false;
			}
			  if(sign.getLine(2).contains("Finish")) {
				  Player pp = e.getPlayer();
				  String name = pp.getName();
				  Bukkit.getServer().broadcastMessage(ChatColor.GREEN + name + " Has finished the Server Parkour!" );
				  
				  
			  } 
		} 
		return false;
		
	}
	

}
