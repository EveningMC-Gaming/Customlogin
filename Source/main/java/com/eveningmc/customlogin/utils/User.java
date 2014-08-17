package com.eveningmc.customlogin.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class User
{
	
	private static FileConfiguration config;
	
	public static File getFile(Player p)
	{
		
		return new File("EveningMC/Customlogin/userdata/" + p.getUniqueId().toString(), p.getName() + ".yml");
		
	}
	
	public static FileConfiguration getConfig(Player p)
	{
		
        File file = new File("EveningMC/Customlogin/userdata/" + p.getUniqueId().toString(), p.getName() + ".yml");
        config = YamlConfiguration.loadConfiguration(file);

        return config;
        
    }
	
	public static void save(Player p)
	{
		
		try
		{
			
			config.save(getFile(p));
			
		} catch (IOException e)
		{
			
			
			
		}
		
	}
	
}
