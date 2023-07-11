package com.ebco.sciencecraft;

import com.ebco.sciencecraft.gen.OreGen;
import com.ebco.sciencecraft.init.ModBlocks;
import com.ebco.sciencecraft.init.ModItems;
import com.ebco.sciencecraft.init.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MODID, name=Reference.MODNAME, version=Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class Runner {
	
	@Instance
	public static Runner instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.MODID + ":preInit");
		ModItems.init();
		ModBlocks.init();

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(Reference.MODID + ":init");
		
		ModRecipes.init();
		GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.magnesium_ore, 8, 10, 50, 10), 0);
		GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.graphite_ore, 10, 30, 90, 15), 0);

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + ":postInit");
	}
	
}
