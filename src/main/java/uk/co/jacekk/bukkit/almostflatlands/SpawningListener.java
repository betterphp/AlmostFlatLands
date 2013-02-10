package uk.co.jacekk.bukkit.almostflatlands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;

import uk.co.jacekk.bukkit.almostflatlands.generator.ChunkProvider;
import uk.co.jacekk.bukkit.baseplugin.v9_1.event.BaseListener;

public class SpawningListener extends BaseListener<AlmostFlatLands> {
	
	public SpawningListener(AlmostFlatLands plugin){
		super(plugin);
	}
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onCreatureSpawn(CreatureSpawnEvent event){
		if (event.getLocation().getWorld().getGenerator() instanceof ChunkProvider){
			event.setCancelled(true);
		}
	}
	
}
