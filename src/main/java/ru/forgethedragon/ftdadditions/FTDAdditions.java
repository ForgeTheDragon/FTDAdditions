package ru.forgethedragon.ftdadditions;

import com.brandon3055.brandonscore.common.utills.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.forgethedragon.ftdadditions.common.CommonProxy;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;

@Mod(modid = FTDAdditions.MODID, name = FTDAdditions.MODNAME, version = FTDAdditions.VERSION)
public class FTDAdditions
{
    @Mod.Instance(FTDAdditions.MODID)
    public static FTDAdditions instance;

    @SidedProxy(
            clientSide = "ru.forgethedragon.ftdadditions.client.ClientProxy",
            serverSide = "ru.forgethedragon.ftdadditions.common.CommonProxy"
    )
    public static CommonProxy proxy;

    public static final CreativeTabs tabFTDAdditions = new CreativeTabs("TabFTDAdditions") {
        @Override
        public Item getTabIconItem() {
            return FTDItems.ingotChaotic;
        }
    };

    public static final String MODID = "FTDAdditions";
    public static final String VERSION = "1.0.0";
    public static final String MODNAME = "FTD Additions";
    public static final String TEXTURES = "ftdadditions";

    public FTDAdditions() {
        LogHelper.info("FTDAdditions in inclusive :)");
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
}
