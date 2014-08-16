package com.eveningmc.customlogin.commands;

import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.utils.Message;

public class SetpCommand
{
	
	public static void execSetpCommand(CommandSender sender, Command command, String label, String[] args)
	{
		
		CommandHelper h = new CommandHelper(sender, command);
		
		if (sender instanceof Player)
		{
			
			Player p = (Player) sender;
			
			if (args.length < 2)
			{
				
				sender.sendMessage(Message.formatMessage("/customlogin set < Prefix | Join | Quit >"));
				
			} else if (args[1].equalsIgnoreCase("prefix"))
			{
				
				if (!sender.hasPermission("customlogin.economy.bypass") && (boolean) Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Support"))
				{
					
					EconomyResponse r = Customlogin.getInstance().econ.withdrawPlayer(p.getName(), (double) Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Cost"));
					
					if (r.transactionSuccess())
					{
						
						if (args.length > 1)
						{
							
							Customlogin.getInstance().getConfiguration().setOverride("userdata/" + p.getUniqueId().toString(), p.getName(), "Messages.Prefix", Message.toString(args, 2));
							Customlogin.getInstance().getConfiguration().save("userdata/" + p.getUniqueId().toString(), p.getName());
							
						}
						
						sender.sendMessage(Message.formatMessage("Private prefix set."));
						sender.sendMessage(Message.format("&a$" + Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Cost") + " has been removed from your account."));
						
					} else
					{

						sender.sendMessage(Message.formatError("You do not have enough money."));
						
					}
					
				} else
				{
					
					if (args.length > 1)
					{
						
						Customlogin.getInstance().getConfiguration().setOverride("userdata/" + p.getUniqueId().toString(), p.getName(), "Messages.Prefix", Message.toString(args, 2));
						Customlogin.getInstance().getConfiguration().save("userdata/" + p.getUniqueId().toString(), p.getName());
						
					}
					
					sender.sendMessage(Message.formatMessage("Private prefix set."));
					
				}
				
			} else if (args[1].equalsIgnoreCase("join"))
			{
				
				if (!sender.hasPermission("customlogin.economy.bypass") && (boolean) Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Support"))
				{
					
					EconomyResponse r = Customlogin.getInstance().econ.withdrawPlayer(p.getName(), (double) Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Cost"));
					
					if (r.transactionSuccess())
					{
						
						if (args.length > 1)
						{
							
							Customlogin.getInstance().getConfiguration().setOverride("userdata/" + p.getUniqueId().toString(), p.getName(), "Messages.Login", Message.toString(args, 2));
							Customlogin.getInstance().getConfiguration().save("userdata/" + p.getUniqueId().toString(), p.getName());
							
						}
						
						sender.sendMessage(Message.formatMessage("Private join message set."));
						sender.sendMessage(Message.format("&a$" + Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Cost") + " has been removed from your account."));
						
					} else
					{

						sender.sendMessage(Message.formatError("You do not have enough money."));
						
					}
					
				} else
				{
					
					if (args.length > 1)
					{
						
						Customlogin.getInstance().getConfiguration().setOverride("userdata/" + p.getUniqueId().toString(), p.getName(), "Messages.Prefix", Message.toString(args, 2));
						Customlogin.getInstance().getConfiguration().save("userdata/" + p.getUniqueId().toString(), p.getName());
						
					}
					
					sender.sendMessage(Message.formatMessage("Private join message set."));
					
				}
				
			} else if (args[1].equalsIgnoreCase("quit"))
			{
				
				if (!sender.hasPermission("customlogin.economy.bypass") && (boolean) Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Support"))
				{
					
					EconomyResponse r = Customlogin.getInstance().econ.withdrawPlayer(p.getName(), (double) Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Cost"));
					
					if (r.transactionSuccess())
					{
						
						if (args.length > 1)
						{
							
							Customlogin.getInstance().getConfiguration().setOverride("userdata/" + p.getUniqueId().toString(), p.getName(), "Messages.Logout", Message.toString(args, 2));
							Customlogin.getInstance().getConfiguration().save("userdata/" + p.getUniqueId().toString(), p.getName());
							
						}
						
						sender.sendMessage(Message.formatMessage("Private quit message set."));
						sender.sendMessage(Message.format("&a$" + Customlogin.getInstance().getConfiguration().get("", "settings", "Economy-Cost") + " has been removed from your account."));
						
					} else
					{
						
						sender.sendMessage(Message.formatError("You do not have enough money."));
						
					}
					
				} else
				{
					
					if (args.length > 1)
					{
						
						Customlogin.getInstance().getConfiguration().setOverride("userdata/" + p.getUniqueId().toString(), p.getName(), "Messages.Prefix", Message.toString(args, 2));
						Customlogin.getInstance().getConfiguration().save("userdata/" + p.getUniqueId().toString(), p.getName());
						
					}
					
					sender.sendMessage(Message.formatMessage("Private quit message set."));
					
				}
				
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
