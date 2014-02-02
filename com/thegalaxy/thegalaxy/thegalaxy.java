package com.thegalaxy.thegalaxy;

//Java Imports
import java.util.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;



















import org.bukkit.Bukkit;
import org.bukkit.World;
//Managing Imports
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.entity.Player;

















//Command Imports
//Listener Imports



import com.thegalaxy.thegalaxy.command.Ladder;
import com.thegalaxy.thegalaxy.command.Spawn;
import com.thegalaxy.thegalaxy.command.TNTrun;
import com.thegalaxy.thegalaxy.listener.BlockBreak;
import com.thegalaxy.thegalaxy.listener.BlockPlace;
import com.thegalaxy.thegalaxy.listener.FallingOff;
import com.thegalaxy.thegalaxy.listener.InventoryClear;
import com.thegalaxy.thegalaxy.listener.NetherPortal;
import com.thegalaxy.thegalaxy.listener.OnSignClick;
import com.thegalaxy.thegalaxy.listener.PlayerJoin;
import com.thegalaxy.thegalaxy.listener.Portals;
import com.thegalaxy.thegalaxy.listener.QuickSelector;
import com.thegalaxy.thegalaxy.listener.Sig;
import com.thegalaxy.thegalaxy.listener.Weather;




public class thegalaxy extends org.bukkit.plugin.java.JavaPlugin{
       
	    //Registering the plugin
	    private static Plugin plugin;
	    //The Logger
		public final Logger log = Logger.getLogger("com.thecave.thecave");
		
		//Loading the config and settings files.
		SettingsManager settings = SettingsManager.getInstance();
		SettingsManager config = SettingsManager.getInstance();
	



    
    public void onEnable() {
    	//Again registering the plugin
    	plugin = this;
        //Loading the decription file
        PluginDescriptionFile pdf = getDescription();
        
        //Register our events
        getServer().getPluginManager().registerEvents(new InventoryClear(), this);
        getServer().getPluginManager().registerEvents(new NetherPortal(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnSignClick(), this);
        getServer().getPluginManager().registerEvents(new QuickSelector(), this);
        getServer().getPluginManager().registerEvents(new FallingOff(), this);
        getServer().getPluginManager().registerEvents(new Weather(), this);
        getServer().getPluginManager().registerEvents(new Portals(), this);
        getServer().getPluginManager().registerEvents(new Sig(), this);
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
     
        
        //Register commands
        getCommand("tntrun").setExecutor(new TNTrun(this));
        getCommand("tp").setExecutor(new Spawn(this));  
        getCommand("setspawn").setExecutor(new Spawn(this));
        getCommand("spawn").setExecutor(new Spawn(this));
        getCommand("ladder").setExecutor(new Ladder(this));
        getCommand("nickname").setExecutor(new Ladder(this));
        
 
        settings.setup(this);
        config.setup(this);
        log.info("[" + pdf.getName() + "] version " + pdf.getVersion() + " enabled.");
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
       
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

			@Override
			public void run() {
			Bukkit.getServer().getWorld("world").setTime(0);
		    Bukkit.getServer().getWorld("world").setStorm(false);
			}
            //Do something
        }, 20L, 6000);
    }


    
    
    public void onDisable(){
        
    }
    
    public static void teleportServer(Player p, String server){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
 
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException eee) {
            
        }
 
        p.sendPluginMessage(thegalaxy.getPlugin(), "BungeeCord", b.toByteArray());
    }
    
    public static Plugin getPlugin() {
        return plugin;
    }
    
    
    
    
        
    }
    
    
   
    
