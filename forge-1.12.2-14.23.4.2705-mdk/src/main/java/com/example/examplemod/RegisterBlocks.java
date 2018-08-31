package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * Please note the Annotation below here. It is required because we will be
 * subscribing to an event, <b>before</b> preInit.
 */
@EventBusSubscriber 
public class RegisterBlocks {
	
	
	
	/*
	 * An ObjectHolder annotation will supply the underlying field or class with an
	 * object. Because we use an inner class, we only need to supply a mod-id, which
	 * states that all fields inside of it will be objects from the specified mod.
	 * To specify a specific object, you need to state what type, and what name to
	 * look for. The type, below here seen as "Block" states that this field should
	 * come from the Block-Registry. The field's name must equal the wanted object's
	 * RegistryName, minus the domain (modid).
	 */
	@ObjectHolder(value = ExampleMod.MODID)
	public static class Objects {

		public static final Block test_block = null;
//		public static final Item test_item = null;
	}
	
	
	
	
	// This method will be called without us calling it. This is because
	// Forge calls it -for- us, when the RegistryEvent happens. This is why
	// we had to use the @Mod.EventBusSubscriber at the top of the class.
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {

		System.out.println(" >>>>>>>>>>>>>  Injecting Test BLock to registry");
		event.getRegistry().registerAll(new TestBlock());
	}
	
	
//	public static void registerItems(Register<Item> event) {
//		System.out.println(" >>>>>>>>>>>>>  Injecting Test Item to registry");
//		event.getRegistry().registerAll(new TestItem());
//	}
	
	
	
	
	
	/*
	 * Don't forget to register the ItemBlock variant (When held, or in an
	 * inventory, a block is an "item") We do not need to call prepareBlocks() in
	 * this method, because Blocks are registered before items. Thus, our
	 * registerBlocks method has already happened. ItemBlocks are of course not
	 * required to be made for Items. Normal items should also be registered here in
	 * the same fashion as we did with blocks.
	 */
	@SubscribeEvent
	public static void registerItemBlocks(Register<Item> event) {

		event.getRegistry().registerAll(getItemBlock(Objects.test_block));
	}
	
	
	
	/*
	 * A small utility method to create an ItemBlock from a block, which we can call
	 * without getting so much clutter inside the Registry::registerAll method
	 * above.
	 */
	public static Item getItemBlock(Block block) {
		return new ItemBlock(block).setRegistryName(block.getRegistryName());
	}
	
	
	
	
	
	

}

