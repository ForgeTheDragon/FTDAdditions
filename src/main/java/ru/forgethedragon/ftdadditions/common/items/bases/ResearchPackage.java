package ru.forgethedragon.ftdadditions.common.items.bases;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import ru.forgethedragon.ftdadditions.FTDTab;

import java.util.List;

public class ResearchPackage extends Item {
    private String info;

    public ResearchPackage(String name, String description) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(FTDTab.ftdTab);
        info = description;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        this.addStringToTooltip(StatCollector.translateToLocal(info), par3List);
    }

    void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "§"));
    }
}
