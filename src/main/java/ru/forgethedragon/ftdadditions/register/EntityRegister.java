package ru.forgethedragon.ftdadditions.register;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.common.CommonProxy;
import ru.forgethedragon.ftdadditions.common.blocks.RunicAccelerator;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicAccelerator;
import ru.forgethedragon.ftdadditions.common.entity.EntityChaoticHeart;
import ru.forgethedragon.ftdadditions.common.entity.EntityHeart;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;

public class EntityRegister {
    public static RunicAccelerator runicAccelerator;

    public EntityRegister() {
    }

    public static void registerEntities() {
        if (!CommonProxy.additionDraconicEvolution) {
            EntityRegistry.registerModEntity(EntityHeart.class, "Persistent Heart", 12, FTDAdditions.instance, 32, 5, true);
            EntityRegistry.registerModEntity(EntityChaoticHeart.class, "Chaotic Heart Item", 13, FTDAdditions.instance, 32, 5, true);
        }
    }
}
