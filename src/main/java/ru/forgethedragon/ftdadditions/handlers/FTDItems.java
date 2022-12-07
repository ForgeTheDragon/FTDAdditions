package ru.forgethedragon.ftdadditions.handlers;

import net.minecraft.item.Item;
import ru.forgethedragon.ftdadditions.common.CommonProxy;
import ru.forgethedragon.ftdadditions.common.items.*;
import ru.forgethedragon.ftdadditions.common.items.wands.WandRunicCap;
import ru.forgethedragon.ftdadditions.common.items.wands.WandRunicRod;
import ru.forgethedragon.ftdadditions.helpers.ItemRegisterHelper;
import thaumcraft.api.wands.WandCap;
import thaumcraft.api.wands.WandRod;

import static com.mark719.magicalcrops.handlers.ModCompat.farmland;

public class FTDItems {

    public static final Item emblemDragon = new FTDItem("DragonEmblem", "emblem_dragon");
    public static final Item emblemStar = new FTDItem("StarEmblem", "emblem_star");
    public static final Item fragmentChaos = new FTDItem("ChaosFragment", "fragment_chaos");
    public static final Item ingotChaotic = new FTDItem("ChaoticIngot", "ingot_chaotic");
    public static final Item seedsRubber = new FTDMagicSeed(FTDBlocks.cropRubber, farmland, "RubberSeeds", "seeds_rubber");
    public static final Item seedsGraphite = new FTDMagicSeed(FTDBlocks.cropGraphite, farmland, "GraphiteSeeds", "seeds_graphite");
    public static final Item seedsMeteor = new FTDMagicSeed(FTDBlocks.cropMeteor, farmland, "MeteorSeeds", "seeds_meteor");
    public static final Item seedsDesh = new FTDMagicSeed(FTDBlocks.cropDesh, farmland, "DeshSeeds", "seeds_desh");
    public static final Item seedsTitan = new FTDMagicSeed(FTDBlocks.cropTitan, farmland, "TitanSeeds", "seeds_titan");
    public static final Item seedsVoid = new FTDMagicSeed(FTDBlocks.cropVoid, farmland, "VoidSeeds", "seeds_void");
    public static final Item seedsGaia = new FTDMagicSeed(FTDBlocks.cropGaia, farmland, "GaiaSeeds", "seeds_gaia");
    public static final Item seedsEfirium = new FTDMagicSeed(FTDBlocks.cropEfirium, farmland, "EfiriumSeeds", "seeds_efirium");
    public static final Item seedsNetherStar = new FTDMagicSeed(FTDBlocks.cropNetherStar, farmland, "NetherStarSeeds", "seeds_nether_star");
    public static final Item seedsAwakenedDraconium = new FTDMagicSeed(FTDBlocks.cropAwakenedDraconium, farmland, "AwakenedDraconiumSeeds", "seeds_awakened_draconium");
    public static final Item seedsCosmic = new FTDMagicSeed(FTDBlocks.cropCosmic, farmland, "CosmicSeeds", "seeds_cosmic");
    public static final Item essenceAbsolutio = new FTDItem("AbsolutioEssence", "essence_absolutio");
    public static final Item essenceRubber = new FTDItem("RubberEssence", "essence_rubber");
    public static final Item essenceGraphite = new FTDItem("GraphiteEssence", "essence_graphite");
    public static final Item essenceMeteor = new FTDItem("MeteorEssence", "essence_meteor");
    public static final Item essenceDesh = new FTDItem("DeshEssence", "essence_desh");
    public static final Item essenceTitan = new FTDItem("TitanEssence", "essence_titan");
    public static final Item essenceVoid = new FTDItem("VoidEssence", "essence_void");
    public static final Item essenceGaia = new FTDItem("GaiaEssence", "essence_gaia");
    public static final Item essenceEfirium = new FTDItem("EfiriumEssence", "essence_efirium");
    public static final Item essenceNetherStar = new FTDItem("NetherStarEssence", "essence_nether_star");
    public static final Item essenceAwakenedDraconium = new FTDItem("AwakenedDraconiumEssence", "essence_awakened_draconium");
    public static final Item essenceCosmic = new FTDItem("CosmicEssence", "essence_cosmic");
    public static final Item coreCorruption = new FTDItemGlow("CorruptionCore", "core_corruption");
    public static final Item runicRod = new FTDItem("RunicRod", "runic_rod");
    public static final Item runicCap = new FTDItem("RunicCap", "runic_cap");
    public static final Item solderingIron = new SolderingIron("SolderingIron", "soldering_iron");
    public static final Item amuletAntiCorruption = new AmuletAntiCorruption("AmuletAntiCorruption", "amulet_anti_corruption");
    public static final ItemHeart heartChaotic = new ChaoticHeart("ChaoticHeart", "heart_chaotic");
    public static final WandRod wandRunicRod = new WandRunicRod();
    public static final WandCap wandRunicCap = new WandRunicCap();

