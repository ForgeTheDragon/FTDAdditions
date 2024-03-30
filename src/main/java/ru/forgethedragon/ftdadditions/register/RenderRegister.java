package ru.forgethedragon.ftdadditions.register;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import ru.forgethedragon.ftdadditions.client.render.*;
import ru.forgethedragon.ftdadditions.client.render.packages.*;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicStabilizer;
import ru.forgethedragon.ftdadditions.common.entity.EntityChaoticHeart;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;

public class RenderRegister {

    public RenderRegister() {
    }

    public static void registerRendering() {
        RenderingRegistry.registerEntityRenderingHandler(EntityChaoticHeart.class, new RenderChaoticHeart());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(FTDBlocks.runicStabilizer), new RenderItemRunicStabilizer());
        MinecraftForgeClient.registerItemRenderer(FTDItems.researchPackageScientific, new RenderScientificResearchPackage());
        MinecraftForgeClient.registerItemRenderer(FTDItems.researchPackageMagical, new RenderMagicalResearchPackage());
        MinecraftForgeClient.registerItemRenderer(FTDItems.researchPackageIndustrial, new RenderIndustrialResearchPackage());
        MinecraftForgeClient.registerItemRenderer(FTDItems.researchPackageChemical, new RenderChemicalResearchPackage());
        MinecraftForgeClient.registerItemRenderer(FTDItems.researchPackageAuto, new RenderAutoResearchPackage());
        MinecraftForgeClient.registerItemRenderer(FTDItems.researchPackageQuantum, new RenderQuantumResearchPackage());
        MinecraftForgeClient.registerItemRenderer(FTDItems.researchPackageDraconic, new RenderDraconicResearchPackage());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRunicStabilizer.class, new RenderRunicStabilizer());
    }
}
