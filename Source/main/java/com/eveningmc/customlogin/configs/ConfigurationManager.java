package com.eveningmc.customlogin.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigurationManager
{
	
	public File folder;
	public File file;
	public FileConfiguration config;
	
	public FileConfiguration getConfig(String folderName, String fileName)
	{
		
		folder = new File("EveningMC/Customlogin/" + folderName);
		file = new File(folder, fileName + ".yml");
		
		config = YamlConfiguration.loadConfiguration(file);
		
		if (config == null)
		{
			
			createFile(folderName, fileName);
			
		}
		
		return config;
		
	}
	
	public void createFile(String folderName, String fileName)
	{
		
		folder = new File("EveningMC/Customlogin/" + folderName);
		if (!folder.exists())
		{
			
			folder.mkdir();
			
		}
		
		file = new File(folder, fileName + ".yml");
		if (!file.exists())
		{
			
			try
			{
				
				file.createNewFile();
				
				save(folderName, fileName);
				
			} catch (Exception e)
			{
				
				
				
			}
			
			config = YamlConfiguration.loadConfiguration(file);
			
		}
		
	}
	
	public void save(String folderName, String fileName)
	{
		
		folder = new File("EveningMC/Customlogin/" + folderName);
		file = new File(folder, fileName + ".yml");
		
		if (config == null)
		{
			
			return;
			
		}
		
		try
		{
			
			config.save(file);
			
		} catch (IOException e)
		{
			
			
			
		}
		
	}
	
	public void set(String folderName, String fileName, String path, Object o)
	{
		
		folder = new File("EveningMC/Customlogin/" + folderName);
		file = new File(folder, fileName + ".yml");
		
		config = YamlConfiguration.loadConfiguration(file);
		
		if (!config.contains(path))
		{
			
			getConfig(folderName, fileName).set(path, o);
			save(folderName, fileName);
			
		}
		
	}
	
	public void setOverride(String folderName, String fileName, String path, Object o)
	{
		
		folder = new File("EveningMC/Customlogin/" + folderName);
		file = new File(folder, fileName + ".yml");
		
		config = YamlConfiguration.loadConfiguration(file);
		
		getConfig(folderName, fileName).set(path, o);
		save(folderName, fileName);
		
	}
	
	public Object get(String folderName, String fileName, String path)
	{
		
		folder = new File("EveningMC/Customlogin/" + folderName);
		file = new File(folder, fileName + ".yml");
		
		config = YamlConfiguration.loadConfiguration(file);
		
		return config.get(path);
		
	}
	
	public Object get(String folderName, String fileName, String path, Object o)
	{
		
		folder = new File("EveningMC/Customlogin/" + folderName);
		file = new File(folder, fileName + ".yml");
		
		config = YamlConfiguration.loadConfiguration(file);
		
		return config.get(path, o);
		
	}
	
}
