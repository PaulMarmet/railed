package net.pm.railed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.pm.railed.block.Blocks;

@Environment(EnvType.CLIENT)
public class RailedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(Blocks.SELF_POWERED_RAIL, BlockRenderLayer.CUTOUT);
    }
}
