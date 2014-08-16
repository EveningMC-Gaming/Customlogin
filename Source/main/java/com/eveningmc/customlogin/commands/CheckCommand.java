package com.eveningmc.customlogin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.utils.Message;

public class CheckCommand
{
	
	public static void execCheckCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		CommandHelper h = new CommandHelper(sender, command);
		
		if (sender instanceof Player)
		{
			
			if (args[1].equalsIgnoreCase("private"))
			{
				
				Player p = (Player) sender;
				
				String uuid = p.getUniqueId().toString();
				
				String prefix = (String) Customlogin.getInstance().getConfiguration().get("userdata/" + uuid, p.getName(), "Messages.Prefix");
				String join = (String) Customlogin.getInstance().getConfiguration().get("userdata/" + uuid, p.getName(), "Messages.Login");
				String quit = (String) Customlogin.getInstance().getConfiguration().get("userdata/" + uuid, p.getName(), "Messages.Logout");
				
				p.sendMessage(Message.format(prefix + join.replace("(PLAYER)", p.getName()).replace("(DISPLAY)", p.getDisplayName())));
				p.sendMessage(Message.format(prefix + quit.replace("(PLAYER)", p.getName()).replace("(DISPLAY)", p.getDisplayName())));
				
			} else if (args[1].equalsIgnoreCase("public"))
			{
				
				Player p = (Player) sender;
				
				String prefix = (String) Customlogin.getInstance().getConfiguration().get("", "settings", "Messages.Prefix");
				String join = (String) Customlogin.getInstance().getConfiguration().get("", "settings", "Messages.Login");
				String quit = (String) Customlogin.getInstance().getConfiguration().get("", "settings", "Messages.Logout");
				
				p.sendMessage(Message.format(prefix + join.replace("(PLAYER)", p.getName()).replace("(DISPLAY)", p.getDisplayName())));
				p.sendMessage(Message.format(prefix + quit.replace("(PLAYER)", p.getName()).replace("(DISPLAY)", p.getDisplayName())));
				
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
