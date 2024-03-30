package ru.forgethedragon.ftdadditions.client.render.packages;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import org.lwjgl.opengl.GL11;
import ru.forgethedragon.ftdadditions.client.render.ModelWrapperDisplayList;

import static org.lwjgl.opengl.GL11.glTranslated;

@SideOnly(Side.CLIENT)
public class RenderScientificResearchPackage implements IItemRenderer {
    private final ResourceLocation texturePath = new ResourceLocation("ftdadditions:textures/models/scientific_research_package.png");
    private final ResourceLocation modelPath = new ResourceLocation("ftdadditions:models/research_package.obj");
    private final IModelCustom researchPackage = new ModelWrapperDisplayList((WavefrontObject) AdvancedModelLoader.loadModel(modelPath));

    @Override
    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        if (type == ItemRenderType.EQUIPPED) { //3th person (in hand)
            glTranslated(0.55, 0.4, 0.5);
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(1.15F, 1.15F, 1.15F);
        } else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) { //1th person
            glTranslated(0.5, 0.5, 0.5);
        } else if (type != ItemRenderType.ENTITY) { //Inventory
            glTranslated(0.5, 0.0, 0.5);
            GL11.glScalef(1.25F, 1.25F, 1.25F);
            GL11.glRotatef(0.0F, 0.0F, -0.1F, 0.0F);
        }
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glTranslated(0.0, 0.5, 0.0); //In World
        GL11.glScalef(1.3F, 1.3F, 1.3F);
        Minecraft.getMinecraft().renderEngine.bindTexture(texturePath);
        researchPackage.renderAll();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }
}
