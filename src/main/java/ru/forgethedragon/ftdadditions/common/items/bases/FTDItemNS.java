package ru.forgethedragon.ftdadditions.common.items.bases;

import net.minecraft.item.Item;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;

public class FTDItemNS extends Item {

    public FTDItemNS(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        this.setMaxStackSize(1);
    }
}
