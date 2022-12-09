package ru.forgethedragon.ftdadditions.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.glTranslated;

public class RenderItemRunicStabilizer implements IItemRenderer {
    private final ResourceLocation texturePath = new ResourceLocation("ftdadditions:textures/models/runic_stabilizer_simple.png");
    private final ResourceLocation modelPath = new ResourceLocation("ftdadditions:models/runic_stabilizer.obj");
    private final IModelCustom runicStabilizer = new ModelWrapperDisplayList((WavefrontObject) AdvancedModelLoader.loadModel(modelPath));

    public RenderItemRunicStabilizer() {
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        if (type == ItemRenderType.EQUIPPED) {
            glTranslated(0.5, 0.0, 0.5);
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
        } else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            glTranslated(0.5, 0.5, 0.5);
        } else if (type != ItemRenderType.ENTITY) {
            glTranslated(0.5, 0.0, 0.5);
            GL11.glRotatef(24.0F, 0.0F, -0.1F, 0.0F);
        }
        GL11.glScalef(0.9F, 0.9F, 0.9F);
        Minecraft.getMinecraft().renderEngine.bindTexture(texturePath);
        runicStabilizer.renderAll();
        GL11.glPopMatrix();
    }

    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }
}
