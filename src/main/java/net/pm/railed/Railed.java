package net.pm.railed;

import net.fabricmc.api.ModInitializer;

import net.pm.railed.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Railed implements ModInitializer {
	public static final String MOD_ID = "railed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Blocks.initialize();
	}
}