package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemMyFireball extends Item {

	public ItemMyFireball() {
		this.setUnlocalizedName("MyFireball");
		this.setRegistryName(new ResourceLocation(Grenadier.MODID + ":fireball"));
		this.setCreativeTab(CreativeTabs.COMBAT);
		
		this.setMaxStackSize(18);
	}
	
	/**
	* Called whenever this item is equipped and the right mouse button is pressed.
	* @param: itemStack, world, entityPlayer
	*/
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		{ stack.setCount(stack.getCount()-1);   }

		//world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		// IMPORTANT! Only spawn new entities on the server. If the world is not remote,
		// that means you are on the server:
		if (!world.isRemote) {
			world.spawnEntity(new EntityMyFireball(world, player, 0, 0, 0)); }

		return stack;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#onItemRightClick(net.minecraft.world.World, net.minecraft.entity.player.EntityPlayer, net.minecraft.util.EnumHand)
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand handIn) {
	
		if (!world.isRemote) {
			world.spawnEntity(new EntityMyFireball(world, player, 0, 0, 0)); }
		
		return super.onItemRightClick(world, player, handIn);
	}

}
