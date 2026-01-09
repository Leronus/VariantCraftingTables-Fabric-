package mod.leronus.variantcraftingtables.datagen;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static mod.leronus.variantcraftingtables.util.ModItemTags.CRAFTING_TABLES;


public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {

    private static final TagKey<Item> C_WORKBENCH = TagKey.of(Registries.ITEM.getKey(), Identifier.of("c:workbench"));

    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        registerTags(Vanilla.VANILLA_CRAFTING_TABLES);
        registerTags(BiomesOPlenty.BOP_TABLES);
        registerTags(Ecologics.ECO_TABLES);
        registerTags(VanillaBackport.VB_TABLES);

        getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
                .add(Vanilla.CRIMSON_CRAFTING_TABLE.asItem())
                .add(Vanilla.WARPED_CRAFTING_TABLE.asItem())
//                .addOptional(Identifier.of("variantcraftingtables:ru_brimwood_crafting_table"))
//                .addOptional(Identifier.of("variantcraftingtables:ru_cobalt_crafting_table"))
//                .addOptional(Identifier.of("variantcraftingtables:ru_dead_crafting_table"))
//                .addOptional(Identifier.of("variantcraftingtables:ru_yellow_bioshroom_crafting_table"))
        ;

        getOrCreateTagBuilder(C_WORKBENCH)
                .forceAddTag(CRAFTING_TABLES);
    }

    private void registerTags(Map<Identifier, Block> blockMap) {
        for (Block block : blockMap.values()) {
            Identifier lootTableId = block.getLootTableKey().getValue();
            String newPath = lootTableId.getPath().replaceFirst("blocks/", "");
            Identifier modifiedId = Identifier.of(lootTableId.getNamespace(), newPath);

            getOrCreateTagBuilder(CRAFTING_TABLES)
                    .addOptional(modifiedId);
        }
    }
}