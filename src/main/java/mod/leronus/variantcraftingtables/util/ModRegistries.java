package mod.leronus.variantcraftingtables.util;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;

public class ModRegistries {

    public static void registerFuelandFlammable() {
        registerFuel();
    }

    private static void registerFuel() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(Vanilla.ACACIA_CRAFTING_TABLE, 300);
        registry.add(Vanilla.BAMBOO_CRAFTING_TABLE, 300);
        registry.add(Vanilla.BIRCH_CRAFTING_TABLE, 300);
        registry.add(Vanilla.CHERRY_CRAFTING_TABLE, 300);
        registry.add(Vanilla.DARK_OAK_CRAFTING_TABLE, 300);
        registry.add(Vanilla.JUNGLE_CRAFTING_TABLE, 300);
        registry.add(Vanilla.MANGROVE_CRAFTING_TABLE, 300);
        registry.add(Vanilla.SPRUCE_CRAFTING_TABLE, 300);

//        if (FabricLoader.getInstance().isModLoaded("blockus")) {
//            registry.add(Blockus.BLS_HERRINGBONE_ACACIA_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_BAMBOO_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_BIRCH_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_CHARRED_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_CHERRY_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_DARK_OAK_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_JUNGLE_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_MANGROVE_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_OAK_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_RAW_BAMBOO_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_SPRUCE_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_HERRINGBONE_WHITE_OAK_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_RAW_BAMBOO_CRAFTING_TABLE, 300);
//            registry.add(Blockus.BLS_WHITE_OAK_CRAFTING_TABLE, 300);
//        }
//        if (FabricLoader.getInstance().isModLoaded("cinderscapes")) {
//            for (Block block : Cinderscapes.CS_TABLES.values()) {
//                registry.add(block, 300);
//            }
//        }
//        if (FabricLoader.getInstance().isModLoaded("deeperdarker")) {
//            for (Block block : DeeperAndDarker.DAD_TABLES.values()) {
//                registry.add(block, 300);
//            }
//        }
//        if (FabricLoader.getInstance().isModLoaded("desolation")) {
//            registry.add(Desolation.DS_CHARRED_CRAFTING_TABLE, 300);
//        }
//        if (FabricLoader.getInstance().isModLoaded("natures_spirit")) {
//            for (Block block : NaturesSpirit.NS_TABLES.values()) {
//                registry.add(block, 300);
//            }
//        }
//        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
//            registry.add(TechReborn.TR_RUBBER_CRAFTING_TABLE, 300);
//        }
        if (FabricLoader.getInstance().isModLoaded("biomesoplenty")) {
            registry.add(BiomesOPlenty.BOP_CHERRY_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_DEAD_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_FIR_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_HELLBARK_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_JACARANDA_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_MAGIC_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_MAHOGANY_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_PALM_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_REDWOOD_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_UMBRAN_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_WILLOW_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_EMPYREAL_CRAFTING_TABLE, 300);
            registry.add(BiomesOPlenty.BOP_MAPLE_CRAFTING_TABLE, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("ecologics")) {
            registry.add(Ecologics.ECO_AZALEA_CRAFTING_TABLE, 300);
            registry.add(Ecologics.ECO_COCONUT_CRAFTING_TABLE, 300);
            registry.add(Ecologics.ECO_FLOWERING_AZALEA_CRAFTING_TABLE, 300);
            registry.add(Ecologics.ECO_WALLNUT_CRAFTING_TABLE, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("vanillabackport")) {
            registry.add(VanillaBackport.PALE_OAK_CRAFTING_TABLE, 300);
        }
    }
}