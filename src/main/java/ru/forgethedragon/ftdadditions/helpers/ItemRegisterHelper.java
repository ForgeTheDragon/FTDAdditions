package ru.forgethedragon.ftdadditions.helpers;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegisterHelper {
    public ItemRegisterHelper() {
    }

    public static void registerItem(Item item) {
        GameRegistry.registerItem(item, "" + item.getUnlocalizedName().substring(5));
    }
}
