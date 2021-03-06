package net.chonacky.minecraft.mod.grenadier;

/*
 * ModItems is the collection of all registration lists to be used by Registry class
 * (which is actually responsible for registering Mod Items, Entities, Blocks, etc.)
 */

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

public class ModItems {
	
	//ListArrays for registered items
	public static List<Item> ITEMS = new ArrayList<Item>();
	public static List<Block> BLOCKS = new ArrayList<Block>();
	public static List<EntityEntry> ENTITIES = new ArrayList<EntityEntry>();


	/*
	 * instantiating custom classes will cause those classes 
	 * to add themselves to the registry lists above
	 */
	public static  Item grenade = new ItemGrenade();
	public static  Item myfireball = new ItemMyFireball();
	public static  Block sided_block = new BlockSided();
	


	/*
	 * assigning static values forces entity entries to get added to the ArrayList for registration
	 */
	public static  int ID = 0;	//ID for entity entry registration
	
	public static boolean eG = ENTITIES.add(EntityEntryBuilder.create()
			.entity(EntityGrenade.class)
			.id("grenade", ID++)
		    .tracker(64, 20, true)
			.name("grenade")
			.build());
	
	public static boolean eMF = ENTITIES.add(EntityEntryBuilder.create()
			.entity(EntityMyFireball.class)
			.id("myfireball", ID++)
		    .tracker(64, 20, false)
			.name("myfireball")
			.build());
	
	}
