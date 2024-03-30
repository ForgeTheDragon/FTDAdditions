package ru.forgethedragon.ftdadditions.client.render;

import com.brandon3055.draconicevolution.client.handler.ClientEventHandler;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ru.forgethedragon.ftdadditions.FTDAdditions;
import ru.forgethedragon.ftdadditions.common.entity.EntityChaoticHeart;
import ru.forgethedragon.ftdadditions.handlers.FTDItems;

public class RenderChaoticHeart extends Render {
    //Code taken from Draconic Evolution

    private static final ResourceLocation texture = new ResourceLocation(FTDAdditions.TEXTURES + ":" + "textures/items/heart_chaotic.png");

    private void doRender(EntityChaoticHeart entity, double x, double y, double z, float f) {

        float sine = (float) Math.abs(Math.cos(ClientEventHandler.elapsedTicks / 1000D));

        {
            GL11.glRotatef(entity.rotation + f * entity.rotationInc, 0f, 1f, 0f);
            EntityItem itemEntity = new EntityItem(entity.worldObj, 0, 0, 0, new ItemStack(FTDItems.heartChaotic));
            itemEntity.hoverStart = 0.0F;
            GL11.glScalef(2F, 2F, 2F);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, sine * 100f, sine * 100f);
            RenderItem.renderInFrame = true;
            RenderManager.instance.renderEntityWithPosYaw(itemEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderItem.renderInFrame = false;
        }

        {
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200f, 200f);
            Tessellator tess = Tessellator.instance;
            bindTexture(texture);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glScalef(0.55f, 0.55f, 0.55f);
            GL11.glTranslated(-0.5, -0.15, 0.05);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glColor4f(1f, 1f, 1f, 1f);

            tess.startDrawingQuads();
            tess.addVertexWithUV(0, 1, 0, 0, 0);
            tess.addVertexWithUV(0, 0, 0, 0, 1);
            tess.addVertexWithUV(1, 0, 0, 1, 1);
            tess.addVertexWithUV(1, 1, 0, 1, 0);
            tess.draw();

            GL11.glTranslated(0, 0, -0.12);

            tess.startDrawingQuads();
            tess.addVertexWithUV(0, 1, 0, 0, 0);
            tess.addVertexWithUV(0, 0, 0, 0, 1);
            tess.addVertexWithUV(1, 0, 0, 1, 1);
            tess.addVertexWithUV(1, 1, 0, 1, 0);
            tess.draw();

            GL11.glDisable(GL11.GL_BLEND);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return null;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float f1, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        doRender((EntityChaoticHeart) entity, x, y, z, f2);
        GL11.glPopMatrix();
    }
}
