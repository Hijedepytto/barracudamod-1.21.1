package net.infugogr.barracudamod.item;

import net.infugogr.barracudamod.BarracudaMod;
import net.infugogr.barracudamod.item.custom.Tormented_Soul;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item AQUATIC_DUST = registerItem("aquatic_dust", new Item(new Item.Settings()));
    public static final Item SEA_MINERAL = registerItem("sea_mineral", new Item(new Item.Settings()));
    public static final Item SEA_INGOT = registerItem("sea_ingot", new Item(new Item.Settings()));
    public static final Item CURSED_GOLD_INGOT = registerItem("cursed_gold_ingot", new Item(new Item.Settings()));
    public static final Item TORMENTED_SOUL = registerItem("tormented_soul", new Tormented_Soul(new Item.Settings().maxCount(16)));
    public static final Item REDSTONEIUM_INGOT = registerItem("redstoneium_ingot", new Item(new Item.Settings()));
    public static final Item CHARGED_REDSTONEIUM_INGOT = registerItem("charged_redstoneium_ingot", new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BarracudaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BarracudaMod.LOGGER.info("Registering Mod Items for " + BarracudaMod.MOD_ID);
        };
    }

