package ru.forgethedragon.ftdadditions.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;

import java.util.List;

public class FinalEmblem extends Item {
    private String info;

    public FinalEmblem(String name, String texture, String description) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        info = description;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (GuiScreen.isShiftKeyDown()) {
            this.addHiddenTooltip(par1ItemStack, par2EntityPlayer, par3List, par4);
        } else {
            this.addStringToTooltip(StatCollector.translateToLocal("info." + info + ".0.name"), par3List);
        }
    }

    public void addHiddenTooltip(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        this.addStringToTooltip(StatCollector.translateToLocal("info." + info + ".1.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info." + info + ".2.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info." + info + ".3.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info." + info + ".4.name"), par3List);
    }

    void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "§"));
    }
}
