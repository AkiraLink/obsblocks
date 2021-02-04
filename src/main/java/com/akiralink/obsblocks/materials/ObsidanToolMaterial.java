package com.akiralink.obsblocks.materials;

import com.akiralink.obsblocks.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ObsidanToolMaterial implements ToolMaterial {

    public static final ObsidanToolMaterial OBSIDAN_TOOL_MATERIAL = new ObsidanToolMaterial();

    @Override
    public int getDurability() {
        return 3000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.OBSIDIAN_RUNE_PIECE);
    }
}
