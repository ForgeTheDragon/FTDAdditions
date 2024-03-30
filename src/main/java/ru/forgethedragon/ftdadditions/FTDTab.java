package ru.forgethedragon.ftdadditions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import ru.forgethedragon.ftdadditions.handlers.FTDBlocks;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemWandCasting;

import java.util.List;

import static ru.forgethedragon.ftdadditions.common.CommonProxy.rodCapacity;

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
        ((ItemWandCasting) wandRunic.getItem()).storeAllVis(wandRunic, new AspectList().add(Aspect.AIR, rodCapacity * 100).add(Aspect.EARTH, rodCapacity * 100).add(Aspect.FIRE, rodCapacity * 100).add(Aspect.WATER, rodCapacity * 100).add(Aspect.ORDER, rodCapacity * 100).add(Aspect.ENTROPY, rodCapacity * 100));

        wandRunicSceptre = new ItemStack(ConfigItems.itemWandCasting, 1, 343);
        wandRunicSceptre.setTagInfo("sceptre", new NBTTagByte((byte)1));
        ((ItemWandCasting) wandRunicSceptre.getItem()).setRod(wandRunicSceptre, FTDItems.wandRunicRod);
        ((ItemWandCasting) wandRunicSceptre.getItem()).setCap(wandRunicSceptre, FTDItems.wandRunicCap);
        ((ItemWandCasting) wandRunicSceptre.getItem()).storeAllVis(wandRunicSceptre, new AspectList().add(Aspect.AIR, ((rodCapacity / 2) + rodCapacity) * 100).add(Aspect.EARTH, ((rodCapacity / 2) + rodCapacity) * 100).add(Aspect.FIRE, ((rodCapacity / 2) + rodCapacity) * 100).add(Aspect.WATER, ((rodCapacity / 2) + rodCapacity) * 100).add(Aspect.ORDER, ((rodCapacity / 2) + rodCapacity) * 100).add(Aspect.ENTROPY, ((rodCapacity / 2) + rodCapacity) * 100));
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
        list.add(new ItemStack(FTDItems.dustBrick));
        list.add(new ItemStack(FTDItems.dustNetherBrick));
        list.add(new ItemStack(FTDItems.dustBurntBrick));
        list.add(new ItemStack(FTDItems.blendCoke));
        list.add(new ItemStack(FTDItems.blendFireproof));
        list.add(new ItemStack(FTDItems.blendHighQuality));
        list.add(new ItemStack(FTDItems.brickCoke));
        list.add(new ItemStack(FTDItems.brickFireproof));
        list.add(new ItemStack(FTDItems.brickSmeltery));
        list.add(new ItemStack(FTDItems.ingotChaotic));
        list.add(new ItemStack(FTDItems.sheetCarbon));
        list.add(new ItemStack(FTDItems.sheetPlastic));
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
        list.add(new ItemStack(FTDItems.coreEnergyChaotic));
        list.add(new ItemStack(FTDItems.quantumModuleCompression));
        list.add(new ItemStack(FTDItems.quantumModuleInfinity));
        list.add(new ItemStack(FTDItems.circuitBaseBasic));
        list.add(new ItemStack(FTDItems.circuitBaseAdvanced));
        list.add(new ItemStack(FTDItems.circuitBasePerfect));
        list.add(new ItemStack(FTDItems.controlChipBasic));
        list.add(new ItemStack(FTDItems.controlChipAdvanced));
        list.add(new ItemStack(FTDItems.controlChipPerfect));
        list.add(new ItemStack(FTDItems.transistorBasic));
        list.add(new ItemStack(FTDItems.transistorAdvanced));
        list.add(new ItemStack(FTDItems.transistorPerfect));
        list.add(new ItemStack(FTDItems.circuitAdvanced));
        list.add(new ItemStack(FTDItems.circuitQuantum));
        list.add(new ItemStack(FTDItems.circuitPerfect));
        list.add(new ItemStack(FTDItems.combsCosmic));
        list.add(new ItemStack(FTDItems.runicRod));
        list.add(new ItemStack(FTDItems.runicCap));
        list.add(new ItemStack(FTDItems.researchBookCrops));
        list.add(new ItemStack(FTDItems.researchBookAvaritia));
        list.add(new ItemStack(FTDItems.heartChaotic));
        list.add(new ItemStack(FTDItems.solderingIron, 1, 26));
        list.add(new ItemStack(FTDItems.wateringCanUltimate, 1, 5));
        list.add(new ItemStack(FTDItems.amuletAntiCorruption));
        list.add(new ItemStack(FTDItems.researchPackageScientific));
        list.add(new ItemStack(FTDItems.researchPackageMagical));
        list.add(new ItemStack(FTDItems.researchPackageIndustrial));
        list.add(new ItemStack(FTDItems.researchPackageChemical));
        list.add(new ItemStack(FTDItems.researchPackageAuto));
        list.add(new ItemStack(FTDItems.researchPackageQuantum));
        list.add(new ItemStack(FTDItems.researchPackageDraconic));
        list.add(wandRunic);
        list.add(wandRunicSceptre);
    }
}
