package com.eveningmc.customlogin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.utils.Message;

public class SetCommand
{
	
	public static void execSetCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		CommandHelper h = new CommandHelper(sender, command);
		
		if (sender instanceof Player)
		{
			
			if (args.length < 2)
			{
				
				sender.sendMessage(Message.formatMessage("/customlogin set < Prefix | Join | Quit >"));
				
			} else if (args[1].equalsIgnoreCase("prefix"))
			{
				
				if (args.length > 1)
				{
					
					Customlogin.getInstance().getConfiguration().setOverride("", "settings", "Messages.Prefix", Message.toString(args, 2));
					Customlogin.getInstance().getConfiguration().save("", "settings");
					
				}
				
				sender.sendMessage(Message.formatMessage("Public prefix set."));
				
			} else if (args[1].equalsIgnoreCase("join"))
			{
				
				if (args.length > 1)
				{
					
					Customlogin.getInstance().getConfiguration().setOverride("", "settings", "Messages.Login", Message.toString(args, 2));
					Customlogin.getInstance().getConfiguration().save("", "settings");
					
				}
				
				sender.sendMessage(Message.formatMessage("Public join message set."));
				
			} else if (args[1].equalsIgnoreCase("quit"))
			{
				
				if (args.length > 1)
				{
					
					Customlogin.getInstance().getConfiguration().setOverride("", "settings", "Messages.Logout", Message.toString(args, 2));
					Customlogin.getInstance().getConfiguration().save("", "settings");
					
				}
				
				sender.sendMessage(Message.formatMessage("Public quit message set."));
				
			} else
			{
				
				h.unknownCommand();
				
			}
			
		} else
		{
			
			h.noConsole();
			
		}
		
	}
}
