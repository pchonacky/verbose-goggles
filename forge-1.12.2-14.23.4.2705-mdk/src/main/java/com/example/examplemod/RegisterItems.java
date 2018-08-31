package com.example.examplemod;



import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber
public class RegisterItems {



	@ObjectHolder(value = ExampleMod.MODID)
	public static class Objects {

		public static final Item test_item = null;
	}
	
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		System.out.println(" >>>>>>>>>>>>>  Injecting Test Item to registry");
		event.getRegistry().registerAll(new TestItem());
	}
	
	

}
