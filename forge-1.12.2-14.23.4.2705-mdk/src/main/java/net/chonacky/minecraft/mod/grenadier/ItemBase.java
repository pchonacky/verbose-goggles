package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String name) {
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		ModItems.ITEMS.add(this);
	}

}
