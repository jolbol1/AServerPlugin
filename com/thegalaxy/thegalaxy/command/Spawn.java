package com.thegalaxy.thegalaxy.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.thegalaxy.thegalaxy.CommandHandler;
import com.thegalaxy.thegalaxy.SettingsManager;
import com.thegalaxy.thegalaxy.thegalaxy;

public class Spawn extends CommandHandler {
	
	SettingsManager settings = SettingsManager.getInstance();

	public Spawn(thegalaxy plugin) {
		super(plugin);
	}
	
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        //Checks if the sender is a player
        if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "This plugin is for players only!");
                return true;
        }
       
        //Grabs the player
        Player p = (Player) sender;
       
        //This command enables us to teleprt to a players location
        if (cmd.getName().equalsIgnoreCase("tp")) {
                if (args.length == 0) {
                        p.sendMessage(ChatColor.RED + "Please specify a player.");
                        return true;
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                        p.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");
                        return true;
                }
                p.teleport(target.getLocation());
                return true;
        }
       
        //This command sets the servers spawn
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
                settings.getData().set("spawn.world", p.getLocation().getWorld().getName());
                settings.getData().set("spawn.x", p.getLocation().getX());
                settings.getData().set("spawn.y", p.getLocation().getY());
                settings.getData().set("spawn.z", p.getLocation().getZ());
                settings.saveData();
                p.sendMessage(ChatColor.GREEN + "Spawn set!");
                return true;
        }
       
        //Allows us to teleport to the servers spawn
        if (cmd.getName().equalsIgnoreCase("spawn")) {
                if (settings.getData().getConfigurationSection("spawn") == null) {
                        p.sendMessage(ChatColor.RED + "The spawn has not yet been set!");
                        return true;
                }
                World w = Bukkit.getServer().getWorld(settings.getData().getString("spawn.world"));
                double x = settings.getData().getDouble("spawn.x");
                double y = settings.getData().getDouble("spawn.y");
                double z = settings.getData().getDouble("spawn.z");
                p.teleport(new Location(w, x, y, z));
                p.sendMessage(ChatColor.GREEN + "Welcome to the spawn!");
        }
		return false;
       
   }

}
