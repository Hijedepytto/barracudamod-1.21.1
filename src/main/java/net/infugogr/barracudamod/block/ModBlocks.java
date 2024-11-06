package net.infugogr.barracudamod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.infugogr.barracudamod.BarracudaMod;
import net.infugogr.barracudamod.block.custom.Aquatic_Sand;
import net.infugogr.barracudamod.block.custom.Charged_Redstoneium_Block;
import net.infugogr.barracudamod.block.custom.Redstoneium_Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block AQUATIC_SAND = registerBlock("aquatic_sand",
            new Aquatic_Sand(AbstractBlock.Settings.create().strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.SAND)));

    public static final Block MINERAL_BLOCK = registerBlock("mineral_block",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block MINERAL_CLUSTER = registerBlock("mineral_cluster",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block CURSED_GOLD_BLOCK = registerBlock("cursed_gold_block",
            new Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block REDSTONEIUM_BLOCK = registerBlock("redstoneium_block",
            new Redstoneium_Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.METAL).ticksRandomly()));

    public static final Block CHARGED_REDSTONEIUM_BLOCK = registerBlock("charged_redstoneium_block",
            new Charged_Redstoneium_Block(AbstractBlock.Settings.create().strength(1.5F, 6.0F).luminance(state -> 15)
                    .requiresTool().sounds(BlockSoundGroup.METAL).ticksRandomly()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BarracudaMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BarracudaMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BarracudaMod.LOGGER.info("Registering Mod Blocks fot " + BarracudaMod.MOD_ID);
        };
    }

