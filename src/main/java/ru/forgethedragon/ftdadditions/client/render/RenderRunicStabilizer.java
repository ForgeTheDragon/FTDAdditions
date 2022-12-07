package ru.forgethedragon.ftdadditions.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lemoncraft.ModelWrapperDisplayList;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import ru.forgethedragon.ftdadditions.common.blocks.tiles.TileRunicStabilizer;

import static org.lwjgl.opengl.GL11.*;

@SideOnly(Side.CLIENT)
public class RenderRunicStabilizer extends TileEntitySpecialRenderer{
    private final ResourceLocation texturePath = new ResourceLocation("ftdadditions:textures/models/runic_stabilizer_simple.png");
    private final ResourceLocation modelPath = new ResourceLocation("ftdadditions:models/runic_stabilizer.obj");
    private final IModelCustom runicStabilizer = new ModelWrapperDisplayList((WavefrontObject) AdvancedModelLoader.loadModel(modelPath));

    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float tick) {
        this.renderTileEntityAt((TileRunicStabilizer) tile, x, y, z, tick);
    }

    public void renderTileEntityAt(TileRunicStabilizer tile, double x, double y, double z, float tick) {

        this.bindTexture(texturePath);
        glPushMatrix();
        glTranslated(x + 0.5, y, z + 0.5);
        glRotated((float)tile.tick + tick, 0.0F, -1.0F, 0.0F);
        runicStabilizer.renderAll();
        glPopMatrix();
    }
}
