package ru.forgethedragon.ftdadditions.common.items.wands;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;
import thaumcraft.api.wands.WandCap;

public class WandRunicCap extends WandCap {
    ResourceLocation textureCap = new ResourceLocation("ftdadditions:textures/models/runic_cap.png");

    public WandRunicCap() {
        super("runic_cap", 0.6F, new ItemStack(FTDItems.runicCap), 30);
    }

    public WandRunicCap(String s) {
        super(s, 0.6F, new ItemStack(FTDItems.runicCap), 30);
    }

    public ResourceLocation getTexture() {
        return this.textureCap;
    }

    public String getResearch() {
        return "INFUSION";
    }
}
