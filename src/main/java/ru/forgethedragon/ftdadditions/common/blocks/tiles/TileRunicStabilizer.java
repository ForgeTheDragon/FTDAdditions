package ru.forgethedragon.ftdadditions.common.blocks.tiles;

import net.minecraft.tileentity.TileEntity;
import thaumcraft.common.tiles.TileInfusionMatrix;

public class TileRunicStabilizer extends TileEntity {
    TileEntity tileEntity;
    public int tick = 0;

    public void updateEntity() {
        ++this.tick;
        tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord -1, this.zCoord);
        if (tileEntity instanceof TileInfusionMatrix) {
            ((TileInfusionMatrix) tileEntity).instability = 0;
        }
    }

    public boolean canUpdate() {
        return true;
    }
}
