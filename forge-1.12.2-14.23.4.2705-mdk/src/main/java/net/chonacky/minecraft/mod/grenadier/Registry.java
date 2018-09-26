package net.chonacky.minecraft.mod.grenadier;



import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import net.chonacky.minecraft.mod.grenadier.ModItems;



@EventBusSubscriber(modid = Grenadier.MODID)
public class Registry {
	

	public static int ID=0;
	
	
//	//ObjectHolders
//	@ObjectHolder(Grenadier.MODID)
//	public static class Objects {
//		public static final Item grenade = null;
//		public static final Item myfireball = null;
//		public static final EntityEntry entityGrenade = null;
//	}

	
	//Register Items
	@SubscribeEvent
	public static void registerItems(Register<Item> event)  {
		//TODO find out why this doesn't interate?
		System.out.println(">>Number of items to iterate : "+ModItems.ITEMS.size());
		for (Item thisItem : ModItems.ITEMS) {
			System.out.println(">>>Registering "+ thisItem.toString());
			event.getRegistry().register(thisItem);}
		}
	
	//Register Entities
	@SubscribeEvent
	public static void registerEntities(Register<EntityEntry> event) {
		event.getRegistry().register(ModItems.entityGrenade);
	}
	
	
	//Register Models
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		// : iterate item list and call client proxy model registration
		System.out.println(">>Number of items to iterate : "+ModItems.ITEMS.size());
		for ( Item thisItem : ModItems.ITEMS) {
			System.out.println(">>>Registering MODEL FOR "+ thisItem.toString());
			Grenadier.proxy.registerItemModel(thisItem, 0, "inventory");
		}
	}
	
	
}