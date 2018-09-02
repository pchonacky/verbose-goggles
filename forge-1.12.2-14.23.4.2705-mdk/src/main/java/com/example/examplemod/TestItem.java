package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class TestItem extends Item {

	public TestItem() {
		// TODO Auto-generated constructor stub
		setRegistryName("test_item");
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(16);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#onItemRightClick(net.minecraft.world.World, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumHand)
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		// TODO Auto-generated method stub
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
