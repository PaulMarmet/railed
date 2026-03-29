package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedBlockTags extends FabricTagsProvider.BlockTagsProvider{
    public RailedBlockTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.PREVENT_MOB_SPAWNING_INSIDE)
                .add(Blocks.SELF_POWERED_RAIL);
        valueLookupBuilder(BlockTags.RAILS)
                .add(Blocks.SELF_POWERED_RAIL);
    }
}
