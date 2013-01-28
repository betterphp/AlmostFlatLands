package uk.co.jacekk.bukkit.almostflatlands;

import java.io.File;

import org.bukkit.generator.ChunkGenerator;

import uk.co.jacekk.bukkit.almostflatlands.generator.ChunkProvider;
import uk.co.jacekk.bukkit.baseplugin.v8.BasePlugin;
import uk.co.jacekk.bukkit.baseplugin.v8.config.PluginConfig;

public class AlmostFlatLands extends BasePlugin {
	
	@Override
	public void onEnable(){
		super.onEnable(true);
		
		this.config = new PluginConfig(new File(this.baseDirPath + File.separator + "config.yml"), Config.class, this.log);
		
		if (this.config.getBoolean(Config.SET_WORLD_TYPE)){
			this.pluginManager.registerEvents(new WorldListener(this), this);
		}
		
		if (this.config.getBoolean(Config.PREVENT_SPAWNING)){
			this.pluginManager.registerEvents(new SpawningListener(this), this);
		}
	}
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id){
		return new ChunkProvider(this);
	}
	
}
