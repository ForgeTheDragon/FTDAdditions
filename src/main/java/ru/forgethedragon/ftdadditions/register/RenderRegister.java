package ru.forgethedragon.ftdadditions.register;

import cpw.mods.fml.client.registry.RenderingRegistry;
import ru.forgethedragon.ftdadditions.client.render.entity.RenderChaoticHeart;
import ru.forgethedragon.ftdadditions.common.entity.EntityChaoticHeart;

public class RenderRegister {

    public RenderRegister() {
    }

    public static void registerRendering() {
        RenderingRegistry.registerEntityRenderingHandler(EntityChaoticHeart.class, new RenderChaoticHeart());
    }
}
