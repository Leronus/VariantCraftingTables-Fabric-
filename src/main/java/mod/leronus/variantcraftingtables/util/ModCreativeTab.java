package mod.leronus.variantcraftingtables.util;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import mod.leronus.variantcraftingtables.Initialise;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;

public class ModCreativeTab {

    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Initialise.MOD_ID, "variantcraftingtables"),

            FabricItemGroup.builder()
                    .displayName(Text.literal("Variant Crafting Tables"))
                    .icon(() -> new ItemStack(Vanilla.MANGROVE_CRAFTING_TABLE))
                    .entries((context, entries) -> {

                        entries.add(Vanilla.ACACIA_CRAFTING_TABLE);
                        entries.add(Vanilla.BAMBOO_CRAFTING_TABLE);
                        entries.add(Vanilla.BIRCH_CRAFTING_TABLE);
                        entries.add(Vanilla.CHERRY_CRAFTING_TABLE);
                        entries.add(Vanilla.CRIMSON_CRAFTING_TABLE);
                        entries.add(Vanilla.DARK_OAK_CRAFTING_TABLE);
                        entries.add(Vanilla.JUNGLE_CRAFTING_TABLE);
                        entries.add(Vanilla.MANGROVE_CRAFTING_TABLE);
                        entries.add(Blocks.CRAFTING_TABLE); // Oak
                        entries.add(Vanilla.SPRUCE_CRAFTING_TABLE);
                        entries.add(Vanilla.WARPED_CRAFTING_TABLE);

                        if (FabricLoader.getInstance().isModLoaded("biomesoplenty")) {
                            entries.add(BiomesOPlenty.BOP_DEAD_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_FIR_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_HELLBARK_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_JACARANDA_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_MAGIC_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_MAHOGANY_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_PALM_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_REDWOOD_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_UMBRAN_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_WILLOW_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_EMPYREAL_CRAFTING_TABLE);
                            entries.add(BiomesOPlenty.BOP_MAPLE_CRAFTING_TABLE);
                        }

                        if (FabricLoader.getInstance().isModLoaded("ecologics")) {
                            entries.add(Ecologics.ECO_AZALEA_CRAFTING_TABLE);
                            entries.add(Ecologics.ECO_COCONUT_CRAFTING_TABLE);
                            entries.add(Ecologics.ECO_FLOWERING_AZALEA_CRAFTING_TABLE);
                            entries.add(Ecologics.ECO_WALLNUT_CRAFTING_TABLE);
                        }
                        if (FabricLoader.getInstance().isModLoaded("vanillabackport")) {
                            entries.add(VanillaBackport.PALE_OAK_CRAFTING_TABLE);
                        }
                    })
                    .texture(Identifier.ofVanilla("textures/gui/container/creative_inventory/tab_variantcraftingtables.png")).noRenderedName().build());

    public static void registerItemGroup() {
    }
}