package uk.co.jacekk.bukkit.almostflatlands.generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TreePopulator extends BlockPopulator {
	
	public void populate(World world, Random random, Chunk chunk){
		if (random.nextInt(100) < 15){
			int x = chunk.getX() * 16 + random.nextInt(5) + 6;
			int z = chunk.getZ() * 16 + random.nextInt(5) + 6;
			int y = world.getHighestBlockYAt(x, z);
			
			if (random.nextInt(100) < 50){
				world.generateTree(new Location(world, x, y, z), TreeType.TREE);
			}else if (random.nextInt(100) < 25){
				world.generateTree(new Location(world, x, y, z), TreeType.BIRCH);
			}else{
				world.generateTree(new Location(world, x, y, z), TreeType.BIG_TREE);
			}
		}
	}
	
}
