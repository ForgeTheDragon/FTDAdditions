package ru.forgethedragon.ftdadditions.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicAccelerator;

public class RunicAccelerator extends Block implements ITileEntityProvider {
    public String name;

    public RunicAccelerator(Material material, String name, String texture) {
        super(material);
        this.name = name;
        this.setBlockName(name);
        this.setBlockTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        this.setLightOpacity(10);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
    }

    public TileRunicAccelerator createNewTileEntity(World world, int x) {
        return new TileRunicAccelerator();
    }
}
