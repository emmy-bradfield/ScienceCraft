package com.ebco.sciencecraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModItems.magnesium_ingot, new ItemStack(ModItems.magnesium_oxide, 2), 1.5f);
	}
}
