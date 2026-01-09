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

        if (FabricLoader.getInstance().isModLoaded("biomesoplenty")) {
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