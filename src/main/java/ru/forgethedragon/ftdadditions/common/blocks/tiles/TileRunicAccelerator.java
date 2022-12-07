package ru.forgethedragon.ftdadditions.common.blocks.tiles;

import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.tiles.TileInfusionMatrix;

import java.lang.reflect.Field;

public class TileRunicAccelerator extends TileInfusionMatrix {
    //in process..

    private AspectList recipeEssentia = new AspectList();
    public static Field field;
    TileEntity tileEntity;
    Aspect aspect;

    public void updateEntity(TileInfusionMatrix tileMatrix) {
        tileEntity = this.worldObj.getTileEntity(this.xCoord, this.yCoord -2, this.zCoord);
        if (tileEntity instanceof TileInfusionMatrix) {
            this.recipeEssentia.reduce(aspect, 5);
        }
    }

    public boolean canUpdate() {
        return true;
    }
}
