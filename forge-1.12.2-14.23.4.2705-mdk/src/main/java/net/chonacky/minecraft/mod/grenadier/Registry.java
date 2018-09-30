package net.chonacky.minecraft.mod.grenadier;



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
		System.out.println(">>Number of items to iterate : "+ModItems.ITEMS.size());
		for (Item thisItem : ModItems.ITEMS) {
			System.out.println(">>>Registering "+ thisItem.toString());
			event.getRegistry().register(thisItem);}
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
		// : iterate item list and call client proxy model registration
		System.out.println(">>Number of items to iterate : "+ModItems.ITEMS.size());
		for ( Item thisItem : ModItems.ITEMS) {
			System.out.println(">>>Registering MODEL FOR "+ thisItem.toString());
			Grenadier.proxy.registerItemModel(thisItem, 0, "inventory");
		}
	}
	
	
}