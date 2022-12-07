package ru.forgethedragon.ftdadditions.register;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.forgethedragon.ftdadditions.client.render.RenderChaoticHeart;
import ru.forgethedragon.ftdadditions.client.render.RenderItemRunicStabilizer;
import ru.forgethedragon.ftdadditions.client.render.RenderRunicStabilizer;
import ru.forgethedragon.ftdadditions.common.CommonProxy;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicStabilizer;
import ru.forgethedragon.ftdadditions.common.entity.EntityChaoticHeart;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;

public class RenderRegister {

    public RenderRegister() {
    }

    public static void registerRendering() {
        if (Loader.isModLoaded("DraconicEvolution")) {
            if (!CommonProxy.additionDraconicEvolution) {
                RenderingRegistry.registerEntityRenderingHandler(EntityChaoticHeart.class, new RenderChaoticHeart());
            }
        }
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FTDBlocks.runicStabilizer), new RenderItemRunicStabilizer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRunicStabilizer.class, new RenderRunicStabilizer());
    }
}
