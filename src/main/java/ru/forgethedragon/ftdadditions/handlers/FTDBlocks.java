package ru.forgethedragon.ftdadditions.handlers;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.forgethedragon.ftdadditions.common.CommonProxy;
import ru.forgethedragon.ftdadditions.common.blocks.BlockAkaRock;
import ru.forgethedragon.ftdadditions.common.blocks.ChaoticBlock;
import ru.forgethedragon.ftdadditions.common.blocks.RunicAccelerator;
import ru.forgethedragon.ftdadditions.common.blocks.RunicStabilizer;
import ru.forgethedragon.ftdadditions.common.blocks.crops.*;
import ru.forgethedragon.ftdadditions.helpers.BlockRegisterHelper;

public class FTDBlocks {

    public static final Block cropRubber = new RubberCrop("RubberCrop");
    public static final Block cropGraphite = new GraphiteCrop("GraphiteCrop");
    public static final Block cropMeteor = new MeteorCrop("MeteorCrop");
    public static final Block cropDesh = new DeshCrop("DeshCrop");
    public static final Block cropTitan = new TitanCrop("TitanCrop");
    public static final Block cropVoid = new VoidCrop("VoidCrop");
    public static final Block cropGaia = new GaiaCrop("GaiaCrop");
    public static final Block cropEfirium = new EfiriumCrop("EfiriumCrop");
    public static final Block cropNetherStar = new NetherStarCrop("NetherStarCrop");
    public static final Block cropAwakenedDraconium = new AwakenedDraconiumCrop("AwakenedDraconiumCrop");
    public static final Block cropCosmic = new CosmicCrop("CosmicCrop");

    public static final Block blockChaotic = new ChaoticBlock(Material.iron, "ChaoticBlock", "block_chaotic_top");
    public static final Block blockAbsolutio = new BlockAkaRock(Material.rock, "AbsolutioBlock", "block_absolutio");
    public static final RunicStabilizer runicStabilizer = new RunicStabilizer(Material.rock, "RunicStabilizer", "runic_stabilizer");
    public static final RunicAccelerator runicAccelerator = new RunicAccelerator(Material.rock, "RunicAccelerator", "runic_accelerator");

    public static void registerBlock() {

        if (!CommonProxy.additionDraconicEvolution) {
            BlockRegisterHelper.registerBlock(FTDBlocks.blockChaotic);
        }

        if (!CommonProxy.additionThaumcraft) {
            BlockRegisterHelper.registerBlock(FTDBlocks.runicStabilizer);
            BlockRegisterHelper.registerBlock(FTDBlocks.runicAccelerator);
        }

        if (!CommonProxy.additionMagicalCrops) {
            BlockRegisterHelper.registerBlock(FTDBlocks.blockAbsolutio);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropRubber);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropGraphite);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropMeteor);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropDesh);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropTitan);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropVoid);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropGaia);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropEfirium);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropNetherStar);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropAwakenedDraconium);
            BlockRegisterHelper.registerBlock(FTDBlocks.cropCosmic);
        }
    }
}
