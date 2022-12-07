package ru.forgethedragon.ftdadditions.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;

public class BlockAkaRock extends Block {

    public BlockAkaRock(Material material, String name, String texture) {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        this.setLightOpacity(10);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
    }
}
