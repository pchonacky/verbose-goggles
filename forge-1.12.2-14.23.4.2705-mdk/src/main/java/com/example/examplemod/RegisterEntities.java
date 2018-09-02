package com.example.examplemod;



import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber
public class RegisterEntities {
	
	static int ID=0;

	@ObjectHolder(value = ExampleMod.MODID)
	public static class Objects {
		
		public static final EntityEntry test_entity = null;
		
	}

	@SuppressWarnings("deprecation")	
	@SubscribeEvent
	public static void registerEntityEntries(Register<EntityEntry> event) {

		
		System.out.println(" >>>>>>>>>>>>>  Injecting Test Entity  to registry");
		EntityEntry this_entityEntry = 
				EntityEntryBuilder.create()
				.entity(TestEntity.class)
				.id("test_entity", ID++)
				.egg(0xFFFFFF, 0xAAAAAA)
			    .tracker(64, 20, false)
				.name("test_entity")
				.build();
		
		event.getRegistry().registerAll(this_entityEntry);
		

	}
	
	

}
