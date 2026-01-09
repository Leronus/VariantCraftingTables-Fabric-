package mod.leronus.variantcraftingtables.datagen;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import mod.leronus.variantcraftingtables.Initialise;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.registry.tag.BlockTags.AXE_MINEABLE;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public static final TagKey<Block> CRAFTING_TABLES = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(Initialise.MOD_ID, "crafting_tables"));
    private static final TagKey<Block> C_WORKBENCH = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("c:workbench"));

    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        registerTags(Vanilla.VANILLA_CRAFTING_TABLES);

        registerTags(BiomesOPlenty.BOP_TABLES);
        registerTags(Ecologics.ECO_TABLES);
        registerTags(VanillaBackport.VB_TABLES);

        getOrCreateTagBuilder(AXE_MINEABLE)
                .forceAddTag(CRAFTING_TABLES);

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