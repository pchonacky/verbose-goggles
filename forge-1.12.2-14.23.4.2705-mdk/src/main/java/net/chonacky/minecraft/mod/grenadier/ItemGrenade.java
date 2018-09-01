package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenade extends Item {

	public ItemGrenade() {
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("Grenade");
		this.setTextureName(Grenadier.MODID+":grenade");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(18);
		
	}
	
	/**
	* Called whenever this item is equipped and the right mouse button is pressed.
	* @param: itemStack, world, entityPlayer
	*/
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!player.capabilities.isCreativeMode) { --stack.stackSize; }

		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		// IMPORTANT! Only spawn new entities on the server. If the world is not remote,
		// that means you are on the server:
		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityGrenade(world, player)); }

		return stack;
	}

}
