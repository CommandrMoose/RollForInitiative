package river.rollforinitiative.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.awt.*;

public class EncounterManagerScreen extends Screen {
    public EncounterManagerScreen() {
        super(Component.translatable("Encounter Manager"));
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


    }
}
