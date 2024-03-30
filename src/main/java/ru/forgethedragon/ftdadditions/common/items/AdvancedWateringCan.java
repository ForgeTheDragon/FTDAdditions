package ru.forgethedragon.ftdadditions.common.items;

import com.rwtema.extrautils.LogHelper;
import com.rwtema.extrautils.helper.XUHelper;
import com.rwtema.extrautils.helper.XURandom;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import ru.forgethedragon.ftdadditions.FTDTab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AdvancedWateringCan extends Item {
    //Code taken from Extra Utilities

    public static ArrayList<ItemStack> flowers = null;
    private static Random rand = XURandom.getInstance();
    IIcon busted = null;
    IIcon ultimate = null;
    public ThreadLocal<Boolean> watering = new ThreadLocal();

    public AdvancedWateringCan() {
        this.setCreativeTab(FTDTab.ftdTab);
        this.setUnlocalizedName("WateringCan");
        this.setTextureName("ftdadditions:watering_can");
        this.setHasSubtypes(false);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        if (par1 == 2) {
            return this.busted;
        } else {
            return par1 == 5 ? this.ultimate : this.itemIcon;
        }
    }



    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IIconRegister) {
        this.itemIcon = par1IIconRegister.registerIcon(this.getIconString());
        this.busted = par1IIconRegister.registerIcon("ftdadditions:watering_can_bust");
        this.ultimate = par1IIconRegister.registerIcon("ftdadditions:watering_can_ultimate");
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 72000;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (par1ItemStack.getItemDamage() == 5 && XUHelper.isPlayerFake(par2EntityPlayer)) {
            this.waterLocation(par3World, (double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, par7, par1ItemStack, par2EntityPlayer);
            return true;
        } else {
            return false;
        }
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player) {
        if (par1ItemStack.getItemDamage() != 1) {
            if (XUHelper.isPlayerFake(player)) {
                if (par1ItemStack.getItemDamage() == 0) {
                    par1ItemStack.setItemDamage(2);
                } else {
                    this.onUsingTick(par1ItemStack, player, 0);
                }
            } else if (par1ItemStack.getItemDamage() == 2 && XUHelper.isThisPlayerACheatyBastardOfCheatBastardness(player)) {
                par1ItemStack.setItemDamage(4);
            }

            player.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            return par1ItemStack;
        } else {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);
            if (movingobjectposition == null) {
                return par1ItemStack;
            } else {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;
                    if (world.getBlock(i, j, k).getMaterial() == Material.water) {
                        if (XUHelper.isThisPlayerACheatyBastardOfCheatBastardness(player)) {
                            par1ItemStack.setItemDamage(5);
                        } else {
                            par1ItemStack.setItemDamage(0);
                        }

                        return par1ItemStack;
                    }
                }

                return par1ItemStack;
            }
        }
    }

    public String getUnlocalizedName(ItemStack par1ItemStack) {
        if (par1ItemStack.getItemDamage() == 1) {
            return super.getUnlocalizedName() + "Empty";
        } else if (par1ItemStack.getItemDamage() == 2) {
            return super.getUnlocalizedName() + "Busted";
        } else {
            return par1ItemStack.getItemDamage() == 5 ? super.getUnlocalizedName() + "Ultimate" : super.getUnlocalizedName();
        }
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.none;
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
        //par3List.add(new ItemStack(par1, 1, 0));
        //par3List.add(new ItemStack(par1, 1, 1));
        //par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 5));
    }

    public void initFlowers() {
        if (flowers == null) {
            flowers = new ArrayList();
            if (Loader.isModLoaded("Forestry")) {
                try {
                    Class flowerManager = Class.forName("forestry.api.apiculture.FlowerManager");
                    ArrayList<ItemStack> temp = (ArrayList)flowerManager.getField("plainFlowers").get((Object)null);
                    flowers.addAll(temp);
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        }
    }

    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(player.worldObj, player, true);
        if (pos != null) {
            this.waterLocation(player.worldObj, pos.hitVec.xCoord, pos.hitVec.yCoord, pos.hitVec.zCoord, pos.sideHit, stack, player);
        }

    }

    public void waterLocation(World worldObj, double hitX, double hitY, double hitZ, int side, ItemStack stack, EntityPlayer play) {
        int range = 1;
        if (stack.getItemDamage() == 3) {
            range = 3;
        }

        if (stack.getItemDamage() == 5) {
            range = 7;
        }

        if (this.watering.get() != Boolean.TRUE) {
            this.watering.set(Boolean.TRUE);
            this.waterLocation(worldObj, hitX, hitY, hitZ, side, stack, play, range);
            this.watering.set(Boolean.FALSE);
        }
    }

    private void waterLocation(World worldObj, double hitX, double hitY, double hitZ, int side, ItemStack stack, EntityPlayer play, int range) {
        List enderman = worldObj.getEntitiesWithinAABB(EntityEnderman.class, AxisAlignedBB.getBoundingBox(hitX - (double)range, hitY - (double)range, hitZ - (double)range, hitX + (double)range, hitY + 6.0D, hitZ + (double)range));
        if (enderman != null) {
            Iterator i$ = enderman.iterator();

            while(i$.hasNext()) {
                Object anEnderman = i$.next();
                ((EntityEnderman)anEnderman).attackEntityFrom(DamageSource.drown, 1.0F);
            }
        }

        boolean cheat = stack.getItemDamage() == 4 && (XUHelper.isThisPlayerACheatyBastardOfCheatBastardness(play) || LogHelper.isDeObf || XUHelper.isPlayerFake(play));
        if (worldObj.isRemote) {
            double dx = (double) Facing.offsetsXForSide[side];
            double dy = (double)Facing.offsetsYForSide[side];
            double dz = (double)Facing.offsetsZForSide[side];
            double x2 = hitX + dx * 0.1D;
            double y2 = hitY + dy * 0.1D;
            double z2 = hitZ + dz * 0.1D;

            for(int i = 0; i < (stack.getItemDamage() == 2 ? 1 : (stack.getItemDamage() == 5 ? 100 : 10)); ++i) {
                worldObj.spawnParticle("splash", x2 + worldObj.rand.nextGaussian() * 0.2D * (double)range, y2, z2 + worldObj.rand.nextGaussian() * 0.2D * (double)range, 0.0D, 0.0D, 0.0D);
            }
        } else {
            List ents = worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(hitX - (double)range, hitY - (double)range, hitZ - (double)range, hitX + (double)range, hitY + (double)range + 6.0D, hitZ + (double)range));
            if (ents != null) {
                Iterator i$ = ents.iterator();

                while(i$.hasNext()) {
                    Object ent = i$.next();
                    if (((Entity)ent).isBurning()) {
                        float p = 0.01F;
                        if (ent instanceof EntityPlayer) {
                            p = 0.333F;
                        }

                        ((Entity)ent).extinguish();
                        if (worldObj.rand.nextDouble() < (double)p) {
                            if (stack.getItemDamage() < 5) {
                                stack.setItemDamage(1);
                            }

                            if (play != null) {
                                play.stopUsingItem();
                            }

                            return;
                        }
                    }
                }
            }

            int blockX = (int)Math.floor(hitX);
            int blockY = (int)Math.floor(hitY);
            int blockZ = (int)Math.floor(hitZ);

            int y;
            int x;
            int z;
            for(x = blockX - range; x <= blockX + range; ++x) {
                for(y = blockY - range; y <= blockY + range; ++y) {
                    for(z = blockZ - range; z <= blockZ + range; ++z) {
                        Block id = worldObj.getBlock(x, y, z);
                        if (!worldObj.isAirBlock(x, y, z)) {
                            if (id == Blocks.fire) {
                                worldObj.setBlockToAir(x, y, z);
                            }

                            if (id == Blocks.flowing_lava && worldObj.rand.nextInt(2) == 0) {
                                Blocks.flowing_lava.updateTick(worldObj, x, y, z, worldObj.rand);
                            }

                            if (id == Blocks.farmland && worldObj.getBlockMetadata(x, y, z) < 7) {
                                worldObj.setBlockMetadataWithNotify(x, y, z, 7, 2);
                            }

                            int timer = -1;
                            if (id == Blocks.grass) {
                                timer = 20;
                                if (!cheat && worldObj.rand.nextInt(4500) == 0 && worldObj.isAirBlock(x, y + 1, z)) {
                                    this.initFlowers();
                                    if (flowers.size() > 0 && worldObj.rand.nextInt(5) == 0) {
                                        ItemStack flower = (ItemStack)flowers.get(worldObj.rand.nextInt(flowers.size()));
                                        if (flower.getItem() instanceof ItemBlock && play != null) {
                                            ((ItemBlock)flower.getItem()).placeBlockAt(flower, play, worldObj, x, y + 1, z, 1, 0.5F, 1.0F, 0.5F, flower.getItem().getMetadata(flower.getItemDamage()));
                                        }
                                    } else {
                                        worldObj.getBiomeGenForCoords(x, z).plantFlower(worldObj, rand, x, y + 1, z);
                                    }
                                }
                            } else if (id == Blocks.mycelium) {
                                timer = 20;
                            } else if (id == Blocks.wheat) {
                                timer = 40;
                            } else if (id instanceof BlockSapling) {
                                timer = 50;
                            } else if (!(id instanceof IPlantable) && !(id instanceof IGrowable)) {
                                if (id.getMaterial() == Material.grass) {
                                    timer = 20;
                                }
                            } else {
                                timer = 40;
                            }

                            if (stack.getItemDamage() == 5) {
                                timer = 50;
                            }

                            timer /= range;
                            if (timer > 0 && id.getTickRandomly()) {
                                worldObj.scheduleBlockUpdate(x, y, z, id, worldObj.rand.nextInt(timer));
                            }
                        }
                    }
                }
            }

            if (cheat) {
                for(x = 0; x < 100; ++x) {
                    for(y = blockX - range; y <= blockX + range; ++y) {
                        for(z = blockY - range; z <= blockY + range; ++z) {
                            for(int f = blockZ - range; f <= blockZ + range; ++f) {
                                Block block = worldObj.getBlock(y, f, f);
                                block.updateTick(worldObj, y, f, f, worldObj.rand);
                                TileEntity tile = worldObj.getTileEntity(y, f, f);
                                if (tile != null && tile.canUpdate() && !tile.isInvalid()) {
                                    tile.updateEntity();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
