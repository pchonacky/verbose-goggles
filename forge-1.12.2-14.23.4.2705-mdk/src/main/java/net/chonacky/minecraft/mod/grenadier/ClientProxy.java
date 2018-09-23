/**
 * 
 */
package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * @author philip
 *
 */
public class ClientProxy extends ServerProxy {
	
	public void registerModel(Item item, int i, String type) {
		
		ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), type));
		
	}
	
	
	
	
	

}
