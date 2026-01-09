package mod.leronus.variantcraftingtables.block.compatability;

import com.google.common.collect.Maps;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import mod.leronus.variantcraftingtables.Initialise;

import java.util.Map;

public class BiomesOPlenty {

    public static Map<Identifier, Block> BOP_TABLES = Maps.newHashMap();

    public static Block BOP_DEAD_CRAFTING_TABLE;
    public static Block BOP_FIR_CRAFTING_TABLE;
    public static Block BOP_HELLBARK_CRAFTING_TABLE;
    public static Block BOP_JACARANDA_CRAFTING_TABLE;
    public static Block BOP_MAGIC_CRAFTING_TABLE;
    public static Block BOP_MAHOGANY_CRAFTING_TABLE;
    public static Block BOP_PALM_CRAFTING_TABLE;
    public static Block BOP_REDWOOD_CRAFTING_TABLE;
    public static Block BOP_UMBRAN_CRAFTING_TABLE;
    public static Block BOP_WILLOW_CRAFTING_TABLE;
    public static Block BOP_EMPYREAL_CRAFTING_TABLE;
    public static Block BOP_MAPLE_CRAFTING_TABLE;

    public static void registerTables() {
        BOP_DEAD_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_dead_crafting_table");
        BOP_FIR_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_fir_crafting_table");
        BOP_HELLBARK_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_hellbark_crafting_table");
        BOP_JACARANDA_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_jacaranda_crafting_table");
        BOP_MAGIC_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_magic_crafting_table");
        BOP_MAHOGANY_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_mahogany_crafting_table");
        BOP_PALM_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_palm_crafting_table");
        BOP_REDWOOD_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_redwood_crafting_table");
        BOP_UMBRAN_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_umbran_crafting_table");
        BOP_WILLOW_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_willow_crafting_table");
        BOP_EMPYREAL_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_empyreal_crafting_table");
        BOP_MAPLE_CRAFTING_TABLE = registerCraftingTable("biomesoplenty_maple_crafting_table");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = Identifier.of(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        BOP_TABLES.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new Item.Settings()));
        return block;
    }

    public static Block registerCraftingTable(String name) {
        return register(name, new CraftingTableBlock(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)));
    }
}