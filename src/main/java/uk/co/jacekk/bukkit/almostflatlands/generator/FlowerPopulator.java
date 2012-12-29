package uk.co.jacekk.bukkit.almostflatlands.generator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

public class FlowerPopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk chunk){
		int x, z;
		Block block;
		
		int chunkX = chunk.getX() * 16;
		int chunkZ = chunk.getZ() * 16;
		
		for (x = 0; x < 16; ++x){
			for (z = 0; z < 16; ++z){
				if (random.nextInt(100) < 10){
					block = world.getHighestBlockAt(chunkX + x, chunkZ + z);
					
					if (block.getType() == Material.GRASS){
						block = block.getRelative(BlockFace.UP);
					}
					
					if (random.nextInt(100) < 6){
						if (random.nextInt(100) < 65){
							block.setType(Material.YELLOW_FLOWER);
						}else{
							block.setType(Material.RED_ROSE);
						}
					}else{
						block.setType(Material.LONG_GRASS);
						block.setData((byte) 0x1);
					}
				}
			}
		}
	}
	
}
