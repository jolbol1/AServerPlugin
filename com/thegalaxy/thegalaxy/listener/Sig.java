package com.thegalaxy.thegalaxy.listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.material.Sign;

public class Sig implements Listener  {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if(e.getLine(0).contains("&([a-z0-9])")) {
			String line0 = e.getLine(0);
			String color0 = colorize(line0);
			e.setLine(0, color0);	
		}
		if(e.getLine(1).contains("&([a-z0-9])")) {
			String line1 = e.getLine(1);
			String color1 = colorize(line1);
			e.setLine(1, color1);	
		}
		if(e.getLine(2).contains("&([a-z0-9])")) {
			String line2 = e.getLine(2);
			String color2 = colorize(line2);
			e.setLine(2, color2);	
		}
		if(e.getLine(3).contains("&([a-z0-9])")) {
			String line3 = e.getLine(3);
			String color3 = colorize(line3);
			e.setLine(3, color3);	
		}
		
	}
	
	public String colorize(String message){
		 return message.replaceAll("&([a-z0-9])", ChatColor.COLOR_CHAR + "$1");
		 }
}

