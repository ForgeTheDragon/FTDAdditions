package ru.forgethedragon.ftdadditions.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.forgethedragon.ftdadditions.FTDAdditions;

public class FTDItemGlow extends Item {

    public FTDItemGlow(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDAdditions.tabFTDAdditions);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return true;
    }
}
