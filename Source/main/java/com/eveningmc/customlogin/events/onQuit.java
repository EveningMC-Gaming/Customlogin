package com.eveningmc.customlogin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.utils.Message;
import com.eveningmc.customlogin.utils.User;

public class onQuit implements Listener
{
	
	public Customlogin plugin;
	
	public onQuit(Customlogin plugin)
	{
		
		this.plugin = plugin;
		
	}
	
	@EventHandler
	public void onPlayerJoin(final PlayerQuitEvent e)
	{
		
		Customlogin.getInstance().setupUserdata(e.getPlayer());
		
		Message.debug("Player left the game : (PLAYER)".replace("(PLAYER)", e.getPlayer().getName()));
		
		if ((boolean) Customlogin.getInstance().getConfiguration().get("", "settings", "Player-Data"))
		{
			
			e.setQuitMessage("");
			
			final String prefix = (String) User.getConfig(e.getPlayer()).get("Messages.Prefix");
			final String msg = (String) User.getConfig(e.getPlayer()).get("Messages.Logout");
			
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
			{
				
				public void run()
				{
					
					plugin.getServer().broadcastMessage(Message.format(prefix + msg.replace("(PLAYER)", e.getPlayer().getName()).replace("(DISPLAY)", e.getPlayer().getDisplayName())));
					
				}
				
			}, 10L);
			
		} else
		{
			
			final String name = e.getPlayer().getName();
			final String display = e.getPlayer().getDisplayName();
			
			e.setQuitMessage("");
			
			final String prefix = (String) plugin.getConfiguration().get("", "settings", "Messages.Prefix");
			final String msg = (String) plugin.getConfiguration().get("", "settings", "Messages.Logout");
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
			{
				
				public void run()
				{
					
					Bukkit.broadcastMessage(Message.format(prefix + msg.replace("(PLAYER)", name).replace("(DISPLAY)", display)));
					
				}
				
			}, 10L);
			
		}
		
	}
	
}
