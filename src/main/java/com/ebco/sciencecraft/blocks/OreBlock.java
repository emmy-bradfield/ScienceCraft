package com.ebco.sciencecraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class OreBlock extends BasicBlock{
	
	Item itemDropped;
	Integer minDropAmount = 1;
	Integer maxDropAmount = 0;

	public OreBlock(String name, Material material) {
		this(name, material, null, 1, 1);
	}
	
	public OreBlock(String name, Material material, Item itemDropped) {
		this(name, material, itemDropped, 1, 1);
	}
	
	public OreBlock(String name, Material material, Item itemDropped, Integer dropAmount) {
		this(name, material, itemDropped, dropAmount, dropAmount);
	}
	
	public OreBlock(String name, Material material, Item itemDropped, int minDropAmount, int maxDropAmount) {
		super(name,material);
		this.itemDropped = itemDropped;
		this.minDropAmount = minDropAmount;
		this.maxDropAmount = maxDropAmount;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return itemDropped==null?Item.getItemFromBlock(this):itemDropped;
	}
	
	@Override
	public int quantityDropped(Random random)
    {
		if(this.minDropAmount>this.maxDropAmount) {
			int i = this.minDropAmount;
			this.minDropAmount=this.maxDropAmount;
			this.maxDropAmount=i;
		}
		return this.minDropAmount + random.nextInt(this.maxDropAmount - this.minDropAmount + 1);
    }
	
	@Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

}
