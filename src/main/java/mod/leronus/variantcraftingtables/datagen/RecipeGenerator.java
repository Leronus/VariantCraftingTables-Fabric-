package mod.leronus.variantcraftingtables.datagen;

import mod.leronus.variantcraftingtables.block.compatability.BiomesOPlenty;
import mod.leronus.variantcraftingtables.block.compatability.Ecologics;
import mod.leronus.variantcraftingtables.block.compatability.VanillaBackport;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import mod.leronus.variantcraftingtables.block.Vanilla;
import mod.leronus.variantcraftingtables.block.compatability.*;
import mod.leronus.variantcraftingtables.util.ModItemTags;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {


    public RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void offerCraftingTableRecipe(RecipeExporter exporter, ItemConvertible table, ItemConvertible planks) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, table)
                .input('#', planks)
                .pattern("##").pattern("##")
                .criterion("has_planks", VanillaRecipeProvider.conditionsFromItem(planks))
                .offerTo(exporter);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerCraftingTableRecipe(exporter, Vanilla.ACACIA_CRAFTING_TABLE, Items.ACACIA_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.BAMBOO_CRAFTING_TABLE, Items.BAMBOO_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.BIRCH_CRAFTING_TABLE, Items.BIRCH_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.CHERRY_CRAFTING_TABLE, Items.CHERRY_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.DARK_OAK_CRAFTING_TABLE, Items.DARK_OAK_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.JUNGLE_CRAFTING_TABLE, Items.JUNGLE_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.MANGROVE_CRAFTING_TABLE, Items.MANGROVE_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.SPRUCE_CRAFTING_TABLE, Items.SPRUCE_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.CRIMSON_CRAFTING_TABLE, Items.CRIMSON_PLANKS);
        offerCraftingTableRecipe(exporter, Vanilla.WARPED_CRAFTING_TABLE, Items.WARPED_PLANKS);

        registerCraftingTableRecipe(exporter, BiomesOPlenty.BOP_TABLES, "biomesoplenty");
        registerCraftingTableRecipe(exporter, Ecologics.ECO_TABLES, "ecologics");
        registerCraftingTableRecipe(exporter, VanillaBackport.VB_TABLES, "vanillabackport");

        // Uncrafting recipe
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CRAFTING_TABLE)
                .input(ModItemTags.CRAFTING_TABLES)
                .criterion("has_crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .offerTo(exporter, Identifier.of("variantcraftingtables", "crafting_table"));
    }

    public void registerCraftingTableRecipe(RecipeExporter exporter, Map<Identifier, Block> tables, String modId) {
        registerCraftingTableRecipe(exporter, tables, modId, "_planks");
    }

    public void registerCraftingTableRecipe(RecipeExporter exporter,
                                            Map<Identifier, Block> tables,
                                            String modId,
                                            String plankSuffix) {

        for (var entry : tables.entrySet()) {
            Identifier tableId = entry.getKey();
            Block table = entry.getValue();

            // Whatever your naming rule is, compute `name`…
            String path = tableId.getPath();
            String name = path
                    .replace("_crafting_table", "")
                    .replaceFirst("^[^_]+_", ""); // keep/change this rule as needed

            String plankNamespace =
                    modId.equals("vanillabackport") ? "minecraft" : modId;

            Identifier plankId = Identifier.of(plankNamespace, name + plankSuffix);


            // ✅ Skip if the plank item doesn't exist
            if (!Registries.ITEM.containsId(plankId)) {
                System.out.println("[VCT] Skipping " + tableId + " — missing planks: " + plankId);
                continue;
            }

            ItemConvertible planks = Registries.ITEM.get(plankId);

            // ✅ Build recipe with a real criterion and explicit id
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, table)
                    .input('#', planks)
                    .pattern("##")
                    .pattern("##")
                    .criterion("has_planks", VanillaRecipeProvider.conditionsFromItem(planks))
                    .offerTo(exporter, Identifier.of("variantcraftingtables", tableId.getPath()));
        }
    }
}