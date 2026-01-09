package mod.leronus.variantcraftingtables.datagen;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    public LootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    private void registerLootTables(Map<Identifier, Block> blockMap, String modId) {
        for (Block block : blockMap.values()) {
            withConditions(ResourceConditions.allModsLoaded(modId)).addDrop(block);
        }
    }

    @Override
    public void generate() {

        for (Block block : Vanilla.VANILLA_CRAFTING_TABLES.values()) {
            addDrop(block);
        }
        registerLootTables(BiomesOPlenty.BOP_TABLES, "biomesoplenty");
        registerLootTables(Ecologics.ECO_TABLES, "ecologics");
//        registerSpecialLootTable(RegionsUnexplored.RU_TABLES, "regions_unexplored");
        registerLootTables(VanillaBackport.VB_TABLES, "vanillabackport");
    }

    public void registerSpecialLootTable(Map<Identifier, Block> tables, String modId) {
        for (Map.Entry<Identifier, Block> entry : tables.entrySet()) {
            Identifier tableId = entry.getKey();
            Block table = entry.getValue();
            String path = tableId.getPath();
            String name = path.replace("variantcraftingtables:", "").replace("_crafting_table", "").replaceFirst("^[^_]+_", "");
            withConditions(ResourceConditions.and(
                    ResourceConditions.allModsLoaded(modId),
                    ResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(modId + ":" + name + "_planks")))
            )).addDrop(table);
        }
    }
}