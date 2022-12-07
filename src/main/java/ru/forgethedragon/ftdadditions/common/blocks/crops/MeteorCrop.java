package ru.forgethedragon.ftdadditions.common.blocks.crops;

import com.mark719.magicalcrops.blocks.BlockMagicalCrops;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;

public class MeteorCrop extends BlockMagicalCrops {
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public MeteorCrop(String name) {
        this.setBlockName(name);
    }

    public Item func_149866_i() {
        return FTDItems.seedsMeteor;
    }

    public Item func_149865_P() {
        return FTDItems.essenceMeteor;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        this.iconArray = new IIcon[4];

        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = p_149651_1_.registerIcon("ftdadditions:crop_meteor_" + i);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2) {
        if (par2 < 7) {
            if (par2 == 6) {
                par2 = 5;
            }

            return this.iconArray[par2 >> 1];
        } else {
            return this.iconArray[3];
        }
    }
}
