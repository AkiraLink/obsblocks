package com.akiralink.obsblocks.registry;

import com.akiralink.obsblocks.ModFood;
import com.akiralink.obsblocks.Obsblocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Items
    public static final Item OBSIDIAN_HEART = new Item(new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP));
    public static final Item OBSIDIAN_HEART_PIECE = new Item(new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP));
    public static final Item OBSIDIAN_RUNE_DUST = new Item(new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP));
    public static final Item OBSIDIAN_RUNE_PIECE = new Item(new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP));
    public static final Item OBSIDIAN_NUGGET = new Item(new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP));
    public static final Item OBSIDIAN_APPLE = new Item(new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP).food(ModFood.OBSIDIAN_APPLE));
    public static final Item OBSIDIAN_RUNE_APPLE = new Item(new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP).food(ModFood.OBSIDIAN_RUNE_APPLE));

    //Block Items

    public static final BlockItem OBSIDIAN_RUNE_PILLAR = new BlockItem(ModBlocks.OBSIDIAN_RUNE_PILLAR,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    public static final BlockItem OBSIDIAN_RUNE_ENERGY_BLOCK = new BlockItem(ModBlocks.OBSIDIAN_RUNE_ENERGY_BLOCK,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    public static final BlockItem OBSIDIAN_RUNE_ORE = new BlockItem(ModBlocks.OBSIDIAN_RUNE_ORE,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    public static final BlockItem OBSIDIAN_SLAB = new BlockItem(ModBlocks.OBSIDIAN_SLAB,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    public static final BlockItem OBSIDIAN_STAIRS = new BlockItem(ModBlocks.OBSIDIAN_STAIRS,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    public static final BlockItem OBSIDIAN_RUNE_HEARTBLOCK = new BlockItem(ModBlocks.OBSIDIAN_RUNE_HEARTBLOCK,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    public static final BlockItem OBSIDIAN_BRICK = new BlockItem(ModBlocks.OBSIDIAN_BRICK,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    public static final BlockItem OBSIDIAN_CHISELED_BRICK = new BlockItem(ModBlocks.OBSIDIAN_CHISELED_BRICK,new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP ));
    //Register Method
    public static void registerItems() {

        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_brick"), OBSIDIAN_BRICK);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_chiseled_brick"), OBSIDIAN_CHISELED_BRICK);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_energy_block"), OBSIDIAN_RUNE_ENERGY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_heartblock"), OBSIDIAN_RUNE_HEARTBLOCK);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_stairs"), OBSIDIAN_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_slab"), OBSIDIAN_SLAB);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_heart"), OBSIDIAN_HEART);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_heart_piece"), OBSIDIAN_HEART_PIECE);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_piece"), OBSIDIAN_RUNE_PIECE);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_pillar"), OBSIDIAN_RUNE_PILLAR);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_dust"), OBSIDIAN_RUNE_DUST);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_nugget"), OBSIDIAN_NUGGET);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_ore"), OBSIDIAN_RUNE_ORE);
        Registry.register(Registry.ITEM, new Identifier(Obsblocks.MOD_ID, "obsidian_rune_heartblock_old"), new BlockItem(ModBlocks.OBSIDIAN_RUNE_HEARTBLOCK_OLD, new Item.Settings().group(Obsblocks.OBSBLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("obsblocks","obsidian_apple"), OBSIDIAN_APPLE);
        Registry.register(Registry.ITEM, new Identifier("obsblocks","obsidian_rune_apple"), OBSIDIAN_RUNE_APPLE);


    }
}
