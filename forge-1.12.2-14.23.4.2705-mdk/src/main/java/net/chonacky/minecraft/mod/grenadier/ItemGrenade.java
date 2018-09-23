package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemGrenade extends Item implements IHas1Model {
	private static 	String name = "grenade";

	public ItemGrenade() {
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
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand handIn) {
//		if (!player.capabilities.isCreativeMode) { stack.setCount(stack.getCount()-1);   }

//		System.out.println(">>>>>>>>>ResourceLocation : " + this.getModelResourceLocation().toString());
		

		// IMPORTANT! Only spawn new entities on the server. If the world is not remote,
		// that means you are on the server:
		if (!world.isRemote) {
			world.spawnEntity(new EntityGrenade(world, player)); }
		return super.onItemRightClick(world, player, handIn);
	}




	@Override
	public void registerModel() {
		Grenadier.proxy.registerModel(this,0,"inventory");
		
	}

}
