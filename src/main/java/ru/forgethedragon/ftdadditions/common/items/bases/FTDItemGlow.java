package ru.forgethedragon.ftdadditions.common.items.bases;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;

public class FTDItemGlow extends Item {

    public FTDItemGlow(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return true;
    }
}
