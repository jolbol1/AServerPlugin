package com.thegalaxy.thegalaxy.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
	
	@EventHandler
	public void BlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(!(p.hasPermission("thegalaxy.build"))) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "[The Galaxy] You Cannot Build Here");
    
	}

}
}
