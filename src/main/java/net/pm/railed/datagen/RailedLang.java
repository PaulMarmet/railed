package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedLang extends FabricLanguageProvider {
    public RailedLang(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(dataOutput, "en_us", registriesFuture);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        addBlockWithItem(translationBuilder, Blocks.SELF_POWERED_RAIL, "Self-Powered Rail");
    }

    public void addBlockWithItem(TranslationBuilder translationBuilder, Block block, String name) {
        translationBuilder.add(block, name);
        translationBuilder.add(block.asItem(), name);
    }
}
