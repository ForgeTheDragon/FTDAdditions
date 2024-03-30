package ru.forgethedragon.ftdadditions.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.FTDTab;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.playerdata.PacketResearchComplete;
import thaumcraft.common.lib.research.ResearchManager;

import java.util.List;

public class ResearchBook extends Item {
    private String firstKey, secondKey, info;

    public ResearchBook(String name, String texture, String keyFirst, String keySecond, String description) {
        this.setUnlocalizedName(name);
        this.setTextureName(FTDAdditions.TEXTURES + ":" + texture);
        this.setCreativeTab(FTDTab.ftdTab);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        firstKey = keyFirst;
        secondKey = keySecond;
        info = description;
    }

    public ItemStack onItemRightClick(ItemStack stack, World par2World, EntityPlayer player) {
        if (!par2World.isRemote && stack.getItemDamage() == 0 && !ResearchManager.isResearchComplete(player.getCommandSenderName(), firstKey) && !ResearchManager.isResearchComplete(player.getCommandSenderName(), secondKey)) {
            PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(firstKey), (EntityPlayerMP) player);
            Thaumcraft.proxy.getResearchManager().completeResearch(player, firstKey);
            PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(secondKey), (EntityPlayerMP)player);
            Thaumcraft.proxy.getResearchManager().completeResearch(player, secondKey);
            par2World.playSoundAtEntity(player, "thaumcraft:learn", 0.75F, 1.0F);
        }

        return stack;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        this.addStringToTooltip(StatCollector.translateToLocal(info), par3List);
        this.addStringToTooltip(StatCollector.translateToLocal("info.ResearchBook.2.name"), par3List);
    }

    void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "§"));
    }
}
