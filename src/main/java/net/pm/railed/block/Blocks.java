package net.pm.railed.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.pm.railed.Railed;

import java.util.function.Function;

public class Blocks {
    public static final Block SELF_POWERED_RAIL = register("self_powered_rail", SelfPoweredRailBlock::new, BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.POWERED_RAIL));

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        //block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(properties.setId(blockKey));

        //block's item
        ResourceKey<Item> itemKey = keyOfItem(name);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Railed.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Railed.MOD_ID, name));
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(content -> {
            content.accept(SELF_POWERED_RAIL.asItem());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            content.accept(SELF_POWERED_RAIL.asItem());
        });
    }
}
