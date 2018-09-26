/**
 * 
 */
package net.chonacky.minecraft.mod.grenadier;



import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


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


 
	@Instance(MODID)
	public static Grenadier instance;
	
	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static ServerProxy proxy;
	

    @EventHandler 
    public void preInit(FMLPreInitializationEvent event){
    	
    	proxy.RegisterRenderers();
    }

	

	
		
	

    @EventHandler
    public void init(FMLInitializationEvent event) {
		
    }



    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }


}
