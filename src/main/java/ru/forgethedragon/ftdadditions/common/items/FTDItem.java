package ru.forgethedragon.ftdadditions.common.items;

import net.minecraft.item.Item;
import ru.forgethedragon.ftdadditions.FTDAdditions;

public class FTDItem extends Item {

    public FTDItem(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDAdditions.tabFTDAdditions);
    }
}
