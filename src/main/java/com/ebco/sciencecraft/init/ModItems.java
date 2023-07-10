package com.ebco.sciencecraft.init;

import com.ebco.sciencecraft.items.BasicItem;
import com.ebco.sciencecraft.*;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
	
	static Item magnesium_oxide;
	static Item magnesium_ingot;
	
	public static void init() {
		magnesium_oxide = new BasicItem("magnesium_oxide").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(64);
		magnesium_ingot = new BasicItem("magnesium_ingot").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(64);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(magnesium_oxide, magnesium_ingot);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(magnesium_oxide);
		registerRender(magnesium_ingot);
		
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
