/**
 * 
 */
package net.chonacky.minecraft.mod.grenadier;




import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;




/**
 * 
 * @author philip
 *
 */
@Mod(modid = Grenadier.MODID, name=Grenadier.NAME, version=Grenadier.VERSION)
public class Grenadier 
{
	public static final String MODID = "grenadier";
	public static final String VERSION = "0.3";
	public static final String NAME = "Grenadier Mod";
	public static final String CLIENT_PROXY = "net.chonacky.minecraft.mod.grenadier.ClientProxy";
	public static final String SERVER_PROXY = "net.chonacky.minecraft.mod.grenadier.ServerProxy";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";

	public static int ID = 0;
	public static ItemMyFireball itemMyFireball;
	public static ItemGrenade itemGrenade;
	public static EntityEntry  entityGrenade;

 
	@Instance(MODID)
	public static Grenadier instance;
	
	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static ServerProxy proxy;
	

    @EventHandler 
    public void preInit(FMLPreInitializationEvent event){




	entityGrenade = EntityEntryBuilder.create()
			.entity(EntityGrenade.class)
			.id("grenade", ID++)
		    .tracker(64, 20, false)
			.name("grenade")
			.build();
	ForgeRegistries.ENTITIES.register(entityGrenade);
	

	
	//Register RenderSnowball as renderer for EntityGrenade using ItemGrenade texture
	Minecraft mcIn = Minecraft.getMinecraft();	
 	RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new IRenderFactory <EntityGrenade>() {
		@Override
		public Render<? super Entity> createRenderFor(RenderManager manager) 
			{
				return (Render<? super Entity>)new RenderSnowball<Entity>(manager, itemGrenade, mcIn.getRenderItem());
			}	 
		});

    }
    	
	

    @EventHandler
    public void init(FMLInitializationEvent event) {
	
    }



    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }


}
