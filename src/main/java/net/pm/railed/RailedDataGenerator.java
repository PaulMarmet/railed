package net.pm.railed;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.pm.railed.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class RailedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagGenerator::new);
		pack.addProvider(LangGenerator::new);
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(RecipeGenerator::new);
	}

	private static class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
		public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
			getOrCreateTagBuilder(BlockTags.RAILS)
					.add(Blocks.SELF_POWERED_RAIL)
					.setReplace(false);
		}
	}

	private static class LangGenerator extends FabricLanguageProvider {
		protected LangGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
			super(dataOutput, "en_us", registryLookup);
		}

		@Override
		public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
			translationBuilder.add(Blocks.SELF_POWERED_RAIL, "Self-Powered Rail");
		}
	}

	private static class ModelGenerator extends FabricModelProvider {
		public ModelGenerator(FabricDataOutput output) {
			super(output);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			blockStateModelGenerator.registerStraightRail(Blocks.SELF_POWERED_RAIL);
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {

		}
	}

	private static class RecipeGenerator extends FabricRecipeProvider {
		public RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		public void generate(RecipeExporter exporter) {
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SELF_POWERED_RAIL)
					.pattern("#")
					.pattern("X")
					.pattern("R")
					.input('#', Items.GOLD_INGOT)
					.input('X', Items.POWERED_RAIL)
					.input('R', Items.REDSTONE_TORCH)
					.criterion(FabricRecipeProvider.hasItem(Items.POWERED_RAIL), FabricRecipeProvider.conditionsFromItem(Items.POWERED_RAIL))
					.offerTo(exporter);
		}
	}
}
