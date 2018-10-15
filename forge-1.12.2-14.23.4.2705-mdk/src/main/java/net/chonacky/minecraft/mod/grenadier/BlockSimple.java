package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;



/*
 * This is a simple block that renders as a full cube
 */
public class BlockSimple extends BlockBase {

	public BlockSimple(String name, Material materialIn) {
		super(name, materialIn);
	}

	public BlockSimple(String name, Material blockMaterialIn, MapColor blockMapColorIn) {
		super(name, blockMaterialIn, blockMapColorIn);

	}

	
	
}
