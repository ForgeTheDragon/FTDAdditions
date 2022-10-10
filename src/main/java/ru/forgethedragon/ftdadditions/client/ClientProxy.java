package ru.forgethedragon.ftdadditions.client;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import ru.forgethedragon.ftdadditions.common.CommonProxy;
import ru.forgethedragon.ftdadditions.register.RenderRegister;

public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        RenderRegister.registerRendering();
    }
}
