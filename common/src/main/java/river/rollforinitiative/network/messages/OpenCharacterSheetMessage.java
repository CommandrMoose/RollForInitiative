package river.rollforinitiative.network.messages;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import river.rollforinitiative.client.ScreenHandler;
import river.rollforinitiative.common.stat.CharacterStats;
import river.rollforinitiative.network.MessageContext;
import river.rollforinitiative.network.MessageS2C;
import river.rollforinitiative.network.MessageType;
import river.rollforinitiative.network.RFINetwork;

public class OpenCharacterSheetMessage extends MessageS2C {

    private CharacterStats characterStats;

    public OpenCharacterSheetMessage(CharacterStats characterStats) {
        this.characterStats = characterStats;
    }

    public OpenCharacterSheetMessage(FriendlyByteBuf friendlyByteBuf) {
        CompoundTag characterStatTag = friendlyByteBuf.readNbt();
        this.characterStats = CharacterStats.deserialize(characterStatTag);
    }

    @NotNull
    @Override
    public MessageType getType() {
        return RFINetwork.OPEN_CHARACTER_SHEET;
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeNbt(CharacterStats.serialize(characterStats));
    }

    @Override
    public void handle(MessageContext context) {
        handleScreens();
    }

    @Environment(EnvType.CLIENT)
    private void handleScreens() {
        ScreenHandler.openCharacterSheetScreen(characterStats);
    }
}
