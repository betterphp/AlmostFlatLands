package uk.co.jacekk.bukkit.almostflatlands;

import java.lang.reflect.Field;

import net.minecraft.server.v1_4_6.WorldServer;
import net.minecraft.server.v1_4_6.WorldType;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_4_6.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.world.WorldInitEvent;

import uk.co.jacekk.bukkit.almostflatlands.generator.ChunkProvider;
import uk.co.jacekk.bukkit.baseplugin.v7.event.BaseListener;

public class WorldListener extends BaseListener<AlmostFlatLands> {
	
	public WorldListener(AlmostFlatLands plugin){
		super(plugin);
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onWorldInit(WorldInitEvent event){
		World world = event.getWorld();
		
		if (world.getGenerator() instanceof ChunkProvider){
			WorldServer worldServer = ((CraftWorld) world).getHandle();
			
			try{
				Class<?> worldData = worldServer.worldData.getClass();
				
				Field type = worldData.getDeclaredField("type");
				
				type.setAccessible(true);
				type.set(worldServer.worldData, WorldType.FLAT);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
