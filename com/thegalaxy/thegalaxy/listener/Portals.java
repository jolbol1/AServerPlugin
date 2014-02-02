package com.thegalaxy.thegalaxy.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;

import com.thegalaxy.thegalaxy.thegalaxy;

public class Portals implements Listener {

	@EventHandler
    public void onPlayerent(PlayerMoveEvent e) {
    	Player p = e.getPlayer();
 
     if(p.getLocation().getBlock().getRelative(BlockFace.UP).getType() == Material.PORTAL) {
    	if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.GOLD_BLOCK) {
    		thegalaxy.teleportServer(p, "server1");
    	}
    	if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
    		thegalaxy.teleportServer(p, "server2");
    	}
    	if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WOOL) {
    		thegalaxy.teleportServer(p, "server3");
    	}
    	
    }
	}
}
