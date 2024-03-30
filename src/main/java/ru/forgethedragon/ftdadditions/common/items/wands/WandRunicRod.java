package ru.forgethedragon.ftdadditions.common.items.wands;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;
import thaumcraft.api.wands.WandRod;

import static ru.forgethedragon.ftdadditions.common.CommonProxy.rodCapacity;

public class WandRunicRod extends WandRod {
    ResourceLocation textureRod = new ResourceLocation("ftdadditions:textures/models/runic_rod.png");

    public WandRunicRod() {
        super("runic_rod", rodCapacity, new ItemStack(FTDItems.runicRod), 60);
        this.setGlowing(true);
    }

    public WandRunicRod(String s) {
        super(s, rodCapacity, new ItemStack(FTDItems.runicRod), 60);
        this.setGlowing(true);
    }

    @Override
    public ResourceLocation getTexture() {
        return this.textureRod;
    }

    public String getResearch() {
        return "INFUSION";
    }
}
