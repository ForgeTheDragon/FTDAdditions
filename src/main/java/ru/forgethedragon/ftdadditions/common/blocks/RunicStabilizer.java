package ru.forgethedragon.ftdadditions.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicStabilizer;
import thaumcraft.api.crafting.IInfusionStabiliser;

public class RunicStabilizer extends Block implements IInfusionStabiliser, ITileEntityProvider {
    public String name;

    public RunicStabilizer(Material material, String name, String texture) {
        super(material);
        this.name = name;
        this.setBlockName(name);
        this.setBlockTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setLightLevel(0.4F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    public boolean canStabaliseInfusion(World world, int x, int y, int z) {
        return true;
    }

    public TileRunicStabilizer createNewTileEntity(World world, int x) {
        return new TileRunicStabilizer();
    }
}
