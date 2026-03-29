package net.pm.railed.datagen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.pm.railed.block.Blocks;

@Environment(EnvType.CLIENT)
public class RailedModels extends FabricModelProvider {
    public RailedModels(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createActiveRail(Blocks.SELF_POWERED_RAIL);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
