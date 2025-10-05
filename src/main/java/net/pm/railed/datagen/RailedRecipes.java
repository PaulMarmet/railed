package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.pm.railed.Railed;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedRecipes extends FabricRecipeProvider {
    public RailedRecipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, Blocks.SELF_POWERED_RAIL)
                        .pattern("#")
                        .pattern("X")
                        .pattern("R")
                        .input('#', Items.GOLD_INGOT)
                        .input('X', Items.POWERED_RAIL)
                        .input('R', Items.REDSTONE_TORCH)
                        .criterion(hasItem(Items.POWERED_RAIL), conditionsFromItem(Items.POWERED_RAIL))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return Railed.MOD_ID;
    }
}
