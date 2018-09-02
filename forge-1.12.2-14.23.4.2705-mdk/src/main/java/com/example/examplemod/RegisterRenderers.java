package com.example.examplemod;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber
public class RegisterRenderers {
	
	//registerEntityRenderingHandler(MyEntity.class, MyRenderer::new)
	
	@ObjectHolder(value = ExampleMod.MODID)
	public static class Objects {

		public static final Item test_renderer = null;
	}
	
	
	

}
