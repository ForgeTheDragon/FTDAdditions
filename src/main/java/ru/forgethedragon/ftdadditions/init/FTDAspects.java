package ru.forgethedragon.ftdadditions.init;

import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;

public class FTDAspects {

    public static Aspect RELICTUM;

    public static void setup() {
        RELICTUM = new Aspect("relictum", 16769938, new Aspect[]{Aspect.GREED, Aspect.MAN}, new ResourceLocation("ftdadditions", "textures/aspects/relictum.png"), 1);
    }
}
