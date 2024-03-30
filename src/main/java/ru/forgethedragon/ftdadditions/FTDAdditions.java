package ru.forgethedragon.ftdadditions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.forgethedragon.ftdadditions.common.CommonProxy;

@Mod(modid = FTDAdditions.MODID, name = FTDAdditions.MODNAME, version = FTDAdditions.VERSION, dependencies = FTDAdditions.DEPENDENCIES)

public class FTDAdditions
{
    @Mod.Instance(FTDAdditions.MODID)
    public static FTDAdditions instance;

    @SidedProxy(
            clientSide = "ru.forgethedragon.ftdadditions.client.ClientProxy",
            serverSide = "ru.forgethedragon.ftdadditions.common.CommonProxy"
    )
    public static CommonProxy proxy;

    public static final String MODID = "FTDAdditions";
    public static final String MODNAME = "FTD Additions";
    public static final String VERSION = "1.2.0";
    public static final String DEPENDENCIES = "required-after:DraconicEvolution;required-after:magicalcrops;required-after:IC2;required-after:Thaumcraft;required-after:Botania";
    public static final String TEXTURES = "ftdadditions";

    public static Logger log;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        log = LogManager.getLogger("FTDAdditions");
        proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
