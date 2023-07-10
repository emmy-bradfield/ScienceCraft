package com.ebco.sciencecraft.init;

import com.ebco.sciencecraft.*;
import com.ebco.sciencecraft.blocks.BasicBlock;
import com.ebco.sciencecraft.blocks.OreBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {

	public static Block magnesium_block;
	public static Block magnesium_ore;
	
	public static void init() {
		magnesium_block = new BasicBlock("magnesium_block", Material.IRON).setHardness(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setLightLevel(0f);
		magnesium_ore = new OreBlock("magnesium_ore", Material.ROCK, ModItems.magnesium_ingot , 1, 3).setHardness(3f).setResistance(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		magnesium_ore.setHarvestLevel("pickaxe", 2);
		
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(magnesium_ore, magnesium_block);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(magnesium_ore).setRegistryName(magnesium_ore.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(magnesium_block).setRegistryName(magnesium_block.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(magnesium_ore));
		registerRender(Item.getItemFromBlock(magnesium_block));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		
	}
}