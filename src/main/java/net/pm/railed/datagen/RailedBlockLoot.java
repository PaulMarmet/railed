package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedBlockLoot extends FabricBlockLootSubProvider {
    public RailedBlockLoot(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(dataOutput, registriesFuture);
    }

    @Override
    public void generate() {
        add(Blocks.SELF_POWERED_RAIL, createSingleItemTable(Blocks.SELF_POWERED_RAIL));
    }
}
