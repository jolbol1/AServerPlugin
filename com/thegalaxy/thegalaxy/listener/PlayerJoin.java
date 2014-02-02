package com.thegalaxy.thegalaxy.listener;

import java.util.Arrays;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.thegalaxy.thegalaxy.SettingsManager;

public class PlayerJoin implements Listener{ 
	SettingsManager settings = SettingsManager.getInstance();
	SettingsManager config = SettingsManager.getInstance();
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
      Player p = e.getPlayer();
      String name = p.getName();
      
      //Message to be displayed on Ender Bar
      String message = config.getConfig().getString("BarMessage");
      String m1 = colorize(message);
      
      //Getting int for players online
      int po = Bukkit.getServer().getOnlinePlayers().length;
      
      //Broadcasting a join message
      e.setJoinMessage(ChatColor.GREEN + "+" + p.getName());
      
      //Sends message to the Player
      p.sendMessage(ChatColor.GOLD + "-----------------------------------------------");
      p.sendMessage(ChatColor.BLUE + "Welcome To The Galaxy " + p.getName());
      p.sendMessage(ChatColor.BLUE + "There are Currently " + po + " Players In The Lobby");
      p.sendMessage(ChatColor.GOLD + "-----------------------------------------------");
      
      //Sets the bar
      BarAPI.setMessage(p, m1.replaceAll("&player", name));
      
	
      
    }
	
	 public String colorize(String message){
		 return message.replaceAll("&([a-z0-9])", ChatColor.COLOR_CHAR + "$1");
		 }
	
}