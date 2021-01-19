package com.akiralink.obsblocks;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFood {

    public static final FoodComponent OBSIDIAN_APPLE = (new FoodComponent.Builder()).hunger(2).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 300, 0), 1).build(); //.snack used to make eating process short
    public static final FoodComponent OBSIDIAN_RUNE_APPLE = (new FoodComponent.Builder()).hunger(10).saturationModifier(3F).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 3), 1).build();

}
