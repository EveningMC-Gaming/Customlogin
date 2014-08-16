package com.eveningmc.customlogin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.eveningmc.customlogin.Customlogin;
import com.eveningmc.customlogin.utils.Message;

public class onJoin implements Listener
{
	
	public Customlogin plugin;
	
	public onJoin(Customlogin plugin)
	{
		
		this.plugin = plugin;
		
	}
	
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e)
	{
		
		Customlogin.getInstance().setupUserdata(e.getPlayer());
		
		Message.debug("Player joined the game : (PLAYER)".replace("(PLAYER)", e.getPlayer().getName()));
		
		if((boolean) Customlogin.getInstance().getConfiguration().get("", "settings", "Player-Data"))
		{
			
			final String uuid = e.getPlayer().getUniqueId().toString();
			
			e.setJoinMessage("");
			
			final String prefix = (String) plugin.getConfiguration().get("userdata/" + uuid, e.getPlayer().getName(), "Messages.Prefix");
			final String msg = (String) plugin.getConfiguration().get("userdata/" + uuid, e.getPlayer().getName(), "Messages.Login");
			
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
			
			e.setJoinMessage("");
			
			final String prefix = (String) plugin.getConfiguration().get("", "settings", "Messages.Prefix");
			final String msg = (String) plugin.getConfiguration().get("", "settings", "Messages.Login");
			
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
