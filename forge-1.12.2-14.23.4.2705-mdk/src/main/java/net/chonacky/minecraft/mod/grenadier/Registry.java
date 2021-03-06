package net.chonacky.minecraft.mod.grenadier;

/*
 * Subscribes custom events for registering Mod items, blocks, etc.
 */

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;



@EventBusSubscriber(modid = Grenadier.MODID)
public class Registry {
	

	//Register Items
	@SubscribeEvent
	public static void registerItems(Register<Item> event)  {
		for (Item thisItem : ModItems.ITEMS) {
			event.getRegistry().register(thisItem);
			}
		}
	
	//Register Blocks
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event)	{
		for (Block thisBlock : ModItems.BLOCKS ) {
			event.getRegistry().register(thisBlock);
			}
	}
	
	//Register Entities
	@SubscribeEvent
	public static void registerEntities(Register<EntityEntry> event) {
		for (EntityEntry thisEntity : ModItems.ENTITIES) {
			event.getRegistry().register(thisEntity);	
		}
	}
	
	
	//Register Models
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		// : iterate lists and call client proxy model registration
		for ( Item thisItem : ModItems.ITEMS) {
			Grenadier.proxy.registerItemModel(thisItem, 0, "inventory");
		}
		for (Block thisBlock : ModItems.BLOCKS) {
			Grenadier.proxy.registerItemModel(Item.getItemFromBlock(thisBlock), 0, "normal");
		}
	}
	
	
}