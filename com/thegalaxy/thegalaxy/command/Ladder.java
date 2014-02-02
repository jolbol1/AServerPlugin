package com.thegalaxy.thegalaxy.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thegalaxy.thegalaxy.*;
//This is the code for the command /tntrun which takes you to another server.
public class Ladder extends CommandHandler{
    
    public Ladder(thegalaxy plugin){
        super(plugin);
    }
    
    com.thegalaxy.thegalaxy.thegalaxy thecave = new thegalaxy();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)  {
    	String player = sender.getName();
        if(cmd.getName().equalsIgnoreCase("ladder")) {
        	sender.getName();
          plugin.teleportServer((Player)sender, "server2");
        }
		return false;
       
    }
}