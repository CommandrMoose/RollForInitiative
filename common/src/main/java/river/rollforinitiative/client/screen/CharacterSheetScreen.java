package river.rollforinitiative.client.screen;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.fabric.api.entity.FakePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Skeleton;
import river.rollforinitiative.common.stat.CharacterStats;

import java.awt.*;

public class CharacterSheetScreen extends Screen {


    public static LivingEntity characterEntity;
    private CharacterStats characterStats;

    public CharacterSheetScreen(CharacterStats characterStats) {
        super(Component.translatable("Character Sheet"));
        this.characterStats = characterStats;
        createCharacterEntity();


    }

    private static void createCharacterEntity() {
        assert Minecraft.getInstance().level != null;
        characterEntity = new Skeleton(EntityType.SKELETON, Minecraft.getInstance().level);
    }


    @Override
    public boolean isPauseScreen() {
        return true;
    }


    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);

        renderEntityInInventory(guiGraphics, width / 2 , height / 4 * 3, height * -0.25f,  characterEntity );

        String characterName = characterStats.getName();

        ScreenHelper.renderWidthScaledText(characterName.toUpperCase(), guiGraphics, Minecraft.getInstance().font, (float) (width / 2), (float) (height * 0.1f), Color.WHITE.getRGB(), (int) (characterName.length() * (0.25 * width)), width * 0.005f, true);
       // ScreenHelper.renderWidthScaledText("RACE, CLASS", guiGraphics, Minecraft.getInstance().font, width / 2, (int)(height * 0.2f), Color.WHITE.getRGB(),  (int)(width * 0.115f), true);


        String stats = "HP: " + characterStats.getHP() + " | AC: " + characterStats.getAC() + " | INIT: " + (characterStats.getINIT() >= 0 ? "+" : "-") + characterStats.getINIT();
        ScreenHelper.renderWidthScaledText(stats, guiGraphics, Minecraft.getInstance().font, width / 2, height - (int)(height * 0.17f), Color.WHITE.getRGB(), (int)(width * 0.25f), (int)(width * 0.25f), true);
        ScreenHelper.renderWidthScaledText("Edit Character", guiGraphics, Minecraft.getInstance().font, width - (int)(width * 0.075f) , height - (int)(height * 0.1f), Color.WHITE.getRGB(), (int)(width * 0.1), (int)(width * 0.1), true);
        ScreenHelper.renderWidthScaledText("Swap Character", guiGraphics, Minecraft.getInstance().font, width - (int)(width * 0.075f) , height - (int)(height * 0.05f), Color.WHITE.getRGB(), (int)(width * 0.1), (int)(width * 0.1), true);
    }



    public static void renderEntityInInventory(GuiGraphics guiGraphics, float x, float y, float scale, LivingEntity livingEntity) {
        Lighting.setupForEntityInInventory();
        PoseStack pose = guiGraphics.pose();
        pose.pushPose();
        pose.translate((float) x, y, 100.0F);
        pose.scale(-scale, scale, scale);
        pose.mulPose(Axis.XP.rotationDegrees(-5F));
        pose.mulPose(Axis.YP.rotationDegrees((float) (System.currentTimeMillis() % 5400L) / 15L));

        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();

        entityRenderDispatcher.setRenderShadow(false);
        RenderSystem.runAsFancy(() -> {
            entityRenderDispatcher.render(livingEntity, 0.0, 0.0, 0.0, 0.0F, 1.0F, guiGraphics.pose(), guiGraphics.bufferSource(), 15728880);
        });
        guiGraphics.flush();
        entityRenderDispatcher.setRenderShadow(true);
        guiGraphics.pose().popPose();
        Lighting.setupFor3DItems();
    }
}
