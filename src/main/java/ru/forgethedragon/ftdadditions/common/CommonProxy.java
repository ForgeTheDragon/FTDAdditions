package ru.forgethedragon.ftdadditions.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;
import ru.forgethedragon.ftdadditions.register.EntityRegister;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        FTDItems.registerItem();
        FTDBlocks.registerBlock();
        EntityRegister.registerEntities();
    }

    public void init(FMLInitializationEvent event) {
    }
}
