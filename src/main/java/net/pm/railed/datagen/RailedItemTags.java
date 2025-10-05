package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedItemTags extends FabricTagProvider.ItemTagProvider{
    public RailedItemTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(ItemTags.RAILS)
                .add(Registries.BLOCK.getId(Blocks.SELF_POWERED_RAIL));
    }
}
