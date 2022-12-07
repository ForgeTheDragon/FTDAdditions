package ru.forgethedragon.ftdadditions.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.config.Configuration;
import org.lwjgl.opengl.Display;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;
import ru.forgethedragon.ftdadditions.common.blocks.RunicAccelerator;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicAccelerator;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicStabilizer;
import ru.forgethedragon.ftdadditions.common.items.wands.WandRunicRod;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;
import ru.forgethedragon.ftdadditions.init.FTDAspects;
import ru.forgethedragon.ftdadditions.init.FTDAspectsResearch;
import ru.forgethedragon.ftdadditions.register.EntityRegister;

public class CommonProxy {

    public static Configuration config;
    public static String configFileName;
    public static final String categoryAdditions = "Additions Category";

    public static boolean additionSolarEclipse;
    public static boolean additionDraconicEvolution;
    public static boolean additionMagicalCrops;
    public static boolean additionThaumcraft;
    public static boolean additionBotania;
    public static boolean additionIC2;

    public void preInit(FMLPreInitializationEvent event) {

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        try {
            config.load();
            configFileName = event.getSuggestedConfigurationFile().getAbsolutePath();
            additionSolarEclipse = config.get(categoryAdditions, "Disable Addition for Solar Eclipse Modpack", false).getBoolean(false);
            additionDraconicEvolution = config.get(categoryAdditions, "Disable Addition for DraconicEvolution", false).getBoolean(false);
            additionMagicalCrops = config.get(categoryAdditions, "Disable Addition for MagicalCrops", false).getBoolean(false);
            additionIC2 = config.get(categoryAdditions, "Disable Addition for IndustrialCraft2", false).getBoolean(false);
            additionThaumcraft = config.get(categoryAdditions, "Disable Addition for Thaumcraft", false).getBoolean(false);
            additionBotania = config.get(categoryAdditions, "Disable Addition for Botania", false).getBoolean(false);
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
