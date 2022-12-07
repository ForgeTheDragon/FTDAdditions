package ru.forgethedragon.ftdadditions.init;

import net.minecraft.item.ItemStack;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;

public class FTDAspectsResearch {

    public static void setup() {
        registerBlocksAspects();
    }

    public static void registerBlocksAspects() {
        ThaumcraftApi.registerObjectTag(new ItemStack(FTDBlocks.blockChaotic), (new AspectList()).add(FTDAspects.RELICTUM, 4));
    }
}
