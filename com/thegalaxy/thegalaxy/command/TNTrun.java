package com.thegalaxy.thegalaxy.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thegalaxy.thegalaxy.*;
//This is the code for the command /tntrun which takes you to another server.
public class TNTrun extends CommandHandler{
    
    public TNTrun(thegalaxy plugin){
        super(plugin);
    }
    
    com.thegalaxy.thegalaxy.thegalaxy thecave = new thegalaxy();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)  {
        if(cmd.getName().equalsIgnoreCase("tntrun")) {
        	sender.getName();
          plugin.teleportServer((Player)sender, "server1");
        }
		return false;
       
    }
}
