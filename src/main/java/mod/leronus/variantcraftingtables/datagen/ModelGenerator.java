package mod.leronus.variantcraftingtables.datagen;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;
import mod.leronus.variantcraftingtables.util.ModTextureMap;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    // Used for those mods that cant follow a standard _planks naming convention or those that don't load via gradle.
    public static void registerCube(BlockStateModelGenerator blockStateModelGenerator, Block block, String string, BiFunction<Block, String, TextureMap> texturesFactory) {
        TextureMap textureMap = texturesFactory.apply(block, string);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, Models.CUBE.upload(block, textureMap, blockStateModelGenerator.modelCollector)));
    }

    // Allows to loop through the blocks in each class and extract the block name without using registry
    public static void registerModel(BlockStateModelGenerator blockStateModelGenerator, Map<Identifier, Block> blockMap, String modId, Function<String, String> modelPathGenerator) {
        for (Block table : blockMap.values()) {
            String blockName = table.getTranslationKey();
            int firstUnderscoreIndex = blockName.indexOf('_');
            if (firstUnderscoreIndex != -1) {
                String plankName = blockName.substring(firstUnderscoreIndex + 1, blockName.lastIndexOf("_crafting_table"));
                String modelPath = modId + ":block/" + modelPathGenerator.apply(plankName);
                registerCube(blockStateModelGenerator, table, modelPath, ModTextureMap::craftingTable);
            } else {
                System.out.println("Invalid block name format: " + blockName);
            }
        }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.ACACIA_CRAFTING_TABLE, Blocks.ACACIA_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.BAMBOO_CRAFTING_TABLE, Blocks.BAMBOO_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.BIRCH_CRAFTING_TABLE, Blocks.BIRCH_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.CHERRY_CRAFTING_TABLE, Blocks.CHERRY_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.CRIMSON_CRAFTING_TABLE, Blocks.CRIMSON_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.DARK_OAK_CRAFTING_TABLE, Blocks.DARK_OAK_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.JUNGLE_CRAFTING_TABLE, Blocks.JUNGLE_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.MANGROVE_CRAFTING_TABLE, Blocks.MANGROVE_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.SPRUCE_CRAFTING_TABLE, Blocks.SPRUCE_PLANKS, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerCubeWithCustomTextures(Vanilla.WARPED_CRAFTING_TABLE, Blocks.WARPED_PLANKS, TextureMap::frontSideWithCustomBottom);

        registerModel(blockStateModelGenerator, BiomesOPlenty.BOP_TABLES, "biomesoplenty", plankName -> plankName + "_planks");
        registerModel(blockStateModelGenerator, Ecologics.ECO_TABLES, "ecologics", plankName -> plankName + "_planks");
//        registerModel(blockStateModelGenerator, RegionsUnexplored.RU_TABLES, "regions_unexplored", plankName -> plankName + "_planks");
        registerModel(blockStateModelGenerator, VanillaBackport.VB_TABLES, "vanillabackport", plankName -> plankName + "_planks");
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}