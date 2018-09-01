/**
 * 
 */
package net.chonacky.minecraft.mod.grenadier;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;




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
	public static ItemGrenade myGrenadeItem;
	public static ItemMyFireball myFireBallItem;


 
	@Instance(MODID)
	public static Grenadier instance;

    @EventHandler 
    public void preInit(FMLPreInitializationEvent event){


    	
    }
    	
	

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }



    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }


}
