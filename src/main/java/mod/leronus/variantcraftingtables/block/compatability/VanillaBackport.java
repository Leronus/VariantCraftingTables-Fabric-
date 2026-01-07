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

public class VanillaBackport {

    public static Map<Identifier, Block> VB_TABLES = Maps.newHashMap();

    public static Block PALE_OAK_CRAFTING_TABLE;

    public static void registerTables() {
        PALE_OAK_CRAFTING_TABLE = registerCraftingTable("vb_pale_oak_crafting_table");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = Identifier.of(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        VB_TABLES.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new Item.Settings()));
        return block;
    }

    public static Block registerCraftingTable(String name) {
        return register(name, new CraftingTableBlock(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)));
    }
}