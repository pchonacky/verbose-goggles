package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;


public class BlockBase extends Block {

//	//Default BlockStates:: can be modified by public setters
//	private BlockRenderLayer blockRenderLayer = BlockRenderLayer.SOLID;
//	private boolean opaque = true;
//	private boolean fullCube = true;
	
	
	public BlockBase(String name, Material materialIn) {
		super(materialIn);
		init(name);
	}

	public BlockBase(String name, Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
		init(name);
	}

	private void init(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		ModItems.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this)
				.setRegistryName(name));
		
	}

/*
 * The following overrides controls rendering options 
 * as configured, they all produce default results
 * Copy and modify as needed	
 */
	
	
//
//	  // used by the renderer to control the render layer.
//	  @SideOnly(Side.CLIENT)
//	  public BlockRenderLayer getBlockLayer()
//	  {
//	    return BlockRenderLayer.SOLID;
//	  }
//	  
//	  // used by the renderer to control lighting and visibility of other blocks.
//	  @Override
//	  public boolean isOpaqueCube(IBlockState iBlockState) {
//		  return true;
//	  }
//
//	  // used by the renderer to control lighting and visibility of other blocks, also by
//	  // (eg) wall or fence to control whether the fence joins itself to this block
//	  @Override
//	  public boolean isFullCube(IBlockState iBlockState) {
//	    return true;
//	  }

	  
	  
	  
	  
//	/**
//	 * @param blockRenderLayer sets the Block Render Layer
//	 * default = SOLID (farthest back)
//	 */
//	public void setBlockRenderLayer(BlockRenderLayer blockRenderLayer) {
//		this.blockRenderLayer = blockRenderLayer;
//	}
//
//	/**
//	 * @param opaque
//	 * 	default "TRUE" (block is opaque)
//	 */
//	public void setOpaque(boolean opaque) {
//		this.opaque = opaque;
//	}
//
//	/**
//	 * @param fullCube the fullCube to set
//	 * default "TRUE"
//	 */
//	public void setFullCube(boolean fullCube) {
//		this.fullCube = fullCube;
//	}


}


