package net.chonacky.minecraft.mod.grenadier;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class ModItems {
	
	
	public static List<Item> ITEMS = new ArrayList<Item>();
	public static List<EntityEntry> ENTITIES = new ArrayList<EntityEntry>();
	public static  int ID = 0;
	public static  Item grenade = new ItemGrenade();
	public static  Item myfireball = new ItemMyFireball();


	public static boolean eG = ENTITIES.add(EntityEntryBuilder.create()
			.entity(EntityGrenade.class)
			.id("grenade", ID++)
		    .tracker(64, 20, false)
			.name("grenade")
			.build());
	
	public static boolean eMF = ENTITIES.add(EntityEntryBuilder.create()
			.entity(EntityGrenade.class)
			.id("myfireball", ID++)
		    .tracker(64, 20, false)
			.name("myfireball")
			.build());
	
	
	//EntityMyFireball is not registered as it will use the parent class for rendering

}
