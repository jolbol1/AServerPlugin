package com.thegalaxy.thegalaxy.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;




public class InventoryClear implements Listener {
    @EventHandler
public void onPlayerQuit(PlayerQuitEvent e){
        //e.setCancelled(true);
	Player p = e.getPlayer();
	String name = p.getName();
	PlayerInventory inv = p.getInventory();
	inv.clear();
	e.setQuitMessage(ChatColor.RED + "-" + name);
    }
}