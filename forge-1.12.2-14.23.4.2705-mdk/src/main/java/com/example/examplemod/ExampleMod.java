package com.example.examplemod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";


    private static Logger logger;
    
    
    @Instance(MODID)
    public static ExampleMod instance;
    
    
    @SidedProxy(clientSide = "com.example.examplemod.ClientProxy", serverSide = "com.example.examplemod.ServerProxy") 
    public static ServerProxy proxy;
    
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }
        


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("TEST BLOCK >> {}", (new TestBlock()).getRegistryName());
        logger.info("TEST ITEM >> {}", (new TestItem()).getRegistryName());
        

        
    }


    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {


    
    }
    
}