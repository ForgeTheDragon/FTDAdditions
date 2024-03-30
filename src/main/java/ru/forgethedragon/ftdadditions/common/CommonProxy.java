package ru.forgethedragon.ftdadditions.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.config.Configuration;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicAccelerator;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicStabilizer;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;
import ru.forgethedragon.ftdadditions.init.FTDAspects;
import ru.forgethedragon.ftdadditions.init.FTDAspectsResearch;
import ru.forgethedragon.ftdadditions.register.EntityRegister;

public class CommonProxy {

    public static Configuration config;
    public static String configFileName;
    public static final String categoryOptions = "Options Category";

    public static int rodCapacity;
    public static String cropsResearchBookFirst, cropsResearchBookSecond, avaritiaResearchBookFirst, avaritiaResearchBookSecond;

    public void preInit(FMLPreInitializationEvent event) {

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        try {
            config.load();
            configFileName = event.getSuggestedConfigurationFile().getAbsolutePath();
            rodCapacity = config.get(categoryOptions, "runicRodCapacity", 3500, "Amount Vis contained in Runic Rod.", 1, Integer.MAX_VALUE).getInt(3500);
            cropsResearchBookFirst = config.get(categoryOptions, "cropsBookResearchKeyI", "KEY", "Crop's Book First Research Key, received when you use that Book. If Key does not exist, you will be crashed.").getString();
            cropsResearchBookSecond = config.get(categoryOptions, "cropsBookResearchKeyII", "KEY", "Second Crop's Book Research Key.").getString();
            avaritiaResearchBookFirst = config.get(categoryOptions, "avaritiaBookResearchKeyI", "KEY", "Avaritia's Book Research Key, received when you use that Book. If Key does not exist, you will be crashed.").getString();
            avaritiaResearchBookSecond = config.get(categoryOptions, "avaritiaBookResearchKeyII", "KEY", "Second Avaritia's Book Research Key.").getString();
        } catch (Exception exc) {
            System.out.println("[FTDAdditions] Error occurred parsing config file");
            throw new RuntimeException(exc);
        } finally {
            config.save();
        }
    }

    public void init(FMLInitializationEvent event) {
        FTDBlocks.registerBlock();
        FTDItems.registerItem();
        EntityRegister.registerEntities();
        FTDAspects.setup();
        FTDAspectsResearch.setup();
        GameRegistry.registerTileEntity(TileRunicStabilizer.class, FTDBlocks.runicStabilizer.name);
        GameRegistry.registerTileEntity(TileRunicAccelerator.class, FTDBlocks.runicAccelerator.name);
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
