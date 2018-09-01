package com.example.examplemod;



import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber
public class RegisterEntities {

	@ObjectHolder(value = ExampleMod.MODID)
	public static class Objects {
		
		public static final EntityEntry test_entity = null;
		
	}

	@SubscribeEvent
	public static void registerEntityEntries(Register<EntityEntry> event) {

		EntityEntry this_entityEntry = EntityEntryBuilder.create().entity(TestEntity.class).id("test_entity", 0).name("test_entity").build();
		
		event.getRegistry().registerAll(this_entityEntry);
		
		
	}
	
	

}
