package net.chonacky.minecraft.mod.grenadier;



import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber
public class RegisterEntities1 {

	@ObjectHolder(value = Grenadier.MODID)
	public static class Objects {
		
		public static final EntityEntry entity_my_fireball = null;
		
	}

	@SubscribeEvent
	public static void registerEntityEntries(Register<EntityEntry> event) {

		System.out.println(" >>>>>>>>>>>>>  Injecting Fireball Entity to registry");		
		event.getRegistry().registerAll(EntityEntryBuilder.create().entity(EntityMyFireball.class).id("entity_my_fireball", 0).name("My Fireball").build());
		
		
	}
	
	

}