package river.rollforinitiative.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import river.rollforinitiative.client.screen.CharacterSheetScreen;
import river.rollforinitiative.client.screen.EncounterManagerScreen;
import river.rollforinitiative.common.stat.CharacterStats;

@Environment(EnvType.CLIENT)
public class ScreenHandler {

    @Environment(EnvType.CLIENT)
    public static void openEncounterManagerScreen(BlockPos encounterBlockPosition) {
        Minecraft.getInstance().setScreen(new EncounterManagerScreen(encounterBlockPosition));
    }

    @Environment(EnvType.CLIENT)
    public static void openCharacterSheetScreen(CharacterStats characterStats) {
        Minecraft.getInstance().setScreen(new CharacterSheetScreen(characterStats));

    }
}
