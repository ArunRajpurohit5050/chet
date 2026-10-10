package net.chet;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.StructureTags;
import org.apache.logging.log4j.core.jmx.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chet implements ModInitializer {
	public static final String MOD_ID = "chet";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(server ->{
            long seed = server.overworld().getSeed();
			ServerLevel level = server.overworld();
			BlockPos spawn = level.getRespawnData().pos();
			BlockPos village = level.findNearestMapStructure(
					StructureTags.VILLAGE,
					spawn,
					64,
					false
			);

            System.out.println("Seed is this ARN: " + seed);
			System.out.println("Spwan pos is this ARN: "+ spawn);
			if (village != null){
				System.out.println("village pos is:"+ village);
			} else {
				System.out.println("no villages found in search radius");
			}
        });

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
