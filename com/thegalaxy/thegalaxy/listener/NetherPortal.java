package com.thegalaxy.thegalaxy.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class NetherPortal implements Listener {
	
	@EventHandler
	public void NetherPortalStop(PlayerPortalEvent e) {
		e.setCancelled(true);
	}

}
