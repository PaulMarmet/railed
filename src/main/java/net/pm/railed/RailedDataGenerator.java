package net.pm.railed;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.pm.railed.datagen.*;

public class RailedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RailedBlockLoot::new);
		pack.addProvider(RailedBlockTags::new);
		pack.addProvider(RailedLang::new);
		pack.addProvider(RailedModels::new);
		pack.addProvider(RailedRecipes::new);
	}
}
