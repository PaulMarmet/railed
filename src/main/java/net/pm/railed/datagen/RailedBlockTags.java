package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedBlockTags extends FabricTagProvider.BlockTagProvider{
    public RailedBlockTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.RAILS)
                .add(Blocks.SELF_POWERED_RAIL)
                .setReplace(false);
    }
}
