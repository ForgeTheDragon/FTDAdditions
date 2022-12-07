package ru.forgethedragon.ftdadditions.handlers;

import net.minecraft.item.Item;
import ru.forgethedragon.ftdadditions.common.items.ChaoticHeart;
import ru.forgethedragon.ftdadditions.common.items.FTDItem;
import ru.forgethedragon.ftdadditions.common.items.FTDItemGlow;
import ru.forgethedragon.ftdadditions.common.items.ItemHeart;
import ru.forgethedragon.ftdadditions.helpers.ItemRegisterHelper;

public class FTDItems {

    public static final Item ingotChaotic = new FTDItem("ChaoticIngot", "ingot_chaotic");
    public static final Item fragmentChaos = new FTDItem("ChaosFragment", "fragment_chaos");
    public static final Item coreCorruption = new FTDItemGlow("CorruptionCore", "core_corruption");
    public static final ItemHeart heartChaotic = new ChaoticHeart("ChaoticHeart", "heart_chaotic");

    public static void registerItem() {
        ItemRegisterHelper.registerItem(FTDItems.ingotChaotic);
        ItemRegisterHelper.registerItem(FTDItems.fragmentChaos);
        ItemRegisterHelper.registerItem(FTDItems.coreCorruption);
        ItemRegisterHelper.registerItem(FTDItems.heartChaotic);
    }
}
