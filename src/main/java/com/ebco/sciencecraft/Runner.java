package com.ebco.sciencecraft;

import com.ebco.sciencecraft.init.ModBlocks;
import com.ebco.sciencecraft.init.ModItems;
import com.ebco.sciencecraft.init.ModRecipes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + ":postInit");
	}
	
}
