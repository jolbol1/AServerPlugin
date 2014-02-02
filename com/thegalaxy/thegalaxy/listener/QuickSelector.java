package com.thegalaxy.thegalaxy.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.thegalaxy.thegalaxy.thegalaxy;

public class QuickSelector implements Listener {
	
	public static Inventory compass = Bukkit.createInventory(null, 9, "My custom Inventory!");

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
   
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR ) {
			if(e.getItem().getItemMeta().getDisplayName().contains("Quick Selector")) {
				Player p = e.getPlayer();
				ItemStack slot0 = new ItemStack(Material.TNT, 1);
		        ItemStack slot1 = new ItemStack(Material.LADDER, 1);
		        ItemStack slot2 = new ItemStack(Material.IRON_BLOCK, 1);

		        ItemMeta meta0 = slot0.getItemMeta();
		        ItemMeta meta1 = slot1.getItemMeta();
		        ItemMeta meta2 = slot2.getItemMeta();


		        meta0.setDisplayName(ChatColor.DARK_GREEN + "TNT Run");
		        meta1.setDisplayName(ChatColor.AQUA + "King Of The Ladder");
		        meta2.setDisplayName(ChatColor.DARK_RED + "Name");

		        
		        List<String> lore0 = new ArrayList<String>();
		        lore0.add(ChatColor.GREEN + "Click To Play");
		        lore0.add(ChatColor.GREEN + "This Epic Game");
		        meta0.setLore(lore0);
		        
		        List<String> lore1 = new ArrayList<String>();
		        lore1.add(ChatColor.GREEN + "Click To Play");
		        lore1.add(ChatColor.GREEN + "This Classical Game");
		        lore1.add(ChatColor.GREEN + "Brought back by us");
		        meta1.setLore(lore1);
		        
		        List<String> lore2 = new ArrayList<String>();
		        lore2.add(ChatColor.GREEN + "Click To Join");
		        lore2.add(ChatColor.GREEN + "Server 3");
		        meta2.setLore(lore2);


		        slot0.setItemMeta(meta0);
		        slot1.setItemMeta(meta1);
		        slot2.setItemMeta(meta2);


		        

		        compass.setItem(0, slot0);
		        compass.setItem(4, slot1);
		        compass.setItem(8, slot2);



		        p.openInventory(compass);
				
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent ev){
		Player player = (Player) ev.getWhoClicked();
		ItemStack clicked = ev.getCurrentItem(); 
		Inventory inventory = ev.getInventory();
		if(inventory.getName().equals(compass.getName())) {
			if (clicked.getType() == Material.TNT) { // The item that the player clicked it dirt
				ev.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				thegalaxy thecave = new thegalaxy();
				String server1 = "server1";
				thecave.teleportServer(player, server1);
			
				
			} if (clicked.getType() == Material.LADDER) { // The item that the player clicked it dirt
				ev.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				thegalaxy thecave = new thegalaxy();
				String server2 = "server2";
				thecave.teleportServer(player, server2);
			
				
			}   if (clicked.getType() == Material.IRON_BLOCK) { // The item that the player clicked it dirt
				ev.setCancelled(true); // Make it so the dirt is back in its original spot
				player.closeInventory(); // Closes there inventory
				thegalaxy thecave = new thegalaxy();
				String server3 = "server3";
				thecave.teleportServer(player, server3);
			
				
			}
			
			
			else {
				return;
			}
		} else {
			return;
		}
	}
	
}
