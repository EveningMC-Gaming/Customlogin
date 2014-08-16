package com.eveningmc.customlogin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor
{
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		CommandHelper h = new CommandHelper(sender, command);
		
		if(args.length < 1)
		{
			
			h.helpCommand();
			
		} else if(args[0].equalsIgnoreCase("reload"))
		{
			
			if(sender.hasPermission("customlogin.reload"))
			{
				
				ReloadCommand.execReloadCommand(sender, command, label, args);
				
			} else
			{
				
				h.noPermission();
				
			}
			
		} else if (args[0].equalsIgnoreCase("help"))
		{
			
			if(sender.hasPermission("customlogin.help"))
			{
				
				HelpCommand.execHelpCommand(sender, command, label, args);
				
			} else
			{
				
				h.noPermission();
				
			}
			
		} else if(args[0].equalsIgnoreCase("check"))
		{
			
			if(sender.hasPermission("customlogin.check"))
			{
				
				CheckCommand.execCheckCommand(sender, command, label, args);
				
			} else
			{
				
				h.noPermission();
				
			}
			
		} else if(args[0].equalsIgnoreCase("set"))
		{
			
			if(sender.hasPermission("customlogin.set"))
			{
				
				SetCommand.execSetCommand(sender, command, label, args);
				
			} else
			{
				
				h.noPermission();
				
			}
			
		} else if(args[0].equalsIgnoreCase("setp"))
		{
			
			if(sender.hasPermission("customlogin.setp"))
			{
				
				SetpCommand.execSetpCommand(sender, command, label, args);
				
			} else
			{
				
				h.noPermission();
				
			}
			
		} else
		{
			
			h.unknownCommand();
			
		}
		
		return false;
		
	}
}