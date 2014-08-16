package com.eveningmc.customlogin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.eveningmc.customlogin.utils.Message;

public class CommandHelper
{
	
	CommandSender sender;
	Command cmd;
	
	public CommandHelper(CommandSender cs, Command cm)
	{
		
		sender = cs;
		cmd = cm;
		
	}
	
	public void noPermission()
	{
		
		sender.sendMessage(Message.formatError("You don''t have permission for this command."));
		
	}
	
	public void noConsole()
	{
		
		sender.sendMessage(Message.formatError("Only in-game players can use this command."));
		
	}
	
	public void unknownCommand()
	{
		
		sender.sendMessage(Message.formatError("Unknown command."));
		helpCommand();
		
	}
	
	public void helpCommand()
	{
		
		sender.sendMessage(Message.formatMessage("Type /customlogin help, for help."));
		
	}
	
	public void tooManyArgs()
	{
		
		sender.sendMessage(Message.formatError("You have provided too many agruments."));
		helpCommand();
		
	}
	
	public void notEnoughArgs()
	{
		
		sender.sendMessage(Message.formatError("You have not provided enough agruments."));
		helpCommand();
		
	}
	
}
