package com.eveningmc.customlogin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.utils.Message;

public class ReloadCommand
{
	
	private static Plugin plugin = Bukkit.getPluginManager().getPlugin("Customlogin");
	
	public static void execReloadCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		Customlogin.getInstance().getPluginManager().disablePlugin(plugin);
		Customlogin.getInstance().getPluginManager().enablePlugin(plugin);
		sender.sendMessage(Message.formatMessage("Plugin reloaded."));
		
	}
	
}
