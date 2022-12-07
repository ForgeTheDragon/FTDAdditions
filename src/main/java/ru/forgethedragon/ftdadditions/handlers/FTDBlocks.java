package ru.forgethedragon.ftdadditions.handlers;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.forgethedragon.ftdadditions.common.blocks.ChaoticBlock;
import ru.forgethedragon.ftdadditions.helpers.BlockRegisterHelper;

public class FTDBlocks {

    public static final Block blockChaotic = new ChaoticBlock(Material.iron, "ChaoticBlock", "block_chaotic_top");

    public static void registerBlock() {
        BlockRegisterHelper.registerBlock(FTDBlocks.blockChaotic);
    }
}
