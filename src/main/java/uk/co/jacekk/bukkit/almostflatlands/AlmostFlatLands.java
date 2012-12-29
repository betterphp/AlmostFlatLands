package uk.co.jacekk.bukkit.almostflatlands;

import org.bukkit.generator.ChunkGenerator;

import uk.co.jacekk.bukkit.almostflatlands.generator.ChunkProvider;
import uk.co.jacekk.bukkit.baseplugin.v7.BasePlugin;

public class AlmostFlatLands extends BasePlugin {
	
	@Override
	public void onEnable(){
		super.onEnable(false);
		
		this.pluginManager.registerEvents(new WorldListener(this), this);
	}
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id){
		return new ChunkProvider();
	}
	
}
