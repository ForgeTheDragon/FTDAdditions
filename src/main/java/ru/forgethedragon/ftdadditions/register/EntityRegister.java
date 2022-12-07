package ru.forgethedragon.ftdadditions.register;

import cpw.mods.fml.common.registry.EntityRegistry;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.common.entity.EntityChaoticHeart;
import ru.forgethedragon.ftdadditions.common.entity.EntityHeart;

public class EntityRegister {

    public EntityRegister() {
    }

    public static void registerEntities() {
        EntityRegistry.registerModEntity(EntityHeart.class, "Persistent Heart", 12, FTDAdditions.instance, 32, 5, true);
        EntityRegistry.registerModEntity(EntityChaoticHeart.class, "Chaotic Heart Item", 13, FTDAdditions.instance, 32, 5, true);
    }
}
