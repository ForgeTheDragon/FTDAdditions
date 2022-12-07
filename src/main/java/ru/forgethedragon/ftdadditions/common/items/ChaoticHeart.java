package ru.forgethedragon.ftdadditions.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.common.entity.EntityHeart;

import java.util.List;

public class ChaoticHeart extends ItemHeart {

    public ChaoticHeart(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDAdditions.tabFTDAdditions);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (GuiScreen.isShiftKeyDown()) {
            this.addHiddenTooltip(par1ItemStack, par2EntityPlayer, par3List, par4);
        } else {
            this.addStringToTooltip(StatCollector.translateToLocal("info.ChaoticHeart.name"), par3List);
        }
    }

    public void addHiddenTooltip(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        this.addStringToTooltip(StatCollector.translateToLocal("info.ChaoticHeart.0.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.ChaoticHeart.1.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.ChaoticHeart.2.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.ChaoticHeart.3.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.ChaoticHeart.4.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.ChaoticHeart.5.name"), par3List);
    }

    void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "§"));
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityHeart(world, location, itemstack);
    }
}
