package com.eveningmc.customlogin.utils;

import java.util.logging.Level;

import com.eveningmc.customlogin.Customlogin;

public class Message
{
	
	public static void log(String message)
	{
		
		Customlogin.getInstance().getLogger().info(message);
		
	}
	
	public static void log(Level level, String message)
	{
		
		Customlogin.getInstance().getLogger().log(level, message);
		
	}
	
	public static void debug(String message)
	{
		
		if (Customlogin.getInstance().getConfiguration().getConfig("", "settings").getBoolean("Debug") != false)
		{
			
			log("< DEBUG > " + message);
			
		}
		
	}
	
	public static void debug(Level level, String message)
	{
		
		if (Customlogin.getInstance().getConfiguration().getConfig("", "settings").getBoolean("Debug") != false)
		{
			
			log(level, "< DEBUG > " + message);
			
		}
		
	}
	
	public static String format(String message)
	{
		
		return message.replaceAll("&", "\247");
		
	}
	
	public static String formatMessage(String message)
	{
		
		message = format("&9" + Customlogin.getInstance().getName() + " > &a" + message);
		return message;
		
	}
	
	public static String formatError(String message)
	{
		
		message = format("&9" + Customlogin.getInstance().getName() + " > &c" + message);
		return message;
		
	}
	
	public static String toString(String[] arguments, int start)
	{
		
		String returnString = "";
		for(int count = start; count < arguments.length; count++)
		{

			if(count == start)
			{
				
				returnString = arguments[count];
				
			} else
			{
				
				returnString = returnString + " " + arguments[count];
				
			}

		}

		return returnString;
		
	}
	
}
