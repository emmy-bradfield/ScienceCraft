package com.ebco.sciencecraft.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EntityBlock extends BasicBlock implements ITileEntityProvider{

	public EntityBlock(String name, Material material) {
		super(name, material);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}

}
