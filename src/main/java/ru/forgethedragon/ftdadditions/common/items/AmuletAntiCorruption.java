package ru.forgethedragon.ftdadditions.common.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;
import thaumcraft.common.config.Config;
import vazkii.botania.common.entity.EntityDoppleganger;

import java.util.List;

public class AmuletAntiCorruption extends Item implements IBauble {

    public AmuletAntiCorruption(String name, String texture) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        this.setMaxStackSize(1);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!EntityDoppleganger.isTruePlayer(par3EntityPlayer)) {
            return par1ItemStack;
        } else {
            if (this.canEquip(par1ItemStack, par3EntityPlayer)) {
                InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(par3EntityPlayer);

                for(int i = 0; i < baubles.getSizeInventory(); ++i) {
                    if (baubles.isItemValidForSlot(i, par1ItemStack)) {
                        ItemStack stackInSlot = baubles.getStackInSlot(i);
                        if (stackInSlot == null || ((IBauble)stackInSlot.getItem()).canUnequip(stackInSlot, par3EntityPlayer)) {
                            if (!par2World.isRemote) {
                                baubles.setInventorySlotContents(i, par1ItemStack.copy());
                                if (!par3EntityPlayer.capabilities.isCreativeMode) {
                                    par3EntityPlayer.inventory.setInventorySlotContents(par3EntityPlayer.inventory.currentItem, (ItemStack)null);
                                }
                            }

                            if (stackInSlot != null) {
                                ((IBauble)stackInSlot.getItem()).onUnequipped(stackInSlot, par3EntityPlayer);
                                return stackInSlot.copy();
                            }
                            break;
                        }
                    }
                }
            }

            return par1ItemStack;
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (GuiScreen.isShiftKeyDown()) {
            this.addHiddenTooltip(par1ItemStack, par2EntityPlayer, par3List, par4);
        } else {
            this.addStringToTooltip(StatCollector.translateToLocal("info.AmuletAntiCorruption.0.name"), par3List);
        }
    }

    public void addHiddenTooltip(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        this.addStringToTooltip(StatCollector.translateToLocal("info.AmuletAntiCorruption.1.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.AmuletAntiCorruption.2.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.AmuletAntiCorruption.3.name"), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.AmuletAntiCorruption.4.name"), par3List);
    }

    void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "§"));
    }

    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.addPotionEffect(new PotionEffect(Config.potionWarpWardID, 200, 0, true));
        }
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }
}
