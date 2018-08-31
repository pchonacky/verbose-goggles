package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestItem extends Item {

	public TestItem() {
		// TODO Auto-generated constructor stub
		setRegistryName("test_item");
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(16);
	}

}
