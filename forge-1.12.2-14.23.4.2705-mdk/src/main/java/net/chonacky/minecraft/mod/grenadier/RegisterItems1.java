package net.chonacky.minecraft.mod.grenadier;



import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;



@EventBusSubscriber(modid = Grenadier.MODID)
public class RegisterItems1 {

	
	
	@ObjectHolder(Grenadier.MODID)
	public	static class Objects {
		public static final Item myfireball = new ItemGrenade();
		public static final Item grenade = new ItemMyFireball();
	}

	
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		event.getRegistry().registerAll( 
				Objects.grenade,Objects.myfireball); }


	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		((IHas1Model)Objects.myfireball).registerModel();
		((IHas1Model)Objects.grenade).registerModel();
	}
	
}