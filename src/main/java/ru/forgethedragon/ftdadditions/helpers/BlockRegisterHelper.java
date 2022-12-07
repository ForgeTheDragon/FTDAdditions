package ru.forgethedragon.ftdadditions.helpers;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockRegisterHelper {
    public BlockRegisterHelper() {
    }

    public static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, "" + block.getUnlocalizedName().substring(5));
    }
}
