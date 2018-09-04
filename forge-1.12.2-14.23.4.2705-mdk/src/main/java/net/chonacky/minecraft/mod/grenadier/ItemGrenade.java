package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenade extends Item {

	public ItemGrenade() {
		// TODO Auto-generated constructor stub
		this.setRegistryName("itemGrenade");
		this.setUnlocalizedName("Grenade");
		//need to register a resource name instead
//		this.setTextureName(Grenadier.MODID+":grenade");
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setMaxStackSize(18);
		
	}
	
	/**
	* Called whenever this item is equipped and the right mouse button is pressed.
	* @param: itemStack, world, entityPlayer
	*/
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) { stack.setCount(stack.getCount()-1);   }


		// IMPORTANT! Only spawn new entities on the server. If the world is not remote,
		// that means you are on the server:
		if (!world.isRemote) {
			world.spawnEntity(new EntityGrenade(world, player)); }

		return stack;
	}

}
