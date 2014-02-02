package com.thegalaxy.thegalaxy.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(!(p.hasPermission("thegalaxy.build"))) {
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "[The Galaxy] You Cannot Build");
			
		}
		
	}

}
