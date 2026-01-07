package mod.leronus.variantcraftingtables;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;
import mod.leronus.variantcraftingtables.util.ModCreativeTab;
import mod.leronus.variantcraftingtables.util.ModRegistries;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "variantcraftingtables";

    public static void ifModLoaded(String modId, Runnable runnable) {
        if (FabricLoader.getInstance().isModLoaded(modId)) {
            runnable.run();
        }
    }

    @Override
    public void onInitialize() {

        Vanilla.registerTables();

        ifModLoaded("biomesoplenty", BiomesOPlenty::registerTables);
        ifModLoaded("ecologics", Ecologics::registerTables);
        ifModLoaded("vanillabackport", VanillaBackport::registerTables);

        ModRegistries.registerFuelandFlammable();
        ModCreativeTab.registerItemGroup();
    }
}