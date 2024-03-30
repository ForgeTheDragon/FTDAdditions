package ru.forgethedragon.ftdadditions.common.items.bases;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;

public class FTDMagicSeed extends ItemSeeds {
    public FTDMagicSeed(Block crop, Block farmland, String name, String texture) {
        super(crop, farmland);
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.MODID + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
    }
}
