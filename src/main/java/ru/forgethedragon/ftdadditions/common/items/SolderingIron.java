package ru.forgethedragon.ftdadditions.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolderingIron extends Item implements IElectricItem {
    private int maxCharge;
    private int tier;
    private float effPower;
    private int energyPerOperation;
    private int transferLimit;
    public Set mineableBlocks = new HashSet();
    public int soundTicker;
    public int damageVsEntity;

    public SolderingIron(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        this.setMaxStackSize(1);
        this.setMaxDamage(27);
        this.maxCharge = 15000;
        this.transferLimit = 500;
        this.tier = 1;
        this.effPower = 30.0F;
        this.energyPerOperation = 100;
        this.damageVsEntity = 2;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        this.addStringToTooltip(StatCollector.translateToLocal("info.SolderingIron.0.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.SolderingIron.1.name"), par3List);
    }

    void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "§"));
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs var2, List var3) {
        ItemStack var4 = new ItemStack(this, 1);
        ElectricItem.manager.charge(var4, 2.147483647E9D, 2147483647, true, false);
        var3.add(var4);
        var3.add(new ItemStack(this, 1, this.getMaxDamage()));
    }

    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    public double getMaxCharge(ItemStack itemStack) {
        return (double)this.maxCharge;
    }

    public int getTier(ItemStack itemStack) {
        return this.tier;
    }

    public double getTransferLimit(ItemStack itemStack) {
        return (double)this.transferLimit;
    }

    public Item getChargedItem(ItemStack itemStack) {
        return this;
    }

    public Item getEmptyItem(ItemStack itemStack) { return this; }
}
