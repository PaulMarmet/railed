package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedLang extends FabricLanguageProvider {
    public RailedLang(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        addBlockWithItem(translationBuilder, Blocks.SELF_POWERED_RAIL, "Self-Powered Rail");
    }

    public void addBlockWithItem(TranslationBuilder translationBuilder, Block block, String name) {
        translationBuilder.add(block, name);
        translationBuilder.add(block.asItem(), name);
    }
}
