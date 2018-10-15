package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSided extends BlockBase {

	public BlockSided() {
		super("sided_block", Material.CLAY);
		this.setCreativeTab(CreativeTabs.MISC);
	}

	  // used by the renderer to control the render layer.
	  @SideOnly(Side.CLIENT)
	  public BlockRenderLayer getBlockLayer()
	  {
	    return BlockRenderLayer.CUTOUT;
	  }
	  
	  // used by the renderer to control lighting and visibility of other blocks.
	  @Override
	  public boolean isOpaqueCube(IBlockState iBlockState) {
		  return false;
	  }
	
	
}
