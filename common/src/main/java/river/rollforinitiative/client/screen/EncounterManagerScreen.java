package river.rollforinitiative.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.SpriteIconButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import river.rollforinitiative.RollForInitiative;
import river.rollforinitiative.client.screen.components.CommonRFIWidgets;
import river.rollforinitiative.network.messages.StartEncounterMessage;

import java.awt.*;

public class EncounterManagerScreen extends Screen {

    private BlockPos encounterOrigin;

    public static final ResourceLocation START_TEXTURE = new ResourceLocation(RollForInitiative.MODID, "start");

    public EncounterManagerScreen(BlockPos encounterOrigin) {
        super(Component.translatable("Encounter Manager"));

        this.encounterOrigin = encounterOrigin;
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);
        int textOffset = height / 2;

        guiGraphics.drawString(Minecraft.getInstance().font, Component.translatable("Encounter Manager").getString(), width / 2 - 96, textOffset, Color.WHITE.getRGB());

        SpriteIconButton startEncounter = this.addRenderableWidget(CommonRFIWidgets.imageButton(20, Component.translatable("Submit"), (arg) -> {
            new StartEncounterMessage(encounterOrigin).send();
            Minecraft.getInstance().setScreen(null);
        }, true, START_TEXTURE));

        startEncounter.setPosition(width / 2 , (height) / 2 );

    }
}
