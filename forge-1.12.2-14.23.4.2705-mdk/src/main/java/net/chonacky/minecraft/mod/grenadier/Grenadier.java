/**
 * 
 */
package net.chonacky.minecraft.mod.grenadier;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.projectile.EntityFireball;



/**
 * 
 * @author philip
 *
 */
@Mod(modid = Grenadier.MODID, name=Grenadier.NAME, version=Grenadier.VERSION, dependencies="required-after:FML")
public class Grenadier 
{
	public static final String MODID = "grenadier";
	public static final String VERSION = "0.3";
	public static final String NAME = "Grenadier Mod";



 
	@Instance(MODID)
	public static Grenadier instance;

    @EventHandler 
    public void preInit(FMLPreInitializationEvent event){

		RenderingRegistry.registerEntityRenderingHandler(EntityMyFireball.class, new IRenderFactory <EntityFireball>() {

			@Override
			public Render<? super EntityFireball> createRenderFor(RenderManager manager) 
			{
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> creating renderer");
				return new RenderFireball(Minecraft.getMinecraft().getRenderManager(), 1.0F);
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
