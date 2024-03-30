package ru.forgethedragon.ftdadditions.common.items.bases;

import net.minecraft.item.Item;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;

public class FTDItem extends Item {

    public FTDItem(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
    }
}
