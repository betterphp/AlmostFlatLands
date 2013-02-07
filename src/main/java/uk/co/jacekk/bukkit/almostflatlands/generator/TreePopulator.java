package uk.co.jacekk.bukkit.almostflatlands.generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import uk.co.jacekk.bukkit.almostflatlands.AlmostFlatLands;
import uk.co.jacekk.bukkit.almostflatlands.Config;
import uk.co.jacekk.bukkit.baseplugin.v9.util.ListUtils;

public class TreePopulator extends BlockPopulator {
	
	private AlmostFlatLands plugin;
	
	public TreePopulator(AlmostFlatLands plugin){
		this.plugin = plugin;
	}
	
	public void populate(World world, Random random, Chunk chunk){
		if (random.nextInt(100) < plugin.config.getInt(Config.WORLD_TREE_CHANCE)){
			int x = chunk.getX() * 16 + random.nextInt(5) + 6;
			int z = chunk.getZ() * 16 + random.nextInt(5) + 6;
			int y = world.getHighestBlockYAt(x, z);
			
			world.generateTree(new Location(world, x, y, z), TreeType.valueOf(ListUtils.getRandom(plugin.config.getStringList(Config.WORLD_TREE_TYPES))));
		}
	}
	
}