    public static void registerItem() {
            ItemRegisterHelper.registerItem(FTDItems.emblemDragon);
            ItemRegisterHelper.registerItem(FTDItems.emblemStar);

        if (!CommonProxy.additionDraconicEvolution) {
            ItemRegisterHelper.registerItem(FTDItems.fragmentChaos);
            ItemRegisterHelper.registerItem(FTDItems.ingotChaotic);
            ItemRegisterHelper.registerItem(FTDItems.coreCorruption);
            ItemRegisterHelper.registerItem(FTDItems.heartChaotic);
        }

        if (!CommonProxy.additionIC2) {
            ItemRegisterHelper.registerItem(FTDItems.solderingIron);
        }
        if (!CommonProxy.additionThaumcraft) {
            ItemRegisterHelper.registerItem(FTDItems.runicRod);
            ItemRegisterHelper.registerItem(FTDItems.runicCap);
        } if (!CommonProxy.additionBotania) {
            ItemRegisterHelper.registerItem(FTDItems.amuletAntiCorruption);
        }

        if (!CommonProxy.additionMagicalCrops) {
            ItemRegisterHelper.registerItem(FTDItems.seedsRubber);
            ItemRegisterHelper.registerItem(FTDItems.seedsGraphite);
            ItemRegisterHelper.registerItem(FTDItems.seedsMeteor);
            ItemRegisterHelper.registerItem(FTDItems.seedsDesh);
            ItemRegisterHelper.registerItem(FTDItems.seedsTitan);
            ItemRegisterHelper.registerItem(FTDItems.seedsVoid);
            ItemRegisterHelper.registerItem(FTDItems.seedsGaia);
            ItemRegisterHelper.registerItem(FTDItems.seedsEfirium);
            ItemRegisterHelper.registerItem(FTDItems.seedsNetherStar);
            ItemRegisterHelper.registerItem(FTDItems.seedsAwakenedDraconium);
            ItemRegisterHelper.registerItem(FTDItems.seedsCosmic);
            ItemRegisterHelper.registerItem(FTDItems.essenceAbsolutio);
            ItemRegisterHelper.registerItem(FTDItems.essenceRubber);
            ItemRegisterHelper.registerItem(FTDItems.essenceGraphite);
            ItemRegisterHelper.registerItem(FTDItems.essenceMeteor);
            ItemRegisterHelper.registerItem(FTDItems.essenceDesh);
            ItemRegisterHelper.registerItem(FTDItems.essenceTitan);
            ItemRegisterHelper.registerItem(FTDItems.essenceVoid);
            ItemRegisterHelper.registerItem(FTDItems.essenceGaia);
            ItemRegisterHelper.registerItem(FTDItems.essenceEfirium);
            ItemRegisterHelper.registerItem(FTDItems.essenceNetherStar);
            ItemRegisterHelper.registerItem(FTDItems.essenceAwakenedDraconium);
            ItemRegisterHelper.registerItem(FTDItems.essenceCosmic);
        }
    }
}
