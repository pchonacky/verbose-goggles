package net.chonacky.minecraft.mod.grenadier;



import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber
public class RegisterItems1 {



	@ObjectHolder(value = Grenadier.MODID)
	public static class Objects {

		public static final Item my_fireball = null;
	}
	
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		System.out.println(" >>>>>>>>>>>>>  Injecting Fireball Item to registry");
		event.getRegistry().registerAll(new ItemMyFireball());
	}
	
	

}
