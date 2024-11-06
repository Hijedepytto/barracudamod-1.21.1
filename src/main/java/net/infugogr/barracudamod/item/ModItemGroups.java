package net.infugogr.barracudamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.infugogr.barracudamod.BarracudaMod;
import net.infugogr.barracudamod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup BARRACUDA_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BarracudaMod.MOD_ID, "barracuda_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SEA_MINERAL))
                    .displayName(Text.translatable("itemgroup.barracudamod.barracuda_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.AQUATIC_DUST);
                        entries.add(ModItems.SEA_MINERAL);
                        entries.add(ModItems.SEA_INGOT);
                        entries.add(ModBlocks.MINERAL_BLOCK);
                        entries.add(ModBlocks.AQUATIC_SAND);
                        entries.add(ModBlocks.MINERAL_CLUSTER);
                        entries.add(ModItems.CURSED_GOLD_INGOT);
                        entries.add(ModBlocks.CURSED_GOLD_BLOCK);
                        entries.add(ModItems.TORMENTED_SOUL);
                        entries.add(ModItems.REDSTONEIUM_INGOT);
                        entries.add(ModBlocks.REDSTONEIUM_BLOCK);
                        entries.add(ModItems.CHARGED_REDSTONEIUM_INGOT);
                        entries.add(ModBlocks.CHARGED_REDSTONEIUM_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        BarracudaMod.LOGGER.info("Registering Item Groups for " + BarracudaMod.MOD_ID);
    }
}
