package net.chonacky.minecraft.mod.grenadier;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemGrenade extends ItemBase {

	public ItemGrenade() {
		super("grenade");
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setMaxStackSize(18);
	}
	
	/**
	* Called whenever this item is equipped and the right mouse button is pressed.
	* @param: itemStack, world, entityPlayer
	*/
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand handIn) {
		if (!world.isRemote) { world.spawnEntity(new EntityGrenade(world, player)); }
		return super.onItemRightClick(world, player, handIn);
	}



}
