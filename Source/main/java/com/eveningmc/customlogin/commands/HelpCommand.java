package com.eveningmc.customlogin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.eveningmc.customlogin.utils.Message;

public class HelpCommand
{
	
	public static void execHelpCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		if (args.length < 2)
		{
			
			sender.sendMessage(Message.formatMessage("/customlogin help < Player | Staff | Admin >"));
			
		} else if(args[1].equalsIgnoreCase("player"))
		{
			
			sender.sendMessage(Message.format("&9]==============[&6 Player Commands &9]==============["));
			sender.sendMessage(Message.format("&c/customlogin check < Public | Private > &d- &5Check messages."));
			sender.sendMessage(Message.format("&c/customlogin setp < Prefix | Join | Quit > &d- &5Reload the plugin."));
			
		} else if(args[1].equalsIgnoreCase("staff"))
		{
			
			sender.sendMessage(Message.format("&9]==============[&6 Staff Commands &9]==============["));
			sender.sendMessage(Message.format("&c/customlogin set < Prefix | Join | Quit > &d- &5Reload the plugin."));
			
		} else if(args[1].equalsIgnoreCase("admin"))
		{
			
			sender.sendMessage(Message.format("&9]==============[&6 Admin Commands &9]==============["));
			sender.sendMessage(Message.format("&c/customlogin reload &d- &5Reload the plugin."));
			
		}
		
	}
	
}