package river.rollforinitiative.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.awt.*;

public class CharacterCreationScreen extends Screen {
    protected CharacterCreationScreen() {
        super(Component.translatable("Character Creator"));
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }


    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);


        ScreenHelper.renderWidthScaledText("Create Character", guiGraphics, Minecraft.getInstance().font, (float) (width * 0.15f), (float) (height * 0.1f), Color.WHITE.getRGB(), (int) ("Character Creation".length() * (0.25 * width)), width * 0.005f, false);
        // ScreenHelper.renderWidthScaledText("RACE, CLASS", guiGraphics, Minecraft.getInstance().font, width / 2, (int)(height * 0.2f), Color.WHITE.getRGB(),  (int)(width * 0.115f), true);


        //ScreenHelper.renderWidthScaledText(stats, guiGraphics, Minecraft.getInstance().font, width / 2, height - (int)(height * 0.17f), Color.WHITE.getRGB(), (int)(width * 0.25f), (int)(width * 0.25f), true);
        ScreenHelper.renderWidthScaledText("Edit Character", guiGraphics, Minecraft.getInstance().font, width - (int)(width * 0.075f) , height - (int)(height * 0.1f), Color.WHITE.getRGB(), (int)(width * 0.1), (int)(width * 0.1), true);
        ScreenHelper.renderWidthScaledText("Swap Character", guiGraphics, Minecraft.getInstance().font, width - (int)(width * 0.075f) , height - (int)(height * 0.05f), Color.WHITE.getRGB(), (int)(width * 0.1), (int)(width * 0.1), true);
    }

}
