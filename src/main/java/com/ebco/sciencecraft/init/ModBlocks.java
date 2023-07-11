package com.ebco.sciencecraft.init;

import com.ebco.sciencecraft.*;
import com.ebco.sciencecraft.blocks.BasicBlock;
import com.ebco.sciencecraft.blocks.OreBlock;
import com.ebco.sciencecraft.blocks.EntityBlock;
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
	public static Block enhanced_furnace;
	public static Block enhanced_stone;
	public static Block graphite_ore;
	
	public static void init() {
		magnesium_block = new BasicBlock("magnesium_block", Material.IRON).setHardness(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setLightLevel(0f);
		
		magnesium_ore = new OreBlock("magnesium_ore", Material.ROCK, ModItems.magnesium_ingot , 1, 3).setHardness(3f).setResistance(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		magnesium_ore.setHarvestLevel("pickaxe", 2);
		
		graphite_ore = new OreBlock("graphite_ore", Material.ROCK, ModItems.graphite_crystal, 1, 2).setHardness(3f).setResistance(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		graphite_ore.setHarvestLevel("pickaxe", 2);
		
		enhanced_stone = new BasicBlock("enhanced_stone", Material.ROCK).setHardness(5f).setCreativeTab(CreativeTabs.MISC).setLightLevel(0f);
		
		enhanced_furnace = new EntityBlock("enhanced_furnace", Material.ROCK);
		
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(magnesium_ore, magnesium_block, graphite_ore, enhanced_stone, enhanced_furnace);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(magnesium_ore).setRegistryName(magnesium_ore.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(magnesium_block).setRegistryName(magnesium_block.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(graphite_ore).setRegistryName(graphite_ore.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(enhanced_stone).setRegistryName(enhanced_stone.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(enhanced_furnace).setRegistryName(enhanced_furnace.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(magnesium_ore));
		registerRender(Item.getItemFromBlock(magnesium_block));
		registerRender(Item.getItemFromBlock(graphite_ore));
		registerRender(Item.getItemFromBlock(enhanced_stone));
		registerRender(Item.getItemFromBlock(enhanced_furnace));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		
	}
}