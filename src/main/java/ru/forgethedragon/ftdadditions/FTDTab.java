package ru.forgethedragon.ftdadditions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import ru.forgethedragon.ftdadditions.common.CommonProxy;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemWandCasting;

import java.util.List;

public class FTDTab extends CreativeTabs {
    static ItemStack wandRunic;
    static ItemStack wandRunicSceptre;

    public static final FTDTab ftdTab = new FTDTab();

    private FTDTab() {
        super(FTDAdditions.MODID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return FTDItems.emblemStar;
    }

    static {
        wandRunic = new ItemStack(ConfigItems.itemWandCasting, 1, 342);
        ((ItemWandCasting) wandRunic.getItem()).setRod(wandRunic, FTDItems.wandRunicRod);
        ((ItemWandCasting) wandRunic.getItem()).setCap(wandRunic, FTDItems.wandRunicCap);
        ((ItemWandCasting) wandRunic.getItem()).storeAllVis(wandRunic, new AspectList().add(Aspect.AIR, 350000).add(Aspect.EARTH, 350000).add(Aspect.FIRE, 350000).add(Aspect.WATER, 350000).add(Aspect.ORDER, 350000).add(Aspect.ENTROPY, 350000));

        wandRunicSceptre = new ItemStack(ConfigItems.itemWandCasting, 1, 343);
        wandRunicSceptre.setTagInfo("sceptre", new NBTTagByte((byte)1));
        ((ItemWandCasting) wandRunicSceptre.getItem()).setRod(wandRunicSceptre, FTDItems.wandRunicRod);
        ((ItemWandCasting) wandRunicSceptre.getItem()).setCap(wandRunicSceptre, FTDItems.wandRunicCap);
        ((ItemWandCasting) wandRunicSceptre.getItem()).storeAllVis(wandRunicSceptre, new AspectList().add(Aspect.AIR, 525000).add(Aspect.EARTH, 525000).add(Aspect.FIRE, 525000).add(Aspect.WATER, 525000).add(Aspect.ORDER, 525000).add(Aspect.ENTROPY, 525000));
    }

    @SideOnly(Side.CLIENT)
    public void displayAllReleventItems(List list) {

        list.add(new ItemStack(FTDBlocks.blockChaotic));
        list.add(new ItemStack(FTDBlocks.blockAbsolutio));
        list.add(new ItemStack(FTDBlocks.runicStabilizer));
        list.add(new ItemStack(FTDBlocks.runicAccelerator));

        list.add(new ItemStack(FTDItems.emblemDragon));
        list.add(new ItemStack(FTDItems.emblemStar));
        list.add(new ItemStack(FTDItems.fragmentChaos));
        list.add(new ItemStack(FTDItems.ingotChaotic));
        list.add(new ItemStack(FTDItems.seedsRubber));
        list.add(new ItemStack(FTDItems.seedsGraphite));
        list.add(new ItemStack(FTDItems.seedsMeteor));
        list.add(new ItemStack(FTDItems.seedsDesh));
        list.add(new ItemStack(FTDItems.seedsTitan));
        list.add(new ItemStack(FTDItems.seedsVoid));
        list.add(new ItemStack(FTDItems.seedsGaia));
        list.add(new ItemStack(FTDItems.seedsEfirium));
        list.add(new ItemStack(FTDItems.seedsNetherStar));
        list.add(new ItemStack(FTDItems.seedsAwakenedDraconium));
        list.add(new ItemStack(FTDItems.seedsCosmic));
        list.add(new ItemStack(FTDItems.essenceAbsolutio));
        list.add(new ItemStack(FTDItems.essenceRubber));
        list.add(new ItemStack(FTDItems.essenceGraphite));
        list.add(new ItemStack(FTDItems.essenceMeteor));
        list.add(new ItemStack(FTDItems.essenceDesh));
        list.add(new ItemStack(FTDItems.essenceTitan));
        list.add(new ItemStack(FTDItems.essenceVoid));
        list.add(new ItemStack(FTDItems.essenceGaia));
        list.add(new ItemStack(FTDItems.essenceEfirium));
        list.add(new ItemStack(FTDItems.essenceNetherStar));
        list.add(new ItemStack(FTDItems.essenceAwakenedDraconium));
        list.add(new ItemStack(FTDItems.essenceCosmic));
        list.add(new ItemStack(FTDItems.coreCorruption));
        list.add(new ItemStack(FTDItems.runicRod));
        list.add(new ItemStack(FTDItems.runicCap));
        list.add(new ItemStack(FTDItems.heartChaotic));
        list.add(new ItemStack(FTDItems.solderingIron, 1, 26));
        list.add(new ItemStack(FTDItems.amuletAntiCorruption));
        list.add(wandRunic);
        list.add(wandRunicSceptre);
    }
}
