/**
 * 
 */
package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * @author philip
 *
 */
public class ClientProxy extends ServerProxy {
	
	public void registerItemModel(Item item, int i, String type) {
		ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), type));
	}
	
	//called from Main Class (Grenadier)
	public void RegisterRenderers() {
	  	//Register RenderSnowball as renderer for EntityGrenade using ItemGrenade texture
     	RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new IRenderFactory <EntityGrenade>() {
			@Override
			public Render<? super Entity> createRenderFor(RenderManager manager)  {
					return (Render<? super Entity>)new RenderSnowball<Entity>(manager, ModItems.grenade, Minecraft.getMinecraft().getRenderItem());
				}	 
     		}
     	);
	}	

}
