package com.eveningmc.customlogin;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.eveningmc.customlogin.commands.CommandManager;
import com.eveningmc.customlogin.configs.ConfigurationManager;
import com.eveningmc.customlogin.events.onJoin;
import com.eveningmc.customlogin.events.onQuit;
import com.eveningmc.customlogin.utils.Message;

public class Customlogin extends JavaPlugin
{
	
	public static Customlogin instance;
	public PluginManager manager;
	public ConfigurationManager config;
	public Message message;
	public CommandManager cmdManager;
	public Economy econ = null;
	
	public void onLoad()
	{
		
		setInstance(this);
		setPluginManager(Bukkit.getPluginManager());
		
	}
	
	public void onEnable()
	{
		
		setConfiguration(new ConfigurationManager());
		setMessage(new Message());
		setCommandManager(new CommandManager());
		
		getCommand("customlogin").setExecutor(new CommandManager());
		
		setupSettings();
		setupEconomy();

		getPluginManager().registerEvents(new onJoin(this), this);
		getPluginManager().registerEvents(new onQuit(this), this);
		
	}
	
	public void onDisable()
	{
		
		setConfiguration(null);
		setMessage(null);
		setCommandManager(null);
		
	}
	
	public static Customlogin getInstance()
	{
		
		return instance;
		
	}
	
	private static void setInstance(Customlogin customlogin)
	{
		
		instance = customlogin;
		
	}
	
	public PluginManager getPluginManager()
	{
		
		return manager;
		
	}
	
	private void setPluginManager(PluginManager manager)
	{
		
		this.manager = manager;
		
	}
	
	public ConfigurationManager getConfiguration()
	{
		
		return config;
		
	}
	
	private void setConfiguration(ConfigurationManager config)
	{
		
		this.config = config;
		
	}
	
	public Message getMessage()
	{
		
		return message;
		
	}
	
	private void setMessage(Message message)
	{
		
		this.message = message;
		
	}
	
	public CommandManager getCommandManager()
	{
		
		return cmdManager;
		
	}
	
	private void setCommandManager(CommandManager cmdManager)
	{
		
		this.cmdManager = cmdManager;
		
	}
	
	public void setupSettings()
	{
		
		String folder = "";
		String file = "settings";
		
		getConfiguration().createFile(folder, file);
		
		getConfiguration().set(folder, file, "Debug", false);
		getConfiguration().set(folder, file, "Economy-Support", true);
		getConfiguration().set(folder, file, "Economy-Cost", 50);
		getConfiguration().set(folder, file, "Player-Data", false);
		getConfiguration().set(folder, file, "Messages.Prefix", "&9Customlogin > &r");
		getConfiguration().set(folder, file, "Messages.Login", "&a+ &6(PLAYER)");
		getConfiguration().set(folder, file, "Messages.Logout", "&c- &6(PLAYER)");
		
	}
	
	public void setupUserdata(Player p)
	{
		
		String folder = "userdata/" + p.getUniqueId().toString() + "/";
		String file = p.getName();
		
		getConfiguration().createFile(folder, file);
		
		getConfiguration().set(folder, file, "Messages.Prefix", "&9Customlogin > &r");
		getConfiguration().set(folder, file, "Messages.Login", "&a+ &3(DISPLAY)");
		getConfiguration().set(folder, file, "Messages.Logout", "&c- &3(DISPLAY)");
		
	}
	
	private boolean setupEconomy()
	{
		
		if (getServer().getPluginManager().getPlugin("Vault") == null)
		{
			
			getConfiguration().setOverride("", "settings", "Economy-Support", false);
			return false;
			
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null)
		{
			
			return false;
			
		}
		econ = rsp.getProvider();
		return econ != null;
		
	}
	
}
