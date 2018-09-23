package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemMyFireball extends Item implements IHas1Model {
	private static 	String name = "myfireball";
	
	public ItemMyFireball() {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setMaxStackSize(18);
	}
	
	
	
	/**
	* Called whenever this item is equipped and the right mouse button is pressed.
	* @param: itemStack, world, entityPlayer
	*/
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
	
		if (!world.isRemote) {
			world.spawnEntity(new EntityMyFireball(world, player, 0, 0, 0)); }
		
		return super.onItemRightClick(world, player, handIn);
	}

	@Override
	public void registerModel() {
		Grenadier.proxy.registerModel(this,0,"inventory");
		
	}
	
}
