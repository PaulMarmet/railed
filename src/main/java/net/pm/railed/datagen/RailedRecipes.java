package net.pm.railed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.pm.railed.Railed;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedRecipes extends FabricRecipeProvider {
    public RailedRecipes(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public String getName() {
        return Railed.MOD_ID;
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.MISC, Blocks.SELF_POWERED_RAIL)
                        .pattern("#")
                        .pattern("X")
                        .pattern("R")
                        .define('#', Items.GOLD_INGOT)
                        .define('X', Items.POWERED_RAIL)
                        .define('R', Items.REDSTONE_TORCH)
                        .unlockedBy(getHasName(Items.POWERED_RAIL), has(Items.POWERED_RAIL))
                        .save(output);
            }
        };
    }
}
