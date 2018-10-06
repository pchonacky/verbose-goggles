package net.chonacky.minecraft.mod.grenadier;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
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

	/* (non-Javadoc)
	 * @see net.minecraft.item.Item#onItemUse(net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.util.EnumHand, net.minecraft.util.EnumFacing, float, float, float)
	 */
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
//		if (!world.isRemote) { world.spawnEntity(new EntityGrenade(world, player)); }
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}



}
